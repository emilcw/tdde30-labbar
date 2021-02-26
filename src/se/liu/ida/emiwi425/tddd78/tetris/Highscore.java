package se.liu.ida.emiwi425.tddd78.tetris;

/**
    * The highscore object consists of a name and a highscore connected to that person.
    * Its toString method describes how it is printed on the scoreboard.
    */

public class Highscore {

    private int highscore;
    private String name;

    public Highscore(final int highscore, final String name) {
	this.highscore = highscore;
	this.name = name;
    }


    @Override
    public String toString(){
        StringBuilder builder  = new StringBuilder();
    	builder.append(name);
    	builder.append(": ");
        builder.append(highscore);
        return builder.toString();
    }


    public int getHighscore() {
  	return highscore;
      }
}
