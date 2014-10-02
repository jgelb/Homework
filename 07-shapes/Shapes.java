public class Shapes{
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

	public String tri3(int h) {
		//Get Last String
		String last = new String("");
		int i = 0;
		while (i < 2 * h - 1) {
			last = last + "*";
			i++;
		}
		i = 0;
		String spaces = new String("");
		String answer = new String("");
		while (i < h) {
			answer = answer + "POINTER_NEWLINE" + spaces + last + spaces;
			if (last.length() > 2){last = last.substring(0,last.length()-2);}
			spaces = spaces + " ";
			i++;
		}
		StringBuffer buff = new StringBuffer(answer);
		answer = buff.reverse().toString();
		return answer.replaceAll("ENILWEN_RETNIOP" , "\n");
	}
}
