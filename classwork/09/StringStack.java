import java.io.*;
import java.util.*;

public class StringStack{
	
	public static Stack stringToStack(String s){
		Stack<Character> stringToStack = new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++){
			stringToStack.push(s.charAt(i));
		}
		
		return stringToStack;
	}
	
	public static String reverse(String s){
		Stack stringToStack = stringToStack(s);
		String reversedString = "";
		
		
		for (int i = 0; i < s.length(); i++){
			reversedString += stringToStack.pop();
		}
		
		return reversedString;
	}
	
	public static boolean isPalindrome(String s){		
		String reversedString = reverse(s);
		return reversedString.equals(s);		
	}
	
	public static boolean parenCheck(String s){
		
		int counter = 0;
		Stack<Character> stringToStack = stringToStack(s);
		int stackSize = stringToStack.size();
		
		for (int i = 0; i < stackSize; i++){
			char currentPop = stringToStack.pop();
			
			if (currentPop == ')'){
				counter++;
			}
			
			if (currentPop == '('){
				counter--;
			}
			
			if (counter < 0){
				return false;
			}
		}
		return counter == 0;
	}
	
 	/* public static boolean parenCheck(String s){
		
		//convert String s to stack and reversed version to stack as well
		Stack<Character> stringToStack = stringToStack(s);
		Stack<Character> reversedStringStack = stringToStack(reverse(s)); //Temporary implementation; there is probably a more efficient implementation		
		boolean closedParen;
		boolean openParen;
		
		int originalStackSize = stringToStack.size();
		
		
		//iterate/pop through s, looking for cases of "("; set true if found
		
		
		
		do{ //using do/while to allow entry into loop without initially meeting while conditions (since closedParen and openParen are not intialized)
			openParen = false;
			closedParen = false;			
			int stackSize = stringToStack.size();
			int revStackSize = reversedStringStack.size();
			int stackCheckSize = stackSize + revStackSize - originalStackSize; //this limits how far to iterate into the stack based on how far the reverse stack has already been iterated
			
			for (int i = 0; i < stackCheckSize; i++){

				char currentPop = stringToStack.pop();
				
				if (currentPop == '('){ //since the backwards stack should never start with an open parentheses, this immediately returns false 
					return false; 
				}
				
				if (currentPop == ')'){
					closedParen = true;
					break;
				}
				
			}
			
			for (int i = 0; i < stackCheckSize; i++){
				char currentPopR = reversedStringStack.pop();
				
				if (currentPopR == ')'){ //since the forwards StringStack should never start with a closed parentheses, this immediately returns false
					return false;
				}
				
				if (currentPopR == '('){
					openParen = true;
					break;
				}
			}
		} 
		while ((openParen && closedParen) && (stringToStack.size() + reversedStringStack.size() - originalStackSize > 0));
		
		//if found, iterate through reversed s, looking for cases of ")" set to true if found
		
		//if both are found, repeat process until nothing left to pop
		
		//return whether true for all cases
		return (openParen && closedParen) || (!openParen && !closedParen);
	}  
	 */ 
	
	public static void main(String[] args){
		
		//String s1 = reverse("Huan");
		//System.out.println(s1);
		//System.out.println(isPalindrome("Huan"));
		//System.out.println(isPalindrome("racecar"));
		//System.out.println(stringToStack("racecad").pop());
		System.out.println(parenCheck("(x+3)")); //true
		System.out.println(parenCheck("(x+(3)")); //false
		System.out.println(parenCheck("(x+(3))")); //true
		System.out.println(parenCheck("x+(x+3)")); //true
		System.out.println(parenCheck(")(x+3)")); //false
		System.out.println(parenCheck(")(x+3)(")); //false
		System.out.println(parenCheck("(x+3)(x+2)")); //should be true but will be false with second implemenation of parenCheck 
		
	}
	
}