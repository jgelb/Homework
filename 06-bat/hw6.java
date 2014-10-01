
//20 minutes
public class hw6 {
  public String frontTimes(String str, int n) {
      if (str.length() >= 3){
	  String frn = str.substring(0,3);
      }
      if (str.length() < 3){
	  String frn = str;
      }
      int x = n;
      String done = "";
      while (x > 0){
	  done = done + frn;
	  x = x - 1;
      }

 }
//30 minutes
public String stringBits(String str) {
  int x = str.length();
  String y = new String ("");
  int counter =  0;
  
  while (counter < x){
     if ((counter % 2) == 0){
         y = y + str.charAt (counter);
     }
     counter = counter + 1;
  }
  return (y);
  
     
}
3 minutes;
public String stringYak(String str) {
 
  String x = str.replaceAll("yak","");
  return x;
}

    //25 but it doesn't work
public int stringMatch(String a, String b) {
  int x = 0;
  int y  = 0;
  while (x < a.length() - 2){
     if (a.substring(x, x + 2) == b.substring(x, x + 2) ) {
        y = y + 1;
     }
     x = x + 1;
  }
  return y;
}


