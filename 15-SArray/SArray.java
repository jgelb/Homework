public class SArray{
	private Object[] data; //Should really be object[] data
	public SArray(){
		//Start array at size 16
		data = new Object[16];
		for (int i = 0; i < data.length; i++){
			data[i] = null;
		}
	}
	public SArray(int len){
		data = new Object[len];
		for (int i = 0; i < data.length; i++){
			data[i] = null;
		}
	}
	public Object[] add(Object obj){
		//Adds object to end of array
		if (size() == data.length){
			Object[] buffer = new Object[data.length + 1];
			for (int i = 0; i < data.length; i++){buffer[i] = data[i];}
			buffer[data.length] = obj;
			return buffer;
		}
		else {
			data[size()] = obj;
			return data;
		}
	}
	public Object[] add(int index , Object obj){
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
			return buffer;
		} catch(Exception e){e.printStackTrace(); System.out.println("Index cannot be inserted, Out of Range.");}
		return data;
	}
	public Object get(int index){
		//Gets object at index
		return data[index];
	}
	public void set(int index , Object obj){
		//Set object at index to obj
		data[index] = obj;
	}
	public int size(){
		//Returns length of array
		int k = 0;
		for (k = 0; k < data.length; k++){
			if (data[k] == null){
				return k;
			}
		}
		return data.length; //Default case
	}
	public Object[] remove(int index){
		//Removes object at index, shifts everything over
		Object[] buffer = new Object[size() - 1];
		for (int i = 0; i < buffer.length; i++){
			if (i < index){
                        	buffer[i] = data[i];
                        }
                        else if (i == index) {
                                //buffer[i] = obj;
                        }
                        else {
                                buffer[i] = data[i - 1];
                        }
                }
                return buffer;
	}
/*
	public Object[] pop(int index){
		//Removes object , turns it to null
	}
*/
}
