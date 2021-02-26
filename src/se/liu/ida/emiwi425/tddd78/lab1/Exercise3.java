package se.liu.ida.emiwi425.tddd78.lab1;

import javax.swing.*;

public class Exercise3
{
    private final static int TABELL = 5;

    public static void main(String[] args) {
        String input =
		JOptionPane.showInputDialog("Please input a value");

        int tabell = Integer.parseInt(input);

	int i = 0;
	while (i <= 12) {
	    int product = i * tabell;
	    System.out.println(i + " * " + tabell + " = " + product);
	    i += 1;

	}

    }

}


