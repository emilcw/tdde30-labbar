package se.liu.ida.emiwi425.tddd78.lab1;

import javax.swing.*;

public class Exercise8
{
   public static boolean askUser(String question) {
	return JOptionPane.showConfirmDialog(null, question, "",
	  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
   }


    public static void main(String[] args) {
	while(true){
	    if (askUser("Quit?") && askUser("Really?")){
	        return;
	   }

	    //if (askUser("Quit?") & askUser("Really?")){
	      //  return;
	   // }

	}

	}

    }



