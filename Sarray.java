public class Sarray {
    private int[] data;
    private int last;
    int i = 0;
    
    public Sarray(){
	 data = new int[10];
    }
    public void test(){
    while (i < 10){
	System.out.println(data[i]);
        i += 1;
    }
    }
    public void add(int i){
	if (last < data.length){
	    
	    for (int counter = data.length - 1; counter > 0; counter -= 1){
		data[counter] = data[counter - 1];
	    }
	    data[0] = i;
	    last += 1;
        }
    }


public static void main (String[] args) {
    Sarray x = new Sarray();
    x.add(4);
    x.add(6);
    x.test();
}
	
}
