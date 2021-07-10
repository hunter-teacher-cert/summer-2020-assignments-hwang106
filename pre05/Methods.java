
public class Methods{
	
	/**
	 *A method named isDivisible that takes two integers, n and m, and that returns true if n is divisible by m, and false otherwise.
	 *@param n an integer that represents the dividend
	 *@param m an integer that represents the divisor
	 *@return returns a boolean representing whether n is divisible by m
	*/
	
	public static boolean isDivisible(int n, int m){
		
		return n % m == 0;
		
	} 
	
	/**
	 *A method named ack to translate a recursive definition into a Java method. 
	 *A(m, n) = n+1 if m = 0; A(m-1,1) if m greater than 0 and n=0; A(m-1,A(m,n-1)) if m greater than 0 and n less than 0	
   	 *@param m an integer representing the first parameter of the Ackermann function
	 *@param n an integer representing the second parameters of the Ackermann function
	 *@return returns an integer that is the output of the Ackermann function
	*/
	
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
	
	/**
	 *A method named isTriangle that takes three integers as arguments and returns either true or false, depending on whether you can or cannot form a triangle from sticks with the given lengths. 
	 *@param a a double representing the first stick in a potential triangle
	 *@param b a double representing the second stick in a potential triangle
	 *@param c a double representing the third stick in a potential triangle
	 *@return returns a boolean representing if a triangle can be formed
	*/
	
	public static boolean isTriangle(double a, double b, double c){
		
		return ((a+b)>c && (a+c)>b && (b+c)>a);
		
		
	}
	
	
	public static void main(String[] args){
		
		System.out.println(isTriangle(3,4,5));
		System.out.println(isTriangle(1,1,5));
		System.out.println(isDivisible(3,5));
		System.out.println(isDivisible(6,2));
		System.out.println(ack(3,2));
		
		
	}
	
}


