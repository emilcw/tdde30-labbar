package se.liu.ida.emiwi425.tddd78.lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Calendar
{
    private List<Appointment> appointments;


	public String show(List list){

	    for (Object app : list) {		//Få den att iterera över appointment, inte över object
		System.out.println(app);
	    }
	    return null;
	}

	public void book(int year, String month, int day,
			 int startHour, int startMinute, int endHour,
			 int endMinute, String subject) {

	    if (year <= 1970) {
		throw new IllegalArgumentException("Not valid, year");

	    } else if (startHour > 24 || startHour < 0) {
		throw new IllegalArgumentException("Not valid, hour");

	    } else if (Month.getMonthNumber(month) == -1){
	    throw new IllegalArgumentException("Not valid, month");

	    } else if ( day < 0 || day > Month.getMonthDays(month) ) {
		throw new IllegalArgumentException("Not valid, day ");
	    }

	    Month mon = new Month(month,Month.getMonthNumber(month),Month.getMonthDays(month));
	    Date date = new Date(year, mon, day);
	    TimePoint start = new TimePoint(startHour,startMinute);
	    TimePoint end = new TimePoint(endHour,endMinute);
	    TimeSpan span = new TimeSpan(start,end);
	    Appointment app = new Appointment(subject, date, span);

	    appointments.add(app);
	    System.out.println("Your appointment has been boked");

	}

	public Calendar() {
        this.appointments = appointments;
        appointments = new ArrayList<>();
    }

    public static void main(String[] args) {
	Calendar kalendar = new Calendar();
	Random rnd = new Random();

	for (int i = 0; i <= rnd.nextInt(10)+ 5 ; i++) {
	    int year = rnd.nextInt(2100)+ 1970;
	    int day = rnd.nextInt(28);
	    int starth = rnd.nextInt(24);
	    int startmin = rnd.nextInt(60);
	    int endh = rnd.nextInt(24);
	    int endmin = rnd.nextInt(60);

	    kalendar.book(year,"January",day,starth,startmin,endh,endmin,"Gå ut med hunden");

	}
	kalendar.show(kalendar.appointments);
    }
}






