package se.liu.ida.emiwi425.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;


/**
* This class handels the icon that is showed in the beginning of the game. How long the
 * icon is visible can be adjusted in the board via the constant "TIME_FOR_ICON_TO_DISAPPEAR".
 *
*/

public class IconViewer extends JComponent {


    private static final double SCALE_X = 0.7;
    private static final double SCALE_Y = 0.7;

    private final ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("blackhole.jpg"));

    public void paintComponent(final Graphics g)  {
        final Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(    RenderingHints.KEY_ANTIALIASING,
        			 RenderingHints.VALUE_ANTIALIAS_ON);


        final AffineTransform old = g2d.getTransform();

	// Steg 4: Gör ingenting (skala faktor 1)
	final AffineTransform at = AffineTransform.getScaleInstance(0.6,0.6);

	// Steg 3:  Flytta (i "oskalade" koordinater)
	at.translate(0,0);

	// Steg 2:  Skala ner alla koordinater
	at.scale(SCALE_X, SCALE_Y);

	g2d.setTransform(at);

	// Steg 1:  Starta på (0,0)
	icon.paintIcon(this, g, 0, 0);

	g2d.setTransform(old);
    }
}
