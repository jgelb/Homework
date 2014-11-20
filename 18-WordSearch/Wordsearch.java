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

	public getWordsFromArray(String[] in){
		for (int i = 0; i < in.length; i++){
			words.add(in[i]);
		}
	}

	public getWordsFromFile(File f){
		//f should be declared: File f = new File("/PATH/TO/FILE");
		//An alternative would be getWordsFromFile(new File("/PATH/TO/FILE"));
		Scanner fread = new Scanner(f);
		while (fread.nextLine() != null || fread.nextLine().length() > 2){ // Do not allow words with less than 3 letters
			words.add(fread.nextLine());
		}
	}

	public getWordsFromUserInput(){
		Scanner sc = new Scanner(System.in);
		while (!sc.nextLine().equals("STOP_INPUT")){
			words.add(sc.nextLine();
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
				response = response && (row > board.length);
				response = response && (column + word.length() > board[row].length);
				if (response){
					for (int i = column; i < column + word.length(); i++){
						response = response && (board[row][i].equals(".") || word.charAt(i - column)); 
					}
				}
				if (response){
					for (int i = column; i < column + word.length(); i++){
						response = response && (board[row][i].equals(".") || word.charAt(i - column)); 
					}
				}
				break;
			case 2:
				break;
			default:
				break;
		}
	}

	public static void main(String[] args){
		Wordsearch test = new Wordsearch();
		System.out.println(test);
	}
}
