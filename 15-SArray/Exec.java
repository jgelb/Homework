public class Exec{
	public static void main(String[] args){
		SArray test = new SArray(32); //Should create a 32 element array
		System.out.println(test.size());
		test.add("TEST");
		test.add("FOO");
		test.add("YOLO");
		test.add(9001);
		test.add(true);
		test.add(false);
	}
}
