package se.liu.ida.emiwi425.tddd78.LabP;

public class NumberTester
{
    private NumberTester() {}

    public static boolean isEven(int number) {
        int remainder = number % 2;
        return remainder == 0;
    }

    public static void main(String[] args) {
        System.out.println(isEven(17));
        System.out.println(isEven(42));
    }
}