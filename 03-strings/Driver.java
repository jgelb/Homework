public class Driver {
    public static void main(String [] args){
	String s = "joe gelb";
	System.out.println(s.indexOf(" "));
	int x = s.indexOf(" ");
	String first = s.substring(0, x);
	System.out.println(first);
	String last = s.substring(x+1, s.length());
	System.out.println(last);
    }
}