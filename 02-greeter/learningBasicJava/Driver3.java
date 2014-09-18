public class Driver2 {
	public static void main(String []args) {
		Greeter2 g1 = new Greeter2();
		Greeter2 g2 , g3;
		g2 = new Greeter();
		g1.greet();
		g2.greet();
		g3 = g1;
		System.out.println("g1: " + g1);
		System.out.println("g2: " + g2);
		System.out.println("g3: " + g3);
		//String a = g1.greet.s();
		//System.out.println(a);
	}
}
