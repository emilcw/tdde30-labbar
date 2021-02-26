package se.liu.ida.emiwi425.tddd78.lab1;

import javax.swing.*;

public class Exercise2
{
    public static int sumFor(int min, int max) {

        int sum = 0;

        for(int i = min; i <= max;i++) {
            sum = sum + i;
	}
        return sum;
    }


    public static int sumWhile(int min, int max){

        int sum = 0;

        while(min <= max){
            sum = sum + min;
            min++;
	}
        return sum;
    }


    public static void main(String[] args) {
	String input = JOptionPane.showInputDialog("Please select for or while");

	int min = 10;
    	int max = 11;
	switch(input){

	    case "for":
	    	System.out.println(sumFor(min,max));
	    	break;

	    case "while":
		System.out.println(sumWhile(min,max));
		break;

	    default:
		System.out.println("Invalid statement");
	        break;


	}

    }

}

