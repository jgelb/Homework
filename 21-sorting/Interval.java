import java.util.*;
import java.io.*;

public class Interval {
    int low,high;
    public Interval(){
    
    boolean check = false;
    Random r = new Random();
    low = r.nextInt(100);
    while (check == false){
        int x = r.nextInt(100);
        if(x >= low) {
            high = x + 1;
            check = true;
        }
    }
    }
    public String toString(){
    return "[ " + low + ", " + high + " ] ";
    }
    public int getLow(){
	return low;
    }
    public int getHigh(){
	return high;
    }
   
    public int compareTo(Interval other){
	if (this.getLow() == other.getLow() ){
		return this.getHigh() - other.getHigh();
	}
	else{
		return this.getLow()-other.getLow();}
    }

	    

    
    public static void main(String[] args){
    Interval k = new Interval();
    System.out.println(k);
    Interval[] lists = new Interval[10];
    int i = 0;
    while (i < 10){
        lists[i] = new Interval();
        i ++;
    }
    System.out.println(Arrays.toString(lists));
       
    }}
