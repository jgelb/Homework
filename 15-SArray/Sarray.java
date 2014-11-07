public class Sarray {
    	int[] data;	// Data Set, larger array
    	int last; 	// Actual current length, not the data set

    	public Sarray() {
        	// set up the initial instance variables
		// CREATE 16 BIT ALLOCATION
		data = new int[16];
		// Set default value to 0
		for (int i = 0; i < data.length; i++){
			data[i] = 0;
		}
		last = 0;
    	}

    	public boolean add(int i){
        	// adds an item to the end of the list, grow if needed
        	// returns true
		try {
			if (size() == data.length){
				int[] buffer = new int[data.length + 1];
				for (int i = 0; i < data.length; i++){
					buffer[i] = data[i];
				}
				buffer[data.length] = i;
				data = buffer;
				last++;
			}
			else {
				data[last] = i;
				last++;
			}
			return true;
		} catch(Exception e){
			e.printStackTrace();
		}
		return false;
    	}

    	public void add(int index, int i){
        	// adds item i  at index, shifting everything down as needed.
        	// also grows as needed
		if (last < index) {last = index - 1;} //Grow!
		int[] buffer = new int[last + 1]; // OBOE! Off By One Error! Binary exploitation time :D
		
    	}

    	public int size() {
        	// returns the number of items in the list (not the array size)
		return last;
    	}

    	public int get(int index) {
        	// returns the item at location index of the lsit
    	}

    	public int set(int index, int i){
        	// sets the item at location index to value i
        	// returns the old value.
    	}

    	public int remove(int index){
        	// removes the item at index i
        	// returns the old value
    	}
}
