package se.liu.ida.emiwi425.tddd78.lab3;

import se.liu.ida.emiwi425.tddd78.lab2.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Stack extends ListManipulator
{
    private List<Person> elements = new ArrayList<Person>();

    public void push(Person person){
	elements.add(0,person);

    }
    public Person pop(){
        return elements.remove(0);


    }



}






