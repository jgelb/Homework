
public class Driver {
    public static void main(String[] args) {
	Sarray A = new Sarray(5);
	A.add("ant");
	A.add("elephant");
	A.add("cat");
	A.add("pig");
	A.add("dog");
	System.out.println(A);
	A.bsort();
	System.out.println(A);
    }
}