public class Exec{
	public static void main(String[] args){
		SArray test = new SArray(32); //Should create a 32 element array
		test.print();
		System.out.println(test.size());
		test.append("TEST");
		test.append("FOO");
		test.append("YOLO");
		test.append(9001);
		test.append(true);
		test.append(false);
		test.print();
		System.out.println(test.size());
		System.out.println(test.get(0));
		test.remove(0);
		test.print();
		System.out.println(test.size());
		for (int i = 0; i < 16; i++){
			test.replace(i , "Some object with value " + i);
		}
		test.print();
		System.out.println(test.size());
	}
}
