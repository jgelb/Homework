public class CodingBat{
	public String stringSplosion(String str) {
  		String answer = "";
  		for (int i = 0; i <= str.length(); i++){
    			answer = answer + str.substring(0,i);
  		}
  		return answer;
	}
	public String stringX(String str) {
  		if (str.length() <= 1) {return str;}
  		if (str.substring(0,1).equals("x")) {str = "%LEADING_X%" + str;}
  		if (str.substring(str.length() - 1 , str.length()).equals("x")) {str = str + "%LEADING_X%";}
  		return (str.replace("x","").replace("%LEADING_X%" , "x"));
	}
}
