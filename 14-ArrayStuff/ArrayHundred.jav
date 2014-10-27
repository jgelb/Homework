import java.io.*;
import java.util.*;

public class ArrayHundred{
	public int[] stuff;

	public ArrayHundred() {
                stuff = new int[100];
                for (int i = 0; i < stuff.length; i++){
                        stuff[i] = (int)(Math.random() * 100) % 75 + 75;
                }

	}

	public int find(int n , int[] someArray){
		int value = -1;
		for (int i = 0; i < someArray.length; i++){
			if (someArray[i] == n) {value = i;}
		//	return value;
		}
		return value;
	}

	public int maxNum(int[] someArray){
		int answer = 0;
		for (int i = 0; i < someArray.length; i++){
			answer = Math.max(answer , someArray[i]);
		}
		return answer;
	}

	public String toString(){
		String s = "";
		for (int i = 0; i < stuff.length; i++){
			if (i == stuff.length - 1) { s = s + stuff[i]; }
			else { s = s + stuff[i] + " , ";}
		}
		return s;
	}
	public static void main(String[] args){
		ArrayHundred x = new ArrayHundred();
		System.out.println(x.toString());
		String k = "";
		k += x.maxNum(x.stuff);
		System.out.println(k);
	}
}
