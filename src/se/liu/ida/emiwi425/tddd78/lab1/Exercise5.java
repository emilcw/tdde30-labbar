package se.liu.ida.emiwi425.tddd78.lab1;

public class Exercise5
{
    public static boolean isPrime(int number) {

	for (int i = 2; i < number - 1; i++) {

	    int rest = number % i;
	    if (rest == 0) {
		return false;

	    }
	}
	return true;
    }

    public static void main(String[] args) {

	for (int i = 2; i < 100 ; i++) {
	    if(isPrime(i)){
		System.out.println(i);
	    }

	}

    }
}

