package se.liu.ida.emiwi425.tddd78.lab3;

import java.awt.*;
import java.util.Objects;

public abstract class AbstractShape implements Shape
{

    @Override public boolean equals(final Object o) {
	if (this == o) return true;			//is this legit?
	if (o == null || getClass() != o.getClass()) return false;
	final AbstractShape that = (AbstractShape) o;
	return x == that.x &&
	       y == that.y &&
	       Objects.equals(color, that.color);
    }

    @Override public int hashCode() {
	return Objects.hash(x, y, color);
    }

    protected int x;
    protected int y;
    protected Color color;

    public AbstractShape(final int x, final int y, final Color color) {
	this.x = x;
	this.y = y;
	this.color = color;
    }

    @Override public int getX() {
	return x;
    }

    @Override public int getY() {
	return y;
    }

    @Override public Color getColor() {
	return color;
    }
}
