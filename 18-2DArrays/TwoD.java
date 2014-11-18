import java.util.*;
import java.io.*;

public class TwoD{
	public static void print(int[][] arrayofarray){
		for (int i = 0; i < arrayofarray.length; i++){
			System.out.print("Row " + i + ":	 {");
			for (int j = 0; j < arrayofarray[i].length; j++){
				if (j < arrayofarray[i].length - 1){
					System.out.print(arrayofarray[i][j] + " , ");
				}
				else{
					System.out.println(arrayofarray[i][j] + "}");
				}
			}
		}
	}

	public static void main(String[] args){
		int[][] data = new int[7][10];
		for (int i = 0; i < data.length; i++){
			for (int j = 0; j < data[i].length; j++){
				data[i][j] = j;
			}
		}
		print(data);
	}
}
