import java.io.*;
import java.util.*;

//COMMENTING SOMETHING FOR THE HW ASSIGNMENT

public class Greeter {
//	public String s = new String(":O");
	private String s = new String(":)");
	public void setGreeting(String greeting){
		s = greeting;
	}

	public String getGreeting() {
		return s;
	}

	public void greet() {
//		String s = new String("Hello World!"); //WILL BE HIDDEN BECAUSE OF public String s above
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
