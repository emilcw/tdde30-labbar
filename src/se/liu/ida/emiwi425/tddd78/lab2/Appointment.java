package se.liu.ida.emiwi425.tddd78.lab2;

public class Appointment
{
    private String subject;
    private Date date;
    private TimeSpan timeSpan;



    @Override public String toString() {
	return "Appointment " + this.date + this.timeSpan + this.subject;
    }

    public String getSubject() {
	return subject;
    }

    public Date getDate() {
	return date;
    }

    public TimeSpan getTimeSpan() {
	return timeSpan;
    }

    public Appointment(final String subject, final Date date, final TimeSpan timeSpan) {
	this.subject = subject;
	this.date = date;
	this.timeSpan = timeSpan;
    }
}
