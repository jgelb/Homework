import java.io.*;
import java.util.*;

//COMMENTING SOMETHING FOR THE HW ASSIGNMENT

public class Greeter {
//	Instance Variables go here:

//	public String s = new String(":O");
	private String s = new String(":)");

//	Constructors go here:

//	1. the name is same as class name
//	2. NO RETURN TYPE
//	3. ALWAYS public name(parameters)

// A constructor is run automatically when you instantiate the class, if you have: Greeter g = new Greeter("Hello") then java will automatically call this
// constructor sending 'Hello" in as parameter g. It will then set the instance variable greeting to what g refers to, which is hello.
	public Greeter(String g) {
		s = g;
	}
// You can have methods with the same names and different parameters, and java will figure out which method to use based on the parameters inputted
	public Greeter() {

	}

// Methods:

	public void setGreeting(String greeting){
		s = greeting;
	}

	public String getGreeting() {
		return s;
	}

	public String greet() {
		return s;
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
