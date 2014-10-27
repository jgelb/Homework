public class Arraystuff {
   
    int i = 0;	
    int t = 0;
    int temp = 0;
    int[] array = {105,2,3,4,5,6,72};
    public int find(int n){
	while (i < array.length){
            if (array[i]== n) return i;
	    i += 1;
	}

	if (i == array.length) return -1;
	return -1;
    }
	
    

    public int maxVal(){
	while (t < array.length){
	    if (array[t] > temp) temp = array[t];
	    t += 1;
	}
	return temp;
    }
	




    public static void main (String[] args){
	Arraystuff x = new Arraystuff();
	Arraystuff y = new Arraystuff();
	System.out.println(x.find(3));
	System.out.println(y.maxVal());
    }
}