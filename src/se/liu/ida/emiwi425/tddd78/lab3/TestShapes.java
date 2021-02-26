package se.liu.ida.emiwi425.tddd78.lab3;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public final class TestShapes
{

    public static void main(String[] args) {


	List<Shape> shapes = new ArrayList<>();

	Circle a = new Circle(10,10,20,Color.WHITE);
	Circle b = new Circle(5,5,45,Color.BLUE);
	Rectangle c = new Rectangle(10,10,10,10,Color.WHITE);
	Rectangle d = new Rectangle(34,45,10,56,Color.WHITE);
	Text e = new Text(10,10,10,Color.BLUE,"Hej jag heter Emil");
	Text f = new Text(20,20,20,Color.WHITE, "En Sträng!");

	shapes.add(a);
	shapes.add(b);
	shapes.add(c);
	shapes.add(d);
	shapes.add(e);
	shapes.add(f);


	for (Shape shape : shapes) {
	    System.out.println("LEFT_ALIGNED is " + shape.getX() + " and Y is " + shape.getY());
	    //shape.draw();

	}
    }
}
