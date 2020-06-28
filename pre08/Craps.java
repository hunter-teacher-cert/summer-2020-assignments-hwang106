import java.util.Random;
import java.util.Arrays;

public class Craps{
	
	public static int roll(int dice){
		
		Random random = new Random();
		
		return random.nextInt(dice) + 1;
		
	}
	
	public static int shoot(int diceNumber, int maxValue){
		
		int result = 0; //initializes sum of dice rolls to 0
		
		for (int i = 0; i < diceNumber; i++){
			
			result += roll(maxValue); 
			
		}
		
		return result;
	}
	
	public static String round(){
		
		int diceSum = shoot(2,6);
		
		//System.out.println(diceSum); //for debugging purposes
		
		if (diceSum == 2 || diceSum == 3 || diceSum == 12){
			return ("You rolled " + diceSum + ". That's Craps; you lose.");
		}
		
		else if (diceSum == 7 || diceSum == 11){
			return ("You rolled " + diceSum + ". That's a Natural; you win.");
		}
		
		else {
			int Point = diceSum;
			int retry = shoot(2,6);
			//System.out.println(retry); //for debugging purposes
			while (retry != 7 && retry != Point){
				retry = shoot(2,6);
				//System.out.println(retry); //for debugging purposes
			}
			if (retry == 7){
				return "That's a 7; you lose.";
			}
			else {
				return ("You rolled " + Point + ". That's Point; you win.");
			}
		}
	}
	
	public static void main(String[] args){
		
		int numRounds = 0;
		
		if (args.length != 0){
			numRounds = Integer.parseInt(args[0]);
		}
		
		System.out.println(numRounds);
		
		for (int i = 0; i<numRounds; i++){
			
			System.out.println("Round " + (i+1) + ": " + round());
			
		}
	
		
	} 
	
}
