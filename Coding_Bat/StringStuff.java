public class StringStuff {

  public String nonStart(String a, String b) {
    return (a.substring(1,a.length()) + b.substring(1,b.length()) );
  }
  
  public String makeAbba(String a, String b) {
    return (a + b + b + a);
  }
  
  public int diff21(int n) {
    if (n > 21) {
       return ((n-21)*2);
    }
    else if (n <=21){
       return (21 - n);
    }
    return n;
  }
  
  public boolean nearHundred(int n) {
    if( Math.abs(100 - n) <= 10 ) return true;
    else if ( Math.abs(200 - n) <= 10 ) return true;
    else return false;
    
  }
  
  public boolean mixStart(String str) {
    if (str.length() < 3) return false;
   String s = str.substring(1, 3);
   if (s.equals("ix")) return true;
   
  return false;
  }
  
  public int teaParty(int tea, int candy) {
    if (tea < 5 || candy < 5) return 0;
    if (Math.abs(tea -candy) >= candy || Math.abs(tea -candy) >= tea ) return 2;
    else return 1;
  }
  
  public boolean lastDigit(int a, int b, int c) {
    if (a % 10 == b % 10 || b % 10 == c % 10 || a % 10 == c % 10 ) return true;
    else return false;
  }
}
