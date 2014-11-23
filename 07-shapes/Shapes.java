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
/*
		for (i = 0; i < h; i++) {
			answer = answer + "POINTER_NEWLINE" + spaces + last + spaces;
                        if (last.length() > 2){last = last.substring(0,last.length()-2);}
                        spaces = spaces + " ";
		}
*/
		StringBuffer buff = new StringBuffer(answer);
		answer = buff.reverse().toString();
		return answer.replaceAll("ENILWEN_RETNIOP" , "\n");
	}

	public String tri3REVERSE(int h) {
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
                        answer = answer + " " + spaces + last + spaces + " \n";
                        if (last.length() > 2){last = last.substring(0,last.length()-2);}
                        spaces = spaces + " ";
                        i++;
                }
                return answer;
        }

	public String diamond(int h) {
		if (h % 2 == 1) {return (tri3((h + 1) / 2) + tri3REVERSE((h - 1) / 2));}
		else {return (tri3(h/2) + tri3REVERSE(h/2));}
	}

	public String tri4(int h) {
		String line = new String("");
		String answer = new String("");
		for (int i = 0; i < h; i++) {line = line + "*";}
/*
		while version:
		int i = 0;
		while (i < h) {line = line + "*"; i++;}
*/
		for (int i = 0; i < h; i++) {answer = answer + line + "\n"; line = line.replaceFirst("\\*" , " ");}
/*
		while version:
		i = 0;
		while (i < h) {answer = answer + line + "\n"; line = line.replaceFirst("\\*" , " "); i++;}
*/
		return answer;
	}
}
