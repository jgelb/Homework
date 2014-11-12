import java.util.*;
import java.io.*;

public class Exec{
	public static void main(String[] args){
		//Create an array list of Integers
		ArrayList<Integer> a = new ArrayList<Integer>();
		Random r = new Random();
		for (int i = 0; i < 25; i++){
			a.add(r.nextInt(10));
		}
		System.out.println("Initial array:      " + a);
		for (int i = 0; i < a.size() - 1; i++){
			if (a.get(i) == a.get(i + 1)){
				a.remove(i + 1);
				i--; //Yet another OBOE. BinEx time!
			}
		}
		System.out.println("Cleaned Duplicates: " + a);
	}
}
