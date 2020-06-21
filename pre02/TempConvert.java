import java.util.Scanner;

//Converts Celsius to Fahrenheit
public class TempConvert {
	
	public static void main(String[] args){
		double celsius;
		double fahrenheit;
		final double convertRatio = 9.0/5.0;
		final double addend = 32.0;
		
		
		//Prompts user for temperature in Celsius
		System.out.print("What is the temperature in Celsius?");
		Scanner in = new Scanner(System.in);
		celsius = in.nextDouble();
		
		//Calculates conversion
		fahrenheit = celsius * convertRatio + addend;
		System.out.printf("%.1f C = %.1f F", celsius, fahrenheit);
		
	}
	
}