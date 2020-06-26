//exercises 3, 4, and 5

public class Loops{
	
	
	public static double powerIt(double x, double n){
		
		double b = x;
		
		if (n > 0){
			for (double i = 1; i<n; i++) {
			
				x = x * b;
		
			}
			
			//System.out.println(x);
			
			return x;
		}
		
		else if (n == 0){
			
			return 1;
		}
		
		else
			for (double i = 1; i<-n; i++) {
				
				x = x * b;
				
			}
			
		//System.out.println(1/x);
		
		return 1/x;
	}
	
	public static double factorialIt(double x){
		
		if (x > 0){
		
			for (double i = x - 1; i>0; i--){
				
				x = x * (i);
			
			}
		
			//System.out.println(x);
		
			return x;
		}
		
		else if (x == 0){
			
			//System.out.println(1);
			
			return 1.0;
			
		}
		
		else {
			
			//System.out.println(0);
			
			return 0.0; //0 represents an error value
		}
		
	}
	
	
	public static double myexp(double x, double n){
		
		double e = 0;
		
		for (double i = 0; i<n; i++){
			
						
			e = e + powerIt(x, i)/factorialIt(i);
			
			
		}

		//System.out.println(e);
		
		return e;
		
	}
	
	public static double myexp2(double x, double n){
		
		double e = 0;
		double p = powerIt(x, 0);
		double f = factorialIt(0);
		
		for (double i = 1; i<n+1; i++){
									
			e = e + (p/f);
			
			p = p * x;
			
			f = f * i;
			
		}

		//System.out.println(e);
		
		return e;
		
	}
	
	public static void check(double x, double n){
		
		System.out.println(x + "\t" + myexp2(x, n) + "\t" + Math.exp(x));
		
		
	}
	
	public static void main(String[] args){
		
		check(1,17);
		check(1,18);
		check(1,19);
		
		double x = .1;
		
		for (int i = 1; i <5; i++){
						
			check(x, 18);
			
			x = x * 10;
			
		} // The accuracy of the result decreases as x approaches infinity.

		double y = -.1;
		powerIt()
		for (int i = 1; i <5; i++){
						
			check(y, 18);
			
			y = y * 10;
			
		} // The accuracy of the result decreases as x approached -infinity. In fact the sign of the result (since myexp relies)
		
	}
	
	
}