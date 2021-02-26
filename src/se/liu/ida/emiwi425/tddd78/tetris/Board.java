package se.liu.ida.emiwi425.tddd78.tetris;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static se.liu.ida.emiwi425.tddd78.tetris.SquareType.*;

/**
 * The board controls the different events that can occur in our game.
 * It creates the board and updates the positions of the different tetrominos.
 * Moreover is spawns new tetrominos and checks the current state of the one that is falling
 * and those who have already fallen.
 */

public class Board
{

    private static final int BORDER = 2;
    private static final int ONE_ROW_SCORE = 100;
    private static final int TWO_ROW_SCORE = 300;
    private static final int THREE_ROW_SCORE = 500;
    private static final int FOUR_ROW_SCORE = 800;
    private static final int TIME_FOR_ICON_TO_DISAPPEAR = 5;


    private SquareType[][] squares;
    private int width;
    private int height;
    private int score;
    private int fullLines;
    private int fallingX, fallingY;
    private int timeElapsed;
    private boolean gameOver;
    private boolean isFullRow;
    private Random rnd;
    private Poly falling;
    private List<BoardListener> listeners;
    private TetrisViewer viewer = null;                //We need a board to create a viewer, therefore we set the viewer afterwards.


    public Board(final int width, final int height) {

	this.gameOver = false;
	this.isFullRow = false;
	this.width = width;
	this.height = height;
	final int outsideWidth = (BORDER + width + BORDER);
	final int outsideHeight = (BORDER + height + BORDER);
	this.fallingX = (width / 2) - 1;
	this.fallingY = 0;
	this.score = 0;
	this.fullLines = 0;
	this.timeElapsed = 0;
	this.rnd = new Random();
	squares = new SquareType[outsideWidth][outsideHeight];
	listeners = new ArrayList<>();
	TetrominoMaker fac = new TetrominoMaker();
	this.falling = fac.getPoly(rnd.nextInt(fac.getNumberOfTypes()));
	createBoard();
    }


    public void restartGame() {
	this.gameOver = false;
	this.timeElapsed = 0;
	this.score = 0;
	createBoard();
	this.falling = null;                        //Need to set it to null, otherwise something is still falling
	spawnPoly();
    }


    public void createBoard() {
	for (int rows = 0; rows < squares.length; rows++) {
	    for (int columns = 0; columns < squares[0].length; columns++) {
		if (rows < BORDER || columns < BORDER || (rows > width + BORDER - 1) || (columns > height + BORDER - 1)) {

		    squares[rows][columns] = OUTSIDE;
		} else {
		    squares[rows][columns] = EMPTY;
		}
	    }
	}
	this.notifyListeners();
    }


    public void addBoardListener(BoardListener bl) {
	listeners.add(bl);

    }


    private void notifyListeners() {
	for (BoardListener boardlistener : listeners) {
	    boardlistener.boardChanged();
	}
    }


    public SquareType getSquareAt(int x, int y) {
	if (falling == null) {
	    return squares[x + BORDER][y + BORDER];
	}
	if ((fallingX <= x && x < (fallingX + falling.getWidth())) && (fallingY <= y && y < (fallingY + falling.getHeight()))) {
	    if (falling.getShape()[x - fallingX][y - fallingY] == EMPTY) {
		return this.getSquareType(x, y);
	    }
	    return falling.getPolyType((x - fallingX), (y - fallingY));
	} else {
	    return this.getSquareType(x, y);

	}
    }


    public void tick() {
	    if (!gameOver) {
		timeElapsed++;
		if (timeElapsed == TIME_FOR_ICON_TO_DISAPPEAR ) {
		    viewer.removeIcon();
		} else {
		    rowsToRemove();
		    updateScoreLabel();
		    fallingY++;
		    if (hasCollision()) {
			connectTetrominoToBoard();
			falling = null;                        //Must be assigned to null otherwise something is still falling
			spawnPoly();
			if (hasCollision()) {
			    gameOver = true;
			    viewer.addHighScore();
			}
		    }

		    this.notifyListeners();
		}
	    }
	}



    public void connectTetrominoToBoard(){
	fallingY--;
	for (int w = 0; w < falling.getWidth(); w++) {
	    for (int h = 0; h < falling.getHeight(); h++) {
		if (falling.getPolyType(w, h) != EMPTY) {
		    squares[w + fallingX + BORDER][h + fallingY + BORDER] = falling.getPolyType(w, h);

		}
	    }
	}
    }


    public void spawnPoly() {
	this.fallingX = (width / 2) - 1;
	this.fallingY = 0;
	TetrominoMaker fac = new TetrominoMaker();
	this.falling = fac.getPoly(rnd.nextInt(fac.getNumberOfTypes()));
	this.notifyListeners();
    }


    public void moveLeft() {
	fallingX--;
	if (hasCollision()) {
	    fallingX++;
	}
	this.notifyListeners();
    }


    public void moveRight() {
	fallingX++;
	if (hasCollision()) {
	    fallingX--;
	}
	this.notifyListeners();
    }


    public void moveDown() {
	fallingY++;
	if (hasCollision()) {
	    fallingY--;
	}
	this.notifyListeners();
    }


    public void updateScoreLabel() {
	String points = Integer.toString(score);
	viewer.getScorelabel().setText("SCORE: " + points);
    }


    public void updateScore() {
	switch (fullLines) {
	    case 1:
		score += ONE_ROW_SCORE;
		break;
	    case 2:
		score += TWO_ROW_SCORE;
		break;
	    case 3:
		score += THREE_ROW_SCORE;
		break;
	    case 4:
		score += FOUR_ROW_SCORE;
		break;
	    default:
		//No full row
		break;
	}
	fullLines = 0;
    }


    public boolean hasCollision() {
	if (falling == null) {
	    return false;
	}
	for (int w = 0; w < falling.getWidth(); w++) {
	    for (int h = 0; h < falling.getHeight(); h++) {

		if (falling.getPolyType(w, h) != EMPTY && getSquareType((fallingX + w), (fallingY + h)) != EMPTY) {
		    return true;
		}
	    }
	}
	return false;
    }


    public void rotatePolyLeft() {

	if (!gameOver) {

	    Poly rotated = falling.rotate(false);
	    Poly original = falling;
	    falling = rotated;
	    if (hasCollision()) {
		falling = original;
	    }
	}
	this.notifyListeners();
    }


    public void rotatePolyRight() {

	if (!gameOver) {

	    Poly rotated = falling.rotate(true);
	    Poly original = falling;
	    falling = rotated;
	    if (hasCollision()) {
		falling = original;

	    }
	}
	this.notifyListeners();
    }


    private void rowsToRemove() {

	for (int row = 1; row < height + BORDER; row++) {
	    for (int column = 1; column < width + BORDER; column++) {
		if (squares[column][row] == EMPTY) {
		    updateScore();
		    isFullRow = false;
		    break;
		}
		if (column == width + 1 && row > 1 && isFullRow) {
		    fullLines++;
		    removeRow(row);

		}
		isFullRow = true;
	    }
	}
	this.notifyListeners();
    }


    private void removeRow(int startRow) {
	for (int row = startRow; row > BORDER; row--) {
	    for (int column = BORDER; column < width + BORDER; column++) {
		squares[column][row] = squares[column][row - 1];
	    }
	}
	this.notifyListeners();
    }

    public int getScore() { return score; }

    public int getWidth() { return width; }

    public int getHeight() { return height; }

    public SquareType getSquareType(int x, int y) { return squares[x + BORDER][y + BORDER]; }

    public void setViewer(final TetrisViewer viewer) { this.viewer = viewer; }

}







