import java.util.*;
import java.io.*;

public class Wordsearch{

	//Global Variables

	private char[][] board;
	private ArrayList<String> words = new ArrayList<String>();
	private final String alphabet = "AAAABBCCDDEEEEFFFGHIIIJKLMNOOPQRSTTTUUVWXYZ"; //Note duplicates of letters gives higher chance for that letter

	//Constructors

	public Wordsearch(int r, int c){
		if (r > 100 || c > 100){
			System.out.println("The number of rows and the number of columns cannot exceed 100");
			try {
				System.exit(0);
			} catch(Exception e){
				System.out.println("System Exit failed. Exit the program manually.");
			}
		}
		board = new char[r][c];
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[i].length; j++){
				board[i][j] = '.';
			}
		}
	}
	public Wordsearch(){
		this(20,40);
	}

	//Converters

	public String toString(){
		String s = "";
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[i].length; j++){
				s += board[i][j] + " ";
			}
			s += "\n\n";
		}
		s += "\n";
		s += "Word Bank: \n";
		s += words.toString();
		return s;
	}

	//Out file:

	public void outFile(String name){
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name), "utf-8"));
			writer.write(this.toString());
		} catch (Exception e) {
  			e.printStackTrace();
		} finally {
   			try {
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//Input Methods:

	public void getWordsFromArray(String[] in){
		for (int i = 0; i < in.length; i++){
			words.add(in[i]);
		}
	}

	public void getWordsFromFile(File f){
		//f should be declared: File f = new File("/PATH/TO/FILE");
		//An alternative would be getWordsFromFile(new File("/PATH/TO/FILE"));
		try{
			Scanner fread = new Scanner(f);
			while (fread.hasNext() || fread.nextLine().length() > 2){ // Do not allow words with less than 3 letters
				words.add(fread.nextLine());
			}
		} catch(Exception e){/*e.printStackTrace();*/}
	}

	public void getWordsFromUserInput(){
		Scanner sc = new Scanner(System.in);
		while (!sc.nextLine().equals("STOP_INPUT")){
			words.add(sc.nextLine());
		}
	}

	// Create the wordsearch:

/*
	There needs to be some set of rules to start inputting words from ArrayList<String> words into the data.
	NOT NEEDED: checkOverlap(int row, int column, String word) Will return true if it can overlap correctly
	insertWord(String word, int row, int column , int direction) will first check overlap, if true, insert the word in given direction
*/

	public void randomWordFill(){
		Random rnd = new Random();
		int tries = 0;
		for (int i = 0; i < words.size(); i++){
			while (!insertWord(rnd.nextInt(board.length - words.get(i).length()) , rnd.nextInt(board[0].length - words.get(i).length()) , words.get(i) , rnd.nextInt(8) + 1)){
				if (tries > 20){
					System.out.println("Word excluded: Unable to find valid space: " + words.get(i));
					break;}
					tries++;
			}
			tries = 0;
		}
		outFile("WORDSEARCH.key");
		this.fillWithRandomChar();
		outFile("WORDSEARCH.puzzle");
		System.out.println("Answer key saved as WORDSEARCH.key \nPuzzle saved as WORDSEARCH.puzzle");
	}

	public boolean insertWord(int row, int column, String word , int direction){
		boolean response = true;
		word = word.toUpperCase();
		int r = row;
		int c = column;
		switch (direction){
			case 1://Horizontally left to right
				response = response && (row < board.length);
				response = response && (column + word.length() < board[row].length);
				if (response){
					for (int i = column; i < column + word.length() && response; i++){
						response = response && (board[row][i] == '.' || board[row][i] == word.charAt(i - column));
					}
				}
				if (response){
					for (int i = column; i < column + word.length(); i++){
						board[row][i] = word.charAt(i - column);
					}
				}
				break;
			case 2://Horizontally right to left
				response = response && (row < board.length);
				response = response && (column - word.length() > 0);
				//System.out.println("Checkpt 1: " + response);
				if (response){
					for (int i = column; i > column - word.length() && response; i--){
						response = response && ((board[row][i] == '.') || board[row][i] == word.charAt(column - i));
						//System.out.println("Checkpt 2: " + word.charAt(column - i));
					}
				}
				if (response){
					for (int i = column; i > column - word.length(); i--){
						board[row][i] = word.charAt(column - i);
						//System.out.println("Checkpt 3: " + word.charAt(column - i));
					}
				}
				break;
			case 3://Vertical downwards
				response = response && (row < board.length);
				response = response && (row + word.length() < board.length);
				if (response){
					for (int i = row; i < row + word.length() && response; i++){
						response = response && (board[i][column] == '.' || board[i][column] == word.charAt(i - row));
					}
				}
				if (response){
					for (int i = row; i < row + word.length(); i++){
						board[i][column] = word.charAt(i - row);
					}
				}
				break;
			case 4: //Vertical upwards
				response = response && (row < board.length);
				response = response && (row - word.length() > 0);
				if (response){
					for (int i = row; i > row - word.length() && response; i--){
						response = response && (board[i][column] == '.' || board[i][column] == word.charAt(row - i));
					}
				}
				if (response){
					for (int i = row; i > row - word.length(); i--){
						board[i][column] = word.charAt(row - i);
					}
				}
				break;
			case 5://Diagonally, towards Quadrant I
				response = response && (row < board.length);
				response = response && (column + word.length() < board[row].length);		//Case 1 - Right
				response = response && (row - word.length() > 0);				//Case 4 - Up
				if (response){
					for (int i = 0; i < word.length() && response; i++){
						response = response && (board[r][c] == word.charAt(i) || board[r][c] == '.');
						r--;
						c++;
					}
					r += word.length();
					c -= word.length();
				}
				if (response){
					for (int i = 0; i < word.length(); i++){
						board[r][c] = word.charAt(i);
						r--;
						c++;
					}
				}
				break;
			case 6://Diagonally, towards Quadrant II
				response = response && (row < board.length);
				response = response && (column - word.length() > 0);				//Case 2 - Left
				response = response && (row - word.length() > 0);				//Case 4 - Up
				if (response){
					for (int i = 0; i < word.length() && response; i++){
						response = response && (board[r][c] == word.charAt(i) || board[r][c] == '.');
						r--;
						c--;
					}
					r += word.length();
					c += word.length();
				}
				if (response){
					for (int i = 0; i < word.length(); i++){
						board[r][c] = word.charAt(i);
						r--;
						c--;
					}
				}
				break;
			case 7://Diagonally, towards Quadrant III
				response = response && (row < board.length);
				response = response && (column - word.length() > 0);				//Case 2 - Left
				response = response && (row + word.length() < board.length);			//Case 3 - Down
				if (response){
					for (int i = 0; i < word.length() && response; i++){
						response = response && (board[r][c] == word.charAt(i) || board[r][c] == '.');
						r++;
						c--;
					}
					r -= word.length();
					c += word.length();
				}
				if (response){
					for (int i = 0; i < word.length(); i++){
						board[r][c] = word.charAt(i);
						r++;
						c--;
					}
				}
				break;
			case 8://Diagonally, towards Quadrant IV
				response = response && (row < board.length);
				response = response && (column + word.length() < board[row].length);		//Case 1 - Right
				response = response && (row + word.length() < board.length);			//Case 3 - Down
				if (response){
					for (int i = 0; i < word.length() && response; i++){
						response = response && (board[r][c] == word.charAt(i) || board[r][c] == '.');
						r++;
						c++;
					}
					r -= word.length();
					c -= word.length();
				}
				if (response){
					for (int i = 0; i < word.length(); i++){
						board[r][c] = word.charAt(i);
						r++;
						c++;
					}
				}
				break;
			default:
				break;
		}
		return response;
	}

	public void fillWithRandomChar(){
		Random r = new Random();
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[i].length; j++){
				if (board[i][j] == '.'){
					board[i][j] = alphabet.charAt(r.nextInt(alphabet.length() - 1));
				}
			}
		}
	}
}
