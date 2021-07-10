
import java.util.*;

public class Practice{
	
	public static int factorial(int n){
	
		if (n==0){
			return 1;
		}
		
		else{
			return n * factorial (n-1);
		}
		
	}
	
	public static int fib(int n){
		
		if (n==1 || n==2){
			return 1;
		}
		
		else{
			return fib(n-1) + fib(n-2);
		}
		
	}
	
	public static int ack(int m, int n){
		
		if (m == 0){
			return n + 1;			
		}
		
		else if (m > 0 && n == 0){	
			return ack(m-1, 1);			
		}
		
		else if (m > 0 && n > 0){			
			return ack(m-1, ack(m, n-1));	
		}
		
		else{			
			return 0; //0 would represent an error value			
		}
	}
	
	public static int recursiveSum(int[] ia){//, int lowIndex, int highIndex){
		//for cases where the array is odd and can reach a middle
		/*if (ia.length%2 != 0){
				
			if (lowIndex == highIndex){
				return ia[lowIndex];
			}
		
			else{
				return ia[lowIndex] + ia[highIndex] + recursiveSum(ia, lowIndex + 1, highIndex-1);
			}
		}
		//for cases where the array is even and will not reach a middle
		else{
			if (lowIndex == highIndex-1){
				return ia[lowIndex] + ia[highIndex];
			}
			
			else{
				return ia[lowIndex] + ia[highIndex] + recursiveSum(ia, lowIndex + 1, highIndex -1);
			}
			
		}*/
		
		if (ia.length == 1){
			return ia[0];
		}
		else {
			return ia[ia.length-1] + recursiveSum(Arrays.copyOf(ia, ia.length-1));
		}
		
	}
	
	/*public static int recursiveSumCall(int[] ia){
		int lowIndex = 0;
		int highIndex = ia.length -1;
		return recursiveSum(ia, lowIndex, highIndex);
	}*/

	public static void main(String[] args){
		
		System.out.println("Hello World!");
		
		System.out.println(factorial(3));
		
		System.out.println(fib(5));
		
		System.out.println(ack(3,4));
		
		int[] testArray = {3, 0, 2, 2, 7, 8};
		
		//System.out.println(recursiveSumCall(testArray));
		
		System.out.println(recursiveSum(testArray));
	}

}
