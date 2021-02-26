package se.liu.ida.emiwi425.tddd78.lab1;

public class Exercise10
{

    public static void main(String[] args) {
	int tal = 16777217;
	double decimaltal = tal;
	int tillbaka = (int)decimaltal;	//Vi vill verkligen ta bort decimaler
	int big = 2147483647;
	//long bigger = big +1L;
	long bigger = (long)big+1;



	//System.out.println(tal);
	//System.out.println(decimaltal);
	//System.out.println(tillbaka);
	System.out.println(big);
	System.out.println(bigger);

    }
}
