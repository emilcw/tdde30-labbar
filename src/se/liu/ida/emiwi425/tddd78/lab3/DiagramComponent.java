package se.liu.ida.emiwi425.tddd78.lab3;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DiagramComponent extends JComponent
{

    private List<Shape> shapes;

    @Override protected void paintComponent(final Graphics g) {
    	super.paintComponent(g);
	for (Shape shape : shapes) {
	    shape.draw(g);

	}

	}
    public DiagramComponent() {
	this.shapes = new ArrayList<>();
    }

    public void addShape(Shape s){
	shapes.add(s);


    }


}
