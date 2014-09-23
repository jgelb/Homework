public class Driver{
	public boolean mixStart(String str) {
		if (str.length() >= 3) {
			if (str.substring(1,3).equals("ix") == true) {
				return true;
			}
    			else {
      				return false;
    			}
  		}
  		else {
    			return false;
  		}
	}


	public String makeOutWord(String out, String word) {
  		return (out.substring(0,2) + word + out.substring(2,4));
	}

	public String firstHalf(String str) {
  		return str.substring(0,str.length() / 2);
	}
}
