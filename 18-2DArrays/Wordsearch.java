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
	}

	public static void main(String[] args){
		Wordsearch test = new Wordsearch();
		System.out.println(test);
	}
}
