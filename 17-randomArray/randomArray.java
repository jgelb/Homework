import java.io.*;
import java.util.*;
public class randomArray{
    ArrayList<Integer> al = new ArrayList<Integer>();
    public randomArray(int x){
	for (int i=0;i<x;i++){
	    al.add(i);
	}
    }
    public boolean in(int[] ints,int y){
	for (int i=0;i<ints.length;i++){
	    if (ints[i] == y){
		return true;
	    }
	}
	return false;
    }
    public ArrayList<Integer> changeArrayList(){
	ArrayList<Integer> al2 = new ArrayList<Integer>();
	Random r = new Random();
	int[] array = new int[al.size()];
	int arrayCounter = 0;
	for (int i=0;i<al.size();i++){
	    int index = r.nextInt(al.size());
	    if (!in(array,index)){
		al2.add(index,i);
		array[arrayCounter] = index;
		arrayCounter++;
	    }
	    else {
		i--;
 	    }
	}
	return al2;
    }
    public int[] changeArray(){
	int[] al2 = new int[al.size()];
	Random r = new Random();
	int[] array = new int[al.size()];
	int arrayCounter = 0;
	for (int i=0;i<al.size();i++){
	    int index = r.nextInt(al.size());
	    if (!in(array,index)){
		al2[index]=i;
		array[arrayCounter] = index;
		arrayCounter++;
	    }
	    else {
		i--;
	    }
	}
	return al2;
    }
}
