import java.io.*;
import java.util.*;

public class Driver{
	public static void main(String []args){
		String s = "mike zamansky";

		int spaceValue = s.indexOf(" ");
		String[] parts = s.split(" ");
		//Print the parts
		System.out.println("Space is at index: " + spaceValue);
		System.out.println(parts[0]);
		System.out.println(parts[1]);
		//Set actual variables
		String part1 = parts[0];
		String part2 = parts[1];
		//Write to a file for funsies
		try {
			File file = new File("firstname.out");
			BufferedWriter output0 = new BufferedWriter(new FileWriter(file));
			output0.write(part1);
			output0.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		try {
                        File file = new File("lastname.out");
                        BufferedWriter output1 = new BufferedWriter(new FileWriter(file));
                        output1.write(part2);
                        output1.close();
                }
                catch (IOException e) {
                        e.printStackTrace();
                }

	}
}
