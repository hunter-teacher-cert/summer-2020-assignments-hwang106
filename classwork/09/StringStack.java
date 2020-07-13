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
		
		/*This algorithm was an elegant one Sam brought up, but not implemented here (mine is very janky but potentially more broadly applicable): reverse String Stack		
		have a counter variable to increments if openParen detected and decrements if closedParen detected	
		if counter variable is ever less than 0, false; if counter variable ends as greater than 0*/
		
		//convert String s to stack and reversed version to stack as well
		Stack<Character> stringToStack = stringToStack(s);
		Stack<Character> reversedStringStack = stringToStack(reverse(s)); //Temporary implementation; there is probably a more efficient implementation		
		boolean closedParen;
		boolean openParen;
		
		int originalStackSize = stringToStack.size();
		
		
		//iterate/pop through s, looking for cases of "("; return true if found
		
		//while stringToStack.size() > 0 
		
		do{
			openParen = false;
			closedParen = false;			
			int stackSize = stringToStack.size();
			int revStackSize = reversedStringStack.size();
			int stackCheckSize = stackSize + revStackSize - originalStackSize;
			
			for (int i = 0; i < stackCheckSize; i++){

				char currentPop = stringToStack.pop();
				
				if (currentPop == '('){
					return false;
				}
				
				if (currentPop == ')'){
					closedParen = true;
					break;
				}
				
			}
			
			for (int i = 0; i < stackCheckSize; i++){
				char currentPopR = reversedStringStack.pop();
				
				if (currentPopR == ')'){
					return false;
				}
				
				if (currentPopR == '('){
					openParen = true;
					break;
				}
			}
		} 
		while ((openParen && closedParen) && (stringToStack.size() + reversedStringStack.size() - originalStackSize > 0));
		
		//if found, iterate through reversed s, looking for cases of ")" return true if found
		
		//if both are found, repeat process until nothing left to pop
		
		//return whether true for all cases
		return (openParen && closedParen) || (!openParen && !closedParen);
	}  
	 
	
	public static void main(String[] args){
		
		//String s1 = reverse("Huan");
		//System.out.println(s1);
		//System.out.println(isPalindrome("Huan"));
		//System.out.println(isPalindrome("racecar"));
		//System.out.println(stringToStack("racecad").pop());
		System.out.println(parenCheck("(Hell(o(o)oo()))"));
		
	}
	
}