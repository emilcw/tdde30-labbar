package se.liu.ida.emiwi425.tddd78.lab3;

import se.liu.ida.emiwi425.tddd78.lab2.Person;


public class Queue extends ListManipulator
{

    public void enqueue(Person person){
        elements.add(person);

    }

    public Person dequeue(){
        return elements.remove(0);


    }

}






