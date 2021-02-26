package se.liu.ida.emiwi425.tddd78.tetris;

/**
    * A converter that converts our board into text so
    * we can easily visualize it from the terminal. Currently not used but may be use
    * useful for further development.
    */

public final class BoardToTextConverter {		//see javadoc


    private BoardToTextConverter() {}

    public static String convertToText(Board brd) {	//See javadoc

	StringBuilder builder = new StringBuilder();

	for (int rows = 0; rows < brd.getWidth(); rows++) {

	    if(rows == 0){
	        //Do nothing since we are still on the first row

	    }else{
	        builder.append("\n");
	    }

	    for (int columns = 0; columns < brd.getHeight(); columns++) {

		SquareType pos = brd.getSquareAt(rows, columns);

		switch (pos) {

		    case EMPTY:
			builder.append("-");
			break;

		    case I:
			builder.append("!");
			break;

		    case O:
			builder.append("¤");
			break;

		    case S:
			builder.append("$");
			break;


		    case J:
			builder.append("&");
			break;

		    case L:
			builder.append("#");
			break;

		    case Z:
			builder.append("+");
			break;

		    case T:
			builder.append("%");
			break;

		    case OUTSIDE:
			builder.append(".");
			break;

		    default:
			return "ERROR";

		}
	    }
	}
	String result = builder.toString();
	return result;
    }
}










