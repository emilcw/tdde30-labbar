package se.liu.ida.emiwi425.tddd78.lab2;

import java.time.LocalDate;
import java.time.Period;

public class Person
{
	private String name;
	private LocalDate birthday;
	String namn = "Anders Andersson";


    public int getAge(){
	Period lifespan = Period.between(this.birthday, LocalDate.now());
	int age = lifespan.getYears();

	return age;
    }


    public Person(final String name, final LocalDate birthday){
	this.name = name;
	this.birthday = birthday;

    }

    @Override public String toString() {
	return this.name + " " + getAge() ;
    }

    public static void main(String[] args) {
	Person me = new Person("Emil", LocalDate.of(1855,4,1));
	Person a =  new Person("Jocke", LocalDate.of(1990,5,7));
	Person b = new Person("Karin", LocalDate.of(1999,3,10));


	System.out.println(b);
	System.out.println(a);
	System.out.println(me);

    }
}




