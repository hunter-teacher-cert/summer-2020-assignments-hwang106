
import java.util.*;

public class SuperArray {
	
	private int[] data;
	private int numberElements;
	
	public SuperArray() {
		this.numberElements = 0;
		this.data = new int[10];
	}
	
	public SuperArray(int size) {
		this.numberElements = 0;
		this.data = new int[size];
	}
	
	public void add(int value) {
		if (numberElements == this.data.length) {
			this.grow();
		}
		this.numberElements += 1;
		this.data[numberElements-1] = value;
	}
	
	public void add(int index, int value) {
		if (index < this.numberElements && index >= 0) { //prevents code from running if index is outside the bounds of numberElements
			if (this.data.length == this.numberElements){ //if original SuperArray is already at capacity, 10 is added to the capacity through the grow method
				this.grow();
			}
			SuperArray augmentArray = new SuperArray(this.data.length); 
			augmentArray.data[index] = value;
			augmentArray.numberElements = this.numberElements + 1;
			//if it is the index parameter, skip to next index and place value there
			//if it is not the index parameter, place value there
			//boundary scenario: what happens when the index of value is 0?
			
			for (int i = 0; i < this.numberElements; i++) {
				if (i < index) {
					augmentArray.data[i] = this.data[i];
				}
				else  {
					augmentArray.data[i+1] = this.data[i];
				}

			}
			
			this.data = augmentArray.data;
			this.numberElements = augmentArray.numberElements;
		}
		
		else if (index == this.numberElements) {
			this.add(value);
		}
	}
	
	public void remove(int index) {
		if (index < this.numberElements && index >=0) {
			SuperArray diminArray = new SuperArray(this.data.length);
			diminArray.numberElements = this.numberElements-1;
			
			for (int i = 0; i < diminArray.numberElements; i++) {
				if (i < index ) {
					diminArray.data[i] = this.data[i];
				}
				else {
					diminArray.data[i] = this.data[i+1];
				}
			}
		
		this.data = diminArray.data;
		this.numberElements = diminArray.numberElements;
		
		}
	} 
	
	public int get(int index){
		if (index < this.numberElements) {
			return this.data[index];
		}
		
		else {
			return -1; //default error value
		}
	}
	
	public boolean isEmpty() {
		return this.numberElements == 0;
	}
	
	//cheating method to print SuperArray
	/* public String toString() {
		
		int[] printArray = new int[this.numberElements];
		
		for (int i = 0; i < this.numberElements; i++) {
			printArray[i] = this.data[i];
		}
		
		return Arrays.toString(printArray);
	} */
	
	public String toString() {
		
		String arrayString = "[";
		
		for (int i = 0; i < this.numberElements - 1; i++) {
			arrayString += this.data[i] + ", ";
		} 
		
		if (this.numberElements != 0){
			arrayString += this.data[this.numberElements-1] + "]";
		}
		else {
			arrayString += "]";
		}
		return arrayString;
		
	}
	
	public void grow() {
		
		SuperArray augmentArray = new SuperArray(this.data.length + 10); //adds 10 to the original capacity of the referenced array in a new array
		augmentArray.numberElements = this.numberElements;
			
		for (int i = 0; i < this.numberElements; i++) {
			augmentArray.data[i] = this.data[i];
		}
		
		this.data = augmentArray.data;
		
	}
	
	/*
	//for testing purposes
	public static void main(String[] args) {
		
		SuperArray testArray = new SuperArray();
		System.out.println(Arrays.toString(testArray.data));
		
		SuperArray testArray2 = new SuperArray(20);
		System.out.println(Arrays.toString(testArray2.data));
		
		testArray.add(3);
		System.out.println(Arrays.toString(testArray.data)); //Should print out
		testArray.add(5);
		System.out.println(Arrays.toString(testArray.data));
 		testArray.add(5);
		System.out.println(Arrays.toString(testArray.data));
		testArray.add(3);
		System.out.println(Arrays.toString(testArray.data));
		testArray.add(5);
		System.out.println(Arrays.toString(testArray.data));
		testArray.add(5);
		System.out.println(Arrays.toString(testArray.data));
		testArray.add(3);
		System.out.println(Arrays.toString(testArray.data));
		testArray.add(5);
		System.out.println(Arrays.toString(testArray.data));
		testArray.add(5);
		System.out.println(Arrays.toString(testArray.data));
		testArray.add(3);
		System.out.println(Arrays.toString(testArray.data));
		testArray.add(5);
		System.out.println(Arrays.toString(testArray.data)); //Should not add element to array, since numberElements already maxed
		testArray.add(5);
		System.out.println(Arrays.toString(testArray.data)); //Should not add element to array, since numberElements already maxed 
		
		System.out.println(testArray.get(0)); //Should return 3
		System.out.println(testArray.get(1)); //Should return 5
		System.out.println(testArray.get(2)); //Should return error of -1
		
		System.out.println(testArray2.isEmpty()); //Should return true
		System.out.println(testArray.isEmpty()); //Should return false
		
		System.out.println(testArray.toString()); //Should print [3,5]
		System.out.println(testArray2.toString()); //Should print []
		
		SuperArray testArray3 = new SuperArray(3);
		System.out.println(Arrays.toString(testArray3.data));
		testArray3.add(2);
		System.out.println(Arrays.toString(testArray3.data));
		testArray3.add(2);
		System.out.println(Arrays.toString(testArray3.data));
		//testArray3.add(2);
		//System.out.println(Arrays.toString(testArray3.data));
		//testArray3.add(2);
		//System.out.println(Arrays.toString(testArray3.data));
		testArray3.add(0, 9); //tests boundary condition at 0
		System.out.println(Arrays.toString(testArray3.data));
		testArray3.add(2, 9);
		System.out.println(Arrays.toString(testArray3.data));
		testArray3.add(4, 9);
		System.out.println(Arrays.toString(testArray3.data));
		testArray3.remove(2);
		System.out.println(Arrays.toString(testArray3.data));
		

		
	} */
	
}