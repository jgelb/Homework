public class Wordsearch{
	private char[][] board;
	public WordSearch(int r, int c){
		board = new char[r][c];
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[i].length; j++){
				board[i][j] = ".";
			}
		}
	}
	public WordSearch(){
		this(20,20);
	}
	public String toString(){
		String s = "";
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[i].length; j++){
				s = s.board[i][j];
			}
		}
		s += "\n";
		return s;
	}
}
