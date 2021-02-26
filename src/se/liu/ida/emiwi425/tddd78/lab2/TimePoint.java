package se.liu.ida.emiwi425.tddd78.lab2;

public class TimePoint
{

    private int hour;
    private int minute;


    public TimePoint(final int hour, final int minute) {
	this.hour = hour;
	this.minute = minute;
    }

    public int getHour() {
	return hour;
    }

    public int getMinute() {
	return minute;
    }

    @Override public String toString() {
	return String.format("%02d:%02d",this.hour,this.minute);

    }

    public static void main(String[] args) {
	}
    }

