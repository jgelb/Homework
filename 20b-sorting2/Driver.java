
public class Driver {
    public static void main(String[] args) {
	Sarray A = new Sarray(5);
	A.add("chicken");
	A.add("broccoli");
	A.add("cheese");
	A.add("zenith");
	A.add("words");
	System.out.println(A);
	A.bsort();
	System.out.println(A);
    }
}
