package se.liu.ida.emiwi425.tddd78.lab3;

import java.awt.*;

public class Rectangle extends AbstractShape
{

    private int width;
    private int height;


    public Rectangle(final int x, final int y , final int height,  final int width, final Color color) {
	super(x, y, color);

        if( (width < 0) || (height < 0 )){
            throw new IllegalArgumentException("Negativ bredd eller höjd!");
	}
	this.width = width;
	this.height = height;
    }

    @Override public String toString() {
	return "Rectangle{" + "x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + ", color=" + color + '}';
    }

    @Override public void draw(final Graphics g) {
        //System.out.println("Ritar "+this);
	g.setColor(color);
	g.drawRect(x,y,width,height);




    }

}
