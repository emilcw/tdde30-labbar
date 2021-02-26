package se.liu.ida.emiwi425.tddd78.lab3;

import java.util.ArrayList;
import java.awt.Color;
import java.util.List;


public final class TestCircle
{

    public static void main(String[] args) {


	List<Circle> circles = new ArrayList<>();

	Circle a = new Circle(12,10,20,Color.WHITE);
	Circle b = new Circle(5,5,-6,Color.BLUE);

	circles.add(a);
	circles.add(b);



	for (Circle circle : circles) {
	    System.out.println("LEFT_ALIGNED is " + circle.getX() + " and Y is " + circle.getY());

	}
    }
}
