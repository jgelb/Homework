import java.io.*;
import java.util.*;

//COMMENTING SOMETHING FOR THE HW ASSIGNMENT

public class Greeter2 {
	//INSTANCE VARIABLES (ATTRIBUTES) GO HERE:
	
	//

	public void greet() {
		String s = new String("Hello World!");
		System.out.println(s);
		ungreetPrivate();
	}
	public void ungreet() {
		System.out.println("I'm out.");
	}
	/*
		IF we used:
		private void ungreet() { System.out.println("I'm out.");}
		Then can only be accessed within the class in which it is defined.
	*/
	private void ungreetPrivate() {
		System.out.println("PRIVATE");
	}
}
//HW Comments below:
//public static void main(String []args){
	//Greeter.greet();
//}
