import java.io.*;
import java.util.*;

public class Driver{
	public static void main(String []args) {
		StringStuff x = new StringStuff();
		System.out.println(x.nonStart("abc" , "DEF"));
		System.out.println(x.makeAbba("POEM" , "Struct"));
		System.out.println(x.diff21(10));
		System.out.println(x.diff21(90));
		System.out.println(x.lastDigit(24 , 39 ,9004));
		System.out.println(x.nearHundred(209));
		System.out.println(x.mixStart("twix"));
		System.out.println(x.mixStart("mixStart"));
		System.out.println(x.teaParty(11,4));
	}
}
