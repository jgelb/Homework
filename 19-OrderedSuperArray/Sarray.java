public class Sarray{
    private Object[] data;
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
		data[i]=data[i+1];
	    }
	    data[last]=null;
	    last--;
	}
	else
	    throw new ArrayIndexOutOfBoundsException();
    }
    public void isort (){
	int temp = 0;
	for (int i = 0;i < data.length;i++ ){
	    temp = 
       
}



