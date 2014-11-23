public class Exec{
	public static void main(String []args){
		//Start a new Greeter
		Greeter namei = new Greeter("Ethan");
		String message = namei.greet();
		System.out.println("Using just the greet() method: ");
		System.out.println("Hello " + message);
		System.out.println("HELLO " + message.toUpperCase());
		System.out.print("Using loudGreet() method: ");
		message = namei.loudGreet();
		System.out.println(message);
	}
}
