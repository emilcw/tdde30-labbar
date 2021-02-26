package se.liu.ida.emiwi425.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.EnumMap;
import static java.awt.Color.*;
import static se.liu.ida.emiwi425.tddd78.tetris.SquareType.*;

/**
 * This class paints the board and gives us graphic.
 * It also handles the different keyboard events.
 *
 */

public class TetrisComponent extends JComponent implements BoardListener {

    private Board brd;
    private final static int SQUARE_WIDTH = 30;
    private final static int SQUARE_HEIGHT = 30;
    private final static int SQUARE_MULTIPLIER = 31;

    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
    private static final String MOVE_LEFT = "move left";
    private static final String MOVE_RIGHT = "move right";
    private static final String MOVE_DOWN = "move down";
    private static final String ROTATE_RIGHT = "rotate right";
    private static final String ROTATE_LEFT = "rotate left";



    public TetrisComponent(final Board brd) {
	this.brd = brd;
	movePoly();
    }


    @Override
    public Dimension getPreferredSize(){
	super.getPreferredSize();
	int width = (SQUARE_WIDTH + 5) * brd.getWidth();
	int height = (SQUARE_HEIGHT + 5) * brd.getHeight();
	return new Dimension(width, height);
    }


    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);

	for (int rows = 0; rows < brd.getWidth(); rows++) {
	    for (int columns = 0; columns < brd.getHeight(); columns++) {

		final Graphics g2d = g;			//Redundant but improving readability
		SquareType pos = brd.getSquareAt(rows, columns);
		g2d.setColor(getColor(pos));
        	g2d.drawRect( rows *SQUARE_MULTIPLIER, columns*SQUARE_MULTIPLIER, SQUARE_WIDTH,SQUARE_HEIGHT);
		g2d.fillRect( rows *SQUARE_MULTIPLIER, columns*SQUARE_MULTIPLIER, SQUARE_WIDTH - 1 ,SQUARE_HEIGHT - 1);
	        }
	    }
    	}


    private static EnumMap<SquareType,Color> colorTable = new EnumMap<>(SquareType.class);


    private class MoveLeft extends AbstractAction {
	@Override public void actionPerformed(final ActionEvent e) {
    	brd.moveLeft();

	}
   }


    private class MoveRight extends AbstractAction{
	@Override public void actionPerformed(final ActionEvent e) {
    	brd.moveRight();

	}
   }


    private class MoveDown extends AbstractAction{
	@Override public void actionPerformed(final ActionEvent e) {
    	brd.moveDown();

	}
   }


    private class RotateRight extends AbstractAction{
	@Override public void actionPerformed(final ActionEvent e) {
    	brd.rotatePolyRight();

	}
   }


    private class RotateLeft extends AbstractAction{
    	@Override public void actionPerformed(final ActionEvent e) {
	brd.rotatePolyLeft();

    	}
       }


    public void movePoly() {

    final InputMap in = this.getInputMap(IFW);
    final ActionMap act = this.getActionMap();

    in.put(KeyStroke.getKeyStroke("LEFT"), MOVE_LEFT);
    act.put(MOVE_LEFT, new MoveLeft());

    in.put(KeyStroke.getKeyStroke("RIGHT"), MOVE_RIGHT);
    act.put(MOVE_RIGHT, new MoveRight());

    in.put(KeyStroke.getKeyStroke("SPACE"),MOVE_DOWN);
    act.put(MOVE_DOWN, new MoveDown());

    in.put(KeyStroke.getKeyStroke("UP"),ROTATE_RIGHT);
    act.put(ROTATE_RIGHT, new RotateRight());

    in.put(KeyStroke.getKeyStroke("DOWN"),ROTATE_LEFT);
    act.put(ROTATE_LEFT, new RotateLeft());

   }


    public Color getColor(SquareType s) {

    colorTable.put(EMPTY,WHITE);
    colorTable.put(I,CYAN);
    colorTable.put(J,BLUE);
    colorTable.put(L,ORANGE);
    colorTable.put(O,YELLOW);
    colorTable.put(T,MAGENTA);
    colorTable.put(Z,RED);
    colorTable.put(S,GREEN);
    colorTable.put(OUTSIDE,BLACK);

    return colorTable.get(s);

    }


    @Override public void boardChanged() {
	repaint();
    }

}


