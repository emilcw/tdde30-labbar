package se.liu.ida.emiwi425.tddd78.tetris;

import java.util.Comparator;


/**
  * A comparator to compare to objects. In our case we compare differnt highscores
 * to determine which one is greater than the other.
  */

public class ScoreComparator implements Comparator<Highscore> {

    @Override public int compare(final Highscore highscore1, final Highscore highscore2) {

        //Valid but we want to use the "proper" way of comparing
	if (highscore1.getHighscore() < highscore2.getHighscore()) {
	    return -1;

	} else if (highscore1.getHighscore() > highscore2.getHighscore()) {
	    return 1;

	} else {
		return 0;
	    }

	}
    }