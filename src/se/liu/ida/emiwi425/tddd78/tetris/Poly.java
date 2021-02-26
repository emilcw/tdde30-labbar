package se.liu.ida.emiwi425.tddd78.tetris;

/**
  * A poly is a general type of blueprint in which we can create any type of
  * tetromino. Here we define it and give it different abilities such as rotating.
  */


public class Poly {

    private SquareType[][] poly;
    private int height, width;


    public Poly(final SquareType[][] poly) {
	this.poly = poly;
	this.width = poly[0].length;
	this.height = poly.length;
    }

    public Poly rotateRight() {

	Poly newPoly = new Poly(new SquareType[width][height]);

	for (int r = 0; r < width; r++) {
	    for (int c = 0; c < height; c++) {
		newPoly.poly[c][height - 1 - r] = this.poly[r][c];
	    }
	}
	return newPoly;
    }

    public Poly rotateLeft(){

        Poly newPoly = new Poly(new SquareType[width][height]);

	for (int r = 0; r < width; r++) {
	    for (int c = 0; c < height; c++) {
		newPoly.poly[r][c] = this.poly[c][height - 1 - r];
	    }
	}
        return newPoly;
    }

    public Poly rotate(boolean clockwise){
        Poly newPoly;
        if (clockwise){
            newPoly = rotateRight();
	}else{
            newPoly = rotateLeft();
	}
        return newPoly;
    }

    public SquareType[][] getShape() {
	return poly;
    }

    public SquareType getPolyType(int width, int height) {return poly[width][height]; }

    public int getHeight() {
	return height;
    }

    public int getWidth() {
	return width;
    }

}


