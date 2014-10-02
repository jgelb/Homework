
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
    public String Tri3(int n){
	int spaces1= 1;
	int spaces2 = 1;
	int stars = 1;
	int starCount = 1;
	int idk = n;
	String s = "";
	while (n > 0) {
	    while (spaces1 < idk){
		s = s + " ";
		spaces1 = spaces1 + 1;
	    }
	    spaces1 = 1;
        
	    while (stars <= starCount ){
		s = s + "*";
		stars = stars + 1;
	    }
	    stars = 1;
	    starCount = starCount + 2;
        
	    while (spaces2 < idk){
		s = s + " ";
		spaces2 = spaces2 + 1;
	    }
	    idk = idk - 1;
	    spaces2 = 1;
	    s = s + "\n";
	    n = n -1;
	}
	return s;
    }
    public String diamond (int h){
	int spaces1 = 1;
	int spaces2 = 1;
        
	int stars2 = 1;
	int starCount = h -2;
	int row = (h/2) + 1;
	int idk = row;
	String s = Tri3(h/2 + 1);
	while (row <= h){
	    while(spaces1 <(h - idk )){
		s = s + " ";
		spaces1 = spaces1 + 1;
	    }
	    spaces1 = 1;
	    while (stars2 <= starCount){
		s = s + "*";
		stars2 = stars2 + 1;
	    }
	    stars2 = 1;
	    starCount = starCount - 2;
	    while(spaces2 <(h - idk)){
	        s = s + " ";
		spaces2 = spaces2 + 1;
	    }
	    spaces2 = 1;
	idk = idk -1;
	row = row + 1;
	s = s + "\n";}
	return s;
	}
    public String Tri4 (int h){
	int spaces =1 ;
	String s = "";
	int stars = h;
	int row = 1;
	while (row <= h){
	    while (spaces< row){
		s = s + " ";
		spaces = spaces + 1;
	    }
	    spaces = 1;
	    while( stars >= row){
		s = s + "*";
		stars = stars - 1;
	    }
	    row = row + 1;
	    stars = h;
	    s = s + "\n";
	}
	return s;
    }
}
