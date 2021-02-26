package se.liu.ida.emiwi425.tddd78.lab2;

public class Date {

    private int year;
    private Month month;
    private int day;



    @Override public String toString() {
	return this.year + "-" + month.getNumber() + "-" + this.day+" ";
    }

    public int getYear() {
	return year;
    }

    public Month getMonth() {
	return month;
    }

    public int getDay() {
	return day;
    }

    public Date(final int year, final Month month, final int day) {
	this.year = year;
	this.month = month;
	this.day = day;
    }
    public static void main(String[] args) {

    }
}
