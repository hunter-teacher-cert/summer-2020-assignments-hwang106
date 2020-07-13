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
		//convert String s to stack and reversed version to stack as well
		Stack<Character> stringToStack = stringToStack(s);
		Stack<Character> reversedStringStack = stringToStack(reverse(s)); //Temporary implementation; there is probably a more efficient implementation		
		boolean openParen = false;
		boolean closedParen = false;
		
		//iterate/pop through s, looking for cases of "("; return true if found
		for (int i = 0; i < s.length(); i++){
			char currentPop = stringToStack.pop();
			char currentPopR = reversedStringStack.pop();

			
			if (currentPop == '('){
				openParen = true;				
			}
			if (currentPopR == ')'){
				closedParen = true;
			}
			
		}
		
		//if found, iterate through reversed s, looking for cases of ")" return true if found
		
		//if both are found, repeat process until nothing left to pop
		
		//return whether true for all cases
		return openParen && closedParen;
	}  
	 
	
	public static void main(String[] args){
		
		String s1 = reverse("Huan");
		System.out.println(s1);
		System.out.println(isPalindrome("Huan"));
		System.out.println(isPalindrome("racecar"));
		//System.out.println(stringToStack("racecad").pop());
		System.out.println(parenCheck("H((e)o"));
		
	}
	
}