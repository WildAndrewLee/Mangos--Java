/**
 * Booleans take too much space, especially if you have a lot.
 * 
 * Utilizes bit-wise operators to facilitate the creation
 * and manipulation of a large number of boolean values.
 * 
 * Recommended Minimum Number of Booleans: 16
 * When using this with less than 12 booleans an array of booleans
 * would be more efficient than a BitArray.
 * 
 * @author Andrew
 */

public class BitArray {
	private int[] intPool = null;
	private int pos = 0;
	private int bit = 0;
	
	public BitArray(){
		intPool = new int[1];
		
		assert intPool != null;
	}
	
	public BitArray(int size){
		intPool = new int[size];
		
		assert intPool != null;
	}
	
	public boolean isFull(){
		assert intPool != null;
		
		return bit == 32 && pos == intPool.length;
	}
	
	private void doubleSize(){
		assert intPool != null;
		
		int[] temp = new int[intPool.length * 2];
		
		System.arraycopy(intPool, 0, temp, 0, intPool.length);
		
		intPool = temp;
		
		bit = 0;
		pos += 1;
	}
	
	public void set(int index, boolean value){
		assert index >= 0;
		assert index < intPool.length * 32;
				
		int n = index / 32 * 32;
		int p = index % 32;
		
		if(value) intPool[n] = intPool[n] | (1 << p);
		else intPool[n] = intPool[n] & ~(1 << p);
	}
	
	public void add(boolean value){
		assert intPool != null;
		
		if(isFull()) doubleSize();
		
		set(pos * 32 + bit, value);
	}
}