
public class files{
    public String Tri2(int n){
	int x = 1;
        int rot = 1;
	    String s = "";
	    while (x  <= n){
		int z = 1;
		while (rot < n){
		    s = s + " ";
		    rot = rot + 1;
		}
	       
		while (z <= x){
		    
			s = s + "*";
			z = z + 1;
		    }
		s = s + "\n";
		x = x + 1;
		rot = x;
	    }
	    return (s);
    }
    public String Tri1(int n){
	int x = 1;
        
	    String s = "";
	    while (x  <= n){
		int z = 1;
		while (z <= x){
			s = s + "*";
			z = z + 1;
		    }
		s = s + "\n";
		x = x + 1;
	    }
	    return (s);
    }
	
}
