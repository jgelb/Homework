public class MakeFrame {
	public String frame(int r, int c){
		//Build lines
		String line = new String("");
		for (int i = 0; i < c; i++){
			if (i == 0 || i == c - 1) {line = line + "*";}
			else {line = line + ".";}
		}
		String answer = "";
		for (int i = 0; i < r; i++){
			if (i == 0 || i == r - 1) {answer = answer + line.replace("." , "*");}
			else {answer = answer + line.replace("." , " ");}
			answer = answer + "\n";
		}
		return answer;
	}
}
