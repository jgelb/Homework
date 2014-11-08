public class Exec{
	public static void main(String[] args){
		SArray test = new SArray(32); //Should create a 32 element array
		test.print();
		System.out.println(test.size());
		test.add("TEST");
		test.add("FOO");
		test.add("YOLO");
		test.add(9001);
		test.add(true);
		test.add(false);
		test.print();
		System.out.println(test.size());
		System.out.println(test.get(0));
		test.remove(0);
		test.print();
		System.out.println(test.size());
	}
}
