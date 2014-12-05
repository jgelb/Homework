public class Sarray{
    private Object[] data;
    private int[] messy;
    private int last;
    public Sarray(){
	this(10);
    }
    public Sarray(int n){
	data=new Object[n];
	last=0;
    }
    public int find(Object n){
	for (int i = 0;i<data.length;i++){
	    if (data[i].equals(n)) return i;
	}
	return -1;
    }
    public void add(Object n){
	if (last==data.length-1){
	    Object[] ph = data;
	    data= new Object[data.length+1];
	    for ( int i=0; i<ph.length;i++){
		data[i]=ph[i];
	    }
	}
	last++;
	data[last]=n;
    }
    public void add(int index, Object n){
	if (index<=last){
	    if (data.length-1==last){
		Object PlaceHolder[] = data;
		data = new Object[data.length+1];
		for (int i=0;i<index; i++){
		    data[i]=PlaceHolder[i];
		}
		data[index]=n;
		for (int i=index+1; i<data.length+1; i++){
		    data[i]=PlaceHolder[i-1];
		}
	    } else {
		for (int i=last+1; i>index; i--){
		    data[i] = data[i-1];
		}
		data[index]= n;
	    }
	    last++;
	}else{
	    throw new ArrayIndexOutOfBoundsException();
	}
    }
    public Object get(int index){
	if (index<=last)
	    return data[index];
	else
	    throw new ArrayIndexOutOfBoundsException();
    }
    public void set(int index, Object i){
	if (index<data.length){
	    data[index]=i;
	}
    }
    public int size(){
	return last+1;
    }
    public void remove(int index){
	if (index<=last){
	    for (int i=index; i<last; i++){
		messy[i]=messy[i+1];
	    }
	    messy[last]=0;
	    last--;
	}
	else
	    throw new ArrayIndexOutOfBoundsException();
    }
   
/*    public void isort() {
	int i;
	for (int q=0;q<size()-1;q++) {
	    if (data[q].compareTo(data[q+1])>0) {
		String newvalue = data[q];
		remove(q);
		for (i=last;i>0&&newvalue.compareTo(data[i-1])<0;i--) {
		    data[i]=data[i-1];
		}
		data[i+1]=newvalue;
	    }
	}
    }
*/
    public int findmin(int[] x){
	int i = 0;
	int min = x[0];
	while (i < x.length){
	    if (x[i] < min) min = x[i];
	    i ++;
	}
	return min;
    }
    public int findloc(int[] x){
	int i = 0;
	int min = x[0];
	int loc = 0;
	    while (i < x.length){
		if (x[i] < min) min = x[i]; loc = i;
		i ++;
	    }
	return min;
    }
    public void ssort(int[] x){
	int i = 0;
	messy = x;
	    while (i < x.length){
		int temp = findmin(x);
		int loc = findloc(x);
		temp = findmin(messy);
		x[loc] = x[i];
		x[i] = x[loc];
		messy  = messy.remove(i);
		i += 1;
	    }}

}



