import java.io.*;
import java.util.*;

public class ArrayStuff{
	public int[] stuff;

	public ArrayStuff() {
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

	public int freq(int i , int[] foobar){
		int val = foobar[i];
		int count = 0;
		for (int k = 0; k < foobar.length; k++){
			if (foobar[k] == val){
				count++;
			}
		}
		return count;
	}

	public int mode(int[] foobar){
		//Get maximum frequency of item
		int[] freqs = new int[foobar.length];
		for (int i = 0; i < freqs.length; i++){
			freqs[i]= freq(foobar[i] , foobar);
		}
		return maxNum(freqs);
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
		ArrayStuff x = new ArrayStuff();
		System.out.println(x.toString());
		String k = "";
		k += "\n" + x.maxNum(x.stuff);
		k += "\n" + x.freq(2 , x.stuff);
		System.out.println(k);
		System.out.println(x.mode(x.stuff));
	}
}
