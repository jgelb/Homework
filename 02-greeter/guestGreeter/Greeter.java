import java.io.*;
import java.util.*;

public class Greeter{
	private String s;

	public Greeter(String name){
		s = name;
	}

	public String greet(){
		return s;
	}

	public String loudGreet(){
		return s.toUpperCase();
	}
}
