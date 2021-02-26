package se.liu.ida.emiwi425.tddd78.lab3;

import java.awt.*;

public class Text extends AbstractShape
{

    private int size;
    private String text;

    @Override public String toString() {
	return "Text{" + "x=" + x + ", y=" + y + ", size=" + size + ", color=" + color + ", text='" + text + '\'' + '}';
    }

    @Override public void draw(final Graphics g) {
	//System.out.println("Ritar: "+this);
    	g.setColor(color);
    	g.setFont(new Font("serif", Font.PLAIN, size));
    	g.drawString(text,x,y);


    }

    public Text(final int x, final int y, final int size, final Color color, final String text) {
	super(x, y, color);

        if( size < 0 ){
            throw new IllegalArgumentException("Negative size");
	}

	this.size = size;
	this.text = text;

    }
}
