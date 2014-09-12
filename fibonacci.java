import java.io.*;
import java.util.*;

public class fibonacci {

	//int x1 , x2;

//	int x1 = 0;
//	int x2 = 1;
//	public int sum;

	public static double getNext(double first , double second) {
		double value = first + second;
		return value;
	}

	public static void fibCalc(int TERM) {
		double x1 = 0;
		double x2 = 1;
		double i = 2;
		double sum = 0;
		while (TERM >= i) {
			//Store the sum in a value
			sum = getNext(x1, x2);
			//Reorder the variables
			x1 = x2;
			x2 = sum;
			i += 1;
		}
		switch(TERM) {
			case 0 :
				System.out.println("0");
			case 1 :
				System.out.println("1");
			default :
				System.out.println(sum);
		}
	}

	public static void main(String[] args) {
		System.out.println("Which Fibonacci number would you like to know: ");
		Scanner reader = new Scanner(System.in);
		int FIB = reader.nextInt();
		fibCalc(FIB);
	}

}
