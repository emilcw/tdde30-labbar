package se.liu.ida.emiwi425.tddd78.lab2;

public class TimeSpan
{
    private TimePoint start;
    private TimePoint end;


    @Override public String toString() {
	return this.start + " - " + this.end+" ";
    }

    public TimePoint getStart() {
	return start;
    }

    public TimePoint getEnd() {
	return end;
    }

    public TimeSpan(final TimePoint start, final TimePoint end) {
	this.start = start;
	this.end = end;
    }

    public static void main(String[] args) {

    }

}
