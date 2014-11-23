public class SArray{
	private Object[] data;
	private int internalLength;
	public SArray(){
		//Start array at size 16
		data = new Object[16];
		for (int i = 0; i < data.length; i++){
			data[i] = null;
		}
		internalLength = 0;
	}
	public SArray(int len){
		data = new Object[len];
		for (int i = 0; i < data.length; i++){
			data[i] = null;
		}
		internalLength = len;
	}
        public SArray(int[] someArray){
                data = new Object[someArray.length];
                for (int i = 0; i < someArray.length; i++){
                        data[i] = someArray[i];
                }
                internalLength = someArray.length;
        }
        public SArray(String[] someArray){
                data = new Object[someArray.length];
                for (int i = 0; i < someArray.length; i++){
                        data[i] = someArray[i];
                }
                internalLength = someArray.length;
        }
        public SArray(boolean[] someArray){
                data = new Object[someArray.length];
                for (int i = 0; i < someArray.length; i++){
                        data[i] = someArray[i];
                }
                internalLength = someArray.length;
        }
        public SArray(char[] someArray){
                data = new Object[someArray.length];
                for (int i = 0; i < someArray.length; i++){
                        data[i] = someArray[i];
                }
                internalLength = someArray.length;
        }
	public SArray(Object[] someArray){
		data = new Object[someArray.length];
		for (int i = 0; i < someArray.length; i++){
			data[i] = someArray[i];
		}
		internalLength = someArray.length;
	}
	public void append(Object obj){
		//Adds object to end of array
		if (internalLength == data.length){
			Object[] buffer = new Object[data.length + 1];
			for (int i = 0; i < data.length; i++){buffer[i] = data[i];}
			buffer[data.length] = obj;
		//	return buffer;
			data = buffer;
		}
		else {
			data[internalLength] = obj;
		//	return data;
		}
		internalLength++;
	}
	public void add(int index , Object obj){
		//Adds object at index of array, shifts everything else over
		try{
			Object[] buffer = new Object[size() + 1];
			for (int i = 0; i < buffer.length; i++){
				if (i < index){
					buffer[i] = data[i];
				}
				else if (i == index) {
					buffer[i] = obj;
				}
				else {
					buffer[i] = data[i - 1];
				}
			}
			data = buffer;
			internalLength++;
		//	return buffer;
		} catch(Exception e){e.printStackTrace(); System.out.println("Index cannot be inserted, Out of Range.");}
		//return data;
	}
	public void addAtBeginning(Object obj){
		add(0 , obj);
	}
	public void replace(int index , Object obj){
		//Replaces object at index of array, does not shift elements
		if (index > internalLength - 1){
			System.out.println("Index does not exist. Cannot modify.");
		}
		else{
			data[index] = obj;
		}
	}
	public void terminate(int index){
		replace(index , null);
	}
	public Object get(int index){
		//Gets object at index
		try{
			return data[index];
		} catch(Exception e){
			System.out.println("Index does not exist: Index = " + index);
			e.printStackTrace();
		}
		return null;
	}
	public void set(int index , Object obj){
		//Set object at index to obj
		//Same as replace, just a different name, and arguably more stable. Or less stable.
		try{
			data[index] = obj;
		} catch(Exception e){
			System.out.println("Index does not exist. Cannot set object: Index = " + index);
			e.printStackTrace();
		}
	}
	public static SArray concatenate(SArray beginning , SArray end){
		//USAGE: SArray x = SArray.concatenate(a , b);
		SArray combined = new SArray(beginning.size() + end.size()); // Create the final array
		for (int i = 0; i < beginning.size(); i++){
			combined.replace(i , beginning.get(i));
		}
		for (int i = 0; i < end.size(); i++){
			combined.replace(i + beginning.size() , end.get(i));
		}
		return combined;
	}
	public int size(){
		//Returns length of array
		return internalLength;
	}
	public void remove(int index){
		//Removes object at index, shifts everything over
		try{
			Object[] buffer = new Object[size() - 1];
			for (int i = 0; i < buffer.length; i++){
				if (i < index){
	                        	buffer[i] = data[i];
	                        }
	                        else if (i == index) {
	                                //buffer[i] = obj;
	                        }
	                        else {
	                                buffer[i] = data[i + 1];
	                        }
	                }
			internalLength--;
			data = buffer;
		} catch(Exception e){
			System.out.println("Index does not exist. Cannot be removed: Index = " + index);
			e.printStackTrace();
		}
	}
	public SArray subset(int lower, int higher){
		//Lower is inclusive, higher is exclusive
		SArray sub = new SArray(higher - lower);
		for (int i = 0; i < sub.size(); i++){
			sub.replace(i , data[i + lower]);
		}
		return sub;
	}
	public void print(){
		String toPrint = "{";
		for (int i = 0; i < internalLength; i++){
			toPrint += data[i] + ", ";
		}
		toPrint = toPrint.substring(0,toPrint.length() - 2) + "}";
		System.out.println(toPrint);
	}
}
