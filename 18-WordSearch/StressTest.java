import java.util.*;
import java.io.*;

public class StressTest {
	public static void main(String[] args) {
		int rTest = 20;
		int cTest = 40;
		if (args.length == 2){
			try{
				rTest = Integer.parseInt(args[0]);
				cTest = Integer.parseInt(args[1]);
			} catch(Exception e){
				System.out.println("Argument error");
				e.printStackTrace();
			}
		}
		Wordsearch ws = new Wordsearch(rTest , cTest);
		String[] test = new String[10];
		test[0] = "HELLO";
		test[1] = "WORLD";
		test[2] = "SOLAR";
		test[3] = "JUSTICE";
		test[4] = "INGENIOUS";
		test[5] = "ZAMANSKY";
		test[6] = "stuyvesant";
		test[7] = "salad";
		test[8] = "chicken";
		test[9] = "stress";
		ws.getWordsFromArray(test);
		ws.getWordsFromFile(new File("wordlist.in"));
		ws.randomWordFill();
/*
		Runtime cmd = Runtime.getRuntime();
		try{
			System.out.println(cmd.exec("cat WORDSEARCH.key"));
			System.out.println();
			System.out.println(cmd.exec("cat WORDSEARCH.puzzle"));
			System.out.println();
		} catch(Exception e){
			System.out.println("");
		}
*/
	}
}
/*
		LOGS OF DIFFERENT SIZE BOARDS:

sublimau5@PFRuojia:~/Stuy14-15/APCS/apcs-z-hw-pd1/18-WordSearch$ time java StressTest 30 50
Answer key saved as WORDSEARCH.key
Puzzle saved as WORDSEARCH.puzzle

real	0m0.264s
user	0m0.262s
sys	0m0.020s
sublimau5@PFRuojia:~/Stuy14-15/APCS/apcs-z-hw-pd1/18-WordSearch$ time java StressTest 40 60
Answer key saved as WORDSEARCH.key
Puzzle saved as WORDSEARCH.puzzle

real	0m0.340s
user	0m0.330s
sys	0m0.041s
sublimau5@PFRuojia:~/Stuy14-15/APCS/apcs-z-hw-pd1/18-WordSearch$ time java StressTest 50 70
Answer key saved as WORDSEARCH.key
Puzzle saved as WORDSEARCH.puzzle

real	0m0.393s
user	0m0.391s
sys	0m0.059s
sublimau5@PFRuojia:~/Stuy14-15/APCS/apcs-z-hw-pd1/18-WordSearch$ time java StressTest 60 80
Answer key saved as WORDSEARCH.key
Puzzle saved as WORDSEARCH.puzzle

real	0m0.503s
user	0m0.476s
sys	0m0.097s
sublimau5@PFRuojia:~/Stuy14-15/APCS/apcs-z-hw-pd1/18-WordSearch$ time java StressTest 70 90
Answer key saved as WORDSEARCH.key
Puzzle saved as WORDSEARCH.puzzle

real	0m0.619s
user	0m0.651s
sys	0m0.121s
sublimau5@PFRuojia:~/Stuy14-15/APCS/apcs-z-hw-pd1/18-WordSearch$ time java StressTest 80 100
Answer key saved as WORDSEARCH.key
Puzzle saved as WORDSEARCH.puzzle

real	0m0.820s
user	0m0.918s
sys	0m0.121s
sublimau5@PFRuojia:~/Stuy14-15/APCS/apcs-z-hw-pd1/18-WordSearch$ time java StressTest 100 100
Answer key saved as WORDSEARCH.key
Puzzle saved as WORDSEARCH.puzzle

real	0m0.985s
user	0m1.054s
sys	0m0.191s


CONCLUSION: Efficiency is sufficient
*/
