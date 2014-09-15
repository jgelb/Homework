import java.io.*;
import java.util.*;

//COMMENTING SOMETHING FOR THE HW ASSIGNMENT

public class Greeter {
	public void greet() {
		System.out.println("Hello World!");
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
