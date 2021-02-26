package se.liu.ida.emiwi425.tddd78.lab3;

import java.time.LocalDate;


import se.liu.ida.emiwi425.tddd78.lab2.Person;


public class TestStackQueue
{
    public static void main(String[] args) {
	Stack s = new Stack();

	Person me = new Person("Emil", LocalDate.of(1856, 4, 1));
	Person a = new Person("Maja", LocalDate.of(1856,1,1));
	Person b = new Person("Daniel", LocalDate.of(1889,4,1));
	Person c = new Person("Sara", LocalDate.of(2045,3,1));
	Person d = new Person("Bo", LocalDate.of(2054,7,1));


	s.push(me);
	s.push(a);
	s.push(b);
	s.push(c);
	s.push(d);

	while(!(s.isEmpty())){
	    System.out.println(s.pop());	//Sist in, först ut

	}

	Queue q = new Queue();

	q.enqueue(me);
	q.enqueue(a);
	q.enqueue(b);
	q.enqueue(c);
	q.enqueue(d);

	while(!(q.isEmpty())){
	    System.out.println(q.dequeue());	//Först in, först ut

	}
    }
}
