public class CodingBat{
	public String frontTimes(String str, int n) {
	  	String s = new String();
  		if (str.length() > 3) {
    			s = str.substring(0,3);
  		}
  		else {
    			s = str;
  		}
  		int i = 0;
  		String answer = new String("");
  		while (i < n) {
    			answer = answer + s;
    			i++;
  		}
  		return answer;
	}
	//Around 2 minutes

	public String stringBits(String str) {
  		int i = 0;
  		String answer = new String("");
  		while (i < str.length()) {
    			answer = answer + str.substring(i , i + 1);
    			i += 2;
  		}
  		return answer;
	}
	//Around 2 minutes

	public String stringYak(String str) {
  		int i = 0;
  		StringBuffer sb = new StringBuffer(str);
  		while (i < sb.length() - 2) {
    			if (sb.substring(i,i+1).equals("y")) {
      				if (sb.substring(i + 2, i + 3).equals("k")) {
        				sb.delete(i,i+3);
      				}
    			}
    			i++;
  		}
  		str = sb.toString();
  		return str;
	}
	//Around 5 minutes

	public int stringMatch(String a, String b) {
   		int i = 0;
   		int occurences = 0;
   		while (i < a.length() - 1 && i < b.length() - 1) {
     			if (a.substring(i,i+2).equals(b.substring(i,i+2))){
       				occurences++;
     			}
     			i++;
   		}
   		return occurences;
	}
	//Around 2 minutes
}
