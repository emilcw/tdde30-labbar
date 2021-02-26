package se.liu.ida.emiwi425.tddd78.lab3;

import java.awt.*;

public interface Shape
{
    public void draw(final Graphics g);

    int getX();

    int getY();

    Color getColor();
}
