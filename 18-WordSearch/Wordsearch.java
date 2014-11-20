import java.util.*;
import java.io.*;

public class Wordsearch{

	//Global Variables

	private char[][] board;
	private ArrayList<String> words = new ArrayList<String>();

	//Constructors

	public Wordsearch(int r, int c){
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
				s += board[i][j];
			}
			s += "\n";
		}
		s += "\n";
		return s;
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
			while (fread.nextLine() != null || fread.nextLine().length() > 2){ // Do not allow words with less than 3 letters
				words.add(fread.nextLine());
			}
		} catch(Exception e){e.printStackTrace();}
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

	public void insertWord (int row, int column, String word , int direction){
		boolean response = true;
		switch (direction){
			case 1://Horizontally left to right
				response = response && (row < board.length);
				response = response && (column + word.length() < board[row].length);
				if (response){
					for (int i = column; i < column + word.length(); i++){
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
					for (int i = column; i > column - word.length(); i--){
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
					for (int i = row; i < row + word.length(); i++){
						response = response && (board[i][column] == '.' || board[i][column] == word.charAt(i - row));
					}
				}
				if (response){
					for (int i = row; i < row + word.length(); i++){
						board[i][column] = word.charAt(i - row);
					}
				}
				break;
			case 4://Vertical upwards
				response = response && (row < board.length);
				response = response && (row - word.length() > 0);
				if (response){
					for (int i = row; i > row - word.length(); i--){
						response = response && (board[i][column] == '.' || board[i][column] == word.charAt(row - i));
					}
				}
				if (response){
					for (int i = row; i > row - word.length(); i--){
						board[i][column] = word.charAt(row - i);
					}
				}
				break;
			default:
				break;
		}
	}

	public static void main(String[] args){
		Wordsearch test = new Wordsearch();
		System.out.println(test);
		test.insertWord(1 , 2 , "HELLO" , 1);
//		test.insertWord(1 , 12 , "HELLO" , 2);
		test.insertWord(1 , 2 , "HELLO" , 3);
		test.insertWord(10 , 3 , "HELLO" , 4);
		System.out.println(test);
	}
}