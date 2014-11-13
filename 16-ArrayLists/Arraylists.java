public class Arraylists {
    ArrayList<Integer> a = new ArrayList<Integer>;
    int i = 0;
    while (i < 20){
	Random n = new Random();
        a.add(n.nextInt(6), i);
        i += 1;
    }
    public boolean same = false;
    public void remove(){
        int n = 0;
        while (n < a.length){
            if (same == false){
		if (n > 0 && a.get(n) == a.get(n-1)) same = true; a.remove(n);
		
		else n += 1;
	    }
	    if (same == true) {
		a.remove(n);
		same = false;
		n = 0;
	    }
	    }
	}
}

//this code does not work, but I tried.  