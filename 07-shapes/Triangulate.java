public class Triangulate{
	public String tri1(int h){
		if (h <= 0) {
			if (h == 0) {return "";}
			else {return "INVALID INPUT";}
		}
		else {
			String answer = new String("");
			String save = new String("");
			while (h > 0) {
				answer = answer + "\n*" + save;
				save = save + "*";
				h = h - 1;
			}
			return answer.trim();
		}
	}

	public String tri2(int h){
		if (h <= 0) {
			if (h == 0) {return "";}
                        else {return "INVALID INPUT";}
                }
                else {
			String answer = new String("");
			String save = new String("");
			int n = h;
			String spaces = new String("");
			while (n > 1) {spaces = spaces + " "; n = n - 1;}
			//answer = spaces + answer;
                        while (h > 0) {
                                answer = answer + spaces + save + "*\n";
                                save = save + "*";
                                h = h - 1;
				if (h > 0) {spaces = spaces.substring(0,h-1);}
                        }
                        return answer;

		}
	}
}
