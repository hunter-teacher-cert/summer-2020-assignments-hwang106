//exercises 1, 4, and 5

import java.util.Arrays;
import java.util.Random;

public class ArrayExample{

	public static double[] powArray(double[] a, double b){
	
		for (int i = 0; i < a.length; i++){
		
			a[i] = Math.pow(a[i], b);
		
		}
	
		return a;
	
	}

	
	public static int[] histogram(int[] values, int countNumber) {
		
		int[] counts = new int[countNumber];
		
		for (int value : values){
			
			if (value < countNumber){
				counts[value]++;
			}
		}
		
		return counts;
	}
	
	public static int indexOfMax(int[] values){
		
		int arrayMax = 0;
		int maxIndex = 0;
		
		for (int i = 0; i<values.length; i++){ //cannot use an enhanced for loop, since we need to refer to the index to return the index of the max value.
			
			if (values[i] > arrayMax){
				
				arrayMax = values[i];
				maxIndex = i;
				
			}
						
		}
		
		return maxIndex; 
	}
		
	public static boolean[] sieve(int n){
		
		boolean[] arrayPrime = new boolean[n];
		
		for (int i = 0; i < n; i++){
			
			arrayPrime[i] = true;
			
		}
		
		arrayPrime[0] = false;
		arrayPrime[1] = false;
		
		for (int i = 0; i < n; i++){
			
			if (arrayPrime[i] == true && (i*i) < n) {
				
				for (int j = i * i; j < n; j += i){
					
					arrayPrime[j] = false;
					
				}
									
			}
			
			
		}
		
		return arrayPrime;
		
	}
	
	public static void main(String[] args){
	
		/*double[] test = {1.0, 2.0, 3.0, 4.0}; //arbitrary array for debugging powArray
	
		System.out.println(Arrays.toString(powArray(test, 3))); */
		
		Random random = new Random(); //used for generating random values in randomArray
		
		int[] randomArray = new int[20]; //arbitrary array used for debugging histogram and indexOfMax
		
		for (int i=0; i<randomArray.length; i++){
			
			randomArray[i] = random.nextInt(100);
			
		}
		
		//System.out.println(Arrays.toString(histogram(randomArray, 30))); //used for debugging histogram
		
		//System.out.println(Arrays.toString(randomArray)); //used for debugging indexOfMax
		//System.out.println(indexOfMax(randomArray)); //used for debugging indexOfMax
		
		System.out.println(Arrays.toString(sieve(20)));

	}

}