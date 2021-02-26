package se.liu.ida.emiwi425.tddd78.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;


/**
 * The "main-class", by running this code the main-loop will start
 * and you can play the game.
 */

public final class Tetris {

    private final static int WIDTH = 16;
    private final static int HEIGHT = 20;
    private final static int DELAY = 500;

    private Tetris() {}

    public static void main(String[] args) {

	Board b = new Board(WIDTH, HEIGHT);
	TetrisViewer t = new TetrisViewer(b);
	b.setViewer(t);


	final Action doOneStep = new AbstractAction() {
	    //ActionListener doOneStep  = new ActionListener(){
	    public void actionPerformed(ActionEvent e) {
		    b.tick();
		}
	};

	final Timer clockTimer = new Timer(DELAY, doOneStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();


    }

}











