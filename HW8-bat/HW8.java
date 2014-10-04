public class HW8 {
    public String rectangle(int r, int n){

	String s = "";
	int stars = 1;
	int row = 0;
	int spaces = 1;
	    while (row < r){
		if (row == r - 1 || row == 0){
		    while (stars <= n){
			s = s + "*";
			stars += 1;
		    }
		    stars = 1;
		}
		else {
		    s = s + "*";
			while (spaces <= n - 2)  {
			    s = s + " ";
			    spaces += 1;
			}
		    s = s + "*";
		    spaces = 1;
		}
		row = row + 1;
		s += "\n"; 

	    }
	return s;

    }
    public String stringSplosion(String str) {
	String x = str;
	int index = 0;
	int endex = 1;
	String s= "";
	while ( endex <= str.length()){
	    s = s + str.substring(index,endex);
	    endex = endex + 1;
	}
	return s;
    }
    public String stringX(String str) {
	String s = "";
	String mod = str;
	int index = 0;
	while (index < str.length()){
	    if (index != 0 && index != str.length()){
		s = s + str.substring(index);
		index += 1;
	    }
      
	    else {
		if (str.substring(index).equals("x")){
		    index = index + 1;}
		else {
		    s = s + str.substring(index);
		    index = index + 1;}
	    }
	}return s;
    }
      

    
}