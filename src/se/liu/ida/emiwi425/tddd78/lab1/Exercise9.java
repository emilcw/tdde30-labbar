package se.liu.ida.emiwi425.tddd78.lab1;

import javax.swing.*;

public class Exercise9
{

    public static double findRoot(double x) {
	double guess = x;

	for (int i = 0; i <= 10; i++) {

	    guess=guess-(guess*guess-x)/(2*guess);
	    i+=1;

	}

        return guess;
    }

    public static void main(String[] args) {
	String a = JOptionPane.showInputDialog("Please input a value");
	double x = Double.parseDouble(a);
	System.out.println("Roten ur"+ x + "är" + findRoot(x));

    }
}
