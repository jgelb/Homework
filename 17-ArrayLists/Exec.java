import java.util.*;
import java.io.*;

public class Exec{
	public static void main(String[] args){
		int lastNum = 10;
		if (args.length > 0){
			try {
				lastNum = Integer.parseInt(args[0]);
			} catch(Exception e){lastNum = 10;}
		}
		ArrayList<Integer> ai = new ArrayList<Integer>();
		for (int i = 0; i <= lastNum; i++){
			ai.add(i);
		}
//		System.out.println("Original Array: " + ai);
		//Time Efficient :D :D :D :D :D
/* 		Try 1
		ArrayList<Integer> answer = new ArrayList<Integer>();
		Random r = new Random();
		while (ai.size() != 0){
			int a = r.nextInt(ai.size());
			answer.add(ai.get(a));
			ai.remove(a);
		}
*/
//		Try 2
		Random r = new Random();
		while (lastNum >= 0){
			int a = r.nextInt(lastNum + 1);
			int tmp = ai.get(a);
			ai.set(a , ai.get(lastNum));
			ai.set(lastNum , tmp);
			lastNum--;
		}

		System.out.println("Randomized:    " + ai);
	}
}
