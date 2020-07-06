
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
		if (numberElements < this.data.length) {
			this.numberElements += 1;
			this.data[numberElements-1] = value;
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
/* 		testArray.add(5);
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
		System.out.println(Arrays.toString(testArray.data)); //Should not add element to array, since numberElements already maxed */
		
		System.out.println(testArray.get(0)); //Should return 3
		System.out.println(testArray.get(1)); //Should return 5
		System.out.println(testArray.get(2)); //Should return error of -1
		
		System.out.println(testArray2.isEmpty()); //Should return true
		System.out.println(testArray.isEmpty()); //Should return false
		
		System.out.println(testArray.toString()); //Should print [3,5]
		System.out.println(testArray2.toString()); //Should print []
	}
	
}