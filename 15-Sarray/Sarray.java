public class Sarray {
    private int[] data;
    private int lastindex = -1;
    public Sarray(){
	data = new int[10];
    }
    
    public String toString(){
	String ans = "";
	for (int i=0;i<size();i++){
	    ans+=data[i]+",";
	}
	return ans;
    }
    
    public void expand(){
	int[] ans = new int[data.length+1];
	for (int i=0;i<size();i++){
	    ans[i]=data[i];
	}
	data = ans;
    }
    //adds value to end of list
    public boolean add(int i){
	if (size()<data.length){
	    data[lastindex + 1]=i;
	    lastindex += 1;
	}
	else {
	    expand();
	    data[data.length-1]=i;
	    lastindex+=1;
	}
	return true;
    }
    
    public void add(int val,int index){
	if (size()<data.length){
	    for(int i=lastindex;i>=index;i--){
		data[i+1]=data[i];
	    }
	    data[index]=val;
	    lastindex+=1;
	}
	else{
	    expand();
	    add(val,index);
	}
    }
   
    public int get(int index){
	return data[index];
    }
   
    public int set(int val, int index){
	int ans = data[index];
	data[index]=val;
	return ans;
    }
    
    public int size(){
	return lastindex+1;
    }
    
    public int remove(int index){
	int ans = data[index];
	for (int i=index;i<lastindex;i++){
	    data[i]=data[i+1];
	}
	data[lastindex]=0;
	lastindex=lastindex-1;
	return ans;
    }
}