public boolean mixStart(String str) {
  if (str.length() < 3) return false;
  String x  = str.substring(1,3);
  return(x.equals("ix"));
}
public String makeOutWord(String out, String word) {
  String x = out.substring (0,2);
  String y = out.substring (2,4);
  return (x + word + y);
}
public String firstHalf(String str) {
  return(str.substring (0, str.length()/2));
}