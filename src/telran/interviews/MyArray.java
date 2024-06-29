package telran.interviews;
//all methods must have complexity O[1]
public class MyArray<T> {
 private Object[] array;
	public void setAll(T value) {
		//DONE
		//all array's elements should be set with a given value
	    for(int i = 0; i < array.length; i++) {
	    	array[i] = value;
	    }
	}
	
	public void set(int index, T value) {
		//DONE
		//set new value at a given index
		//throws ArrayIndexOutOfBoundsException for incorrect index
	    if(index < 0 || index >= array.length) {
	    	throw new ArrayIndexOutOfBoundsException("Uncorect index bro");
	    }
	    array[index] = value;
	}
	@SuppressWarnings("unchecked")
	public T get(int index) {
		//DONE
		//returns a value at a given index
		//throws ArrayIndexOutOfBoundsException for incorrect index
		if(index < 0 || index >= array.length) {
			throw new ArrayIndexOutOfBoundsException("Same shit bro! Index not correct");
		}
		return (T) array[index];
	}
	public MyArray(int size) {
		//DONE creates the Array object for a given size
		//with setting null's at each element
		array = new Object[size];
	}
}