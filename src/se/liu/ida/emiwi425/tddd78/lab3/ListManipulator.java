package se.liu.ida.emiwi425.tddd78.lab3;

import se.liu.ida.emiwi425.tddd78.lab2.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class ListManipulator
{
    protected List<Person> elements = new ArrayList<Person>();

    public int size() {return elements.size();}

    public boolean isEmpty() {return elements.isEmpty();}

    public boolean containsAll(final Collection<?> collection) {return elements.containsAll(collection);}

    public void clear() {elements.clear();}


    }

