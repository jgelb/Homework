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

