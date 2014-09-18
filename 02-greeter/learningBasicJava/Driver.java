public class Driver {
	public static void main(String []args){
		Greeter g; //Declares g to be a variable of type 'Greeter' in Greeter.java
		/*
			g is defined INSIDE of a function and is therefore a local variable
			Local variable -> A variable declared inside a mtheod/function and is created when
			method is called, and destroyed when returning from the method
			can only use local variable in the method it is created in.
		*/
		g = new Greeter();
		Greeter g2 = new Greeter();
		/*
			1. allocates the memory for a new Greeter instance
			2. sets up the Greeter (java does this)
			3. Returns the memory address location for it
			4. Stores that address in g
			g now stores the location of the greeter in the RAM
			greeter isn't actually stored in g
		*/
		// new -> creates new instance/object of a class. It allocates memory and initializes as needed.
//		g.s = new String("BLEAH");
		g.setGreeting(new String("BLEAH"));
		System.out.println("Memory address of g: " + g);
		g.greet();
		g2.setGreeting("This is a literal string");
		//String literal creates memory block and the string will point to the same block when used multiple times
		//New string creates a new memory block
		g2.greet();
		g.ungreet();
		System.out.println("g's string is: " + g.getGreeting());
		System.out.println("g2's string is: "+ g2.getGreeting());
	}
}
