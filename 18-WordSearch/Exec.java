import java.util.*;
import java.io.*;

public class Exec {
	public static void main(String[] args) {
		Wordsearch ws = new Wordsearch();
		String[] test = new String[5];
		test[0] = "HELLO";
		test[1] = "WORLD";
		test[2] = "SOLAR";
		test[3] = "JUSTICE";
		test[4] = "INGENIOUS";
		ws.getWordsFromArray(test);
		ws.getWordsFromFile(new File("wordlist.in"));
		ws.randomWordFill();
	}
}
