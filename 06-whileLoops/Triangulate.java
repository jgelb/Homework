public class Triangulate{
	public String tri(int n){
		if (n <= 0) {
			if (n == 0) {return "";}
			else {return "INVALID INPUT";}
		}
		else {
			String answer = new String("");
			String save = new String("");
			while (n > 0) {
				answer = answer + "\n *" + save;
				save = save + "*";
				n = n - 1;
			}
			return answer;
		}
	}
}
