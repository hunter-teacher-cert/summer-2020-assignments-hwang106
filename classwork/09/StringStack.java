import java.io.*;
import java.util.*;

public class StringStack{
	
	public static Stack<Character> stringToCharStack(String s){
		Stack<Character> stringToStack = new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++){
			stringToStack.push(s.charAt(i));
		}
		
		return stringToStack;
	}
	
	public static Stack<String> stringToSubstringStack(String s){
		Stack<String> stringStack = new Stack<String>();
		
		int index1 = 0;
		int index2 = s.indexOf(' ', index1);
		String sub = "";
		while (index2 != -1){ //-1 is the default value when the value cannot be found within specified indices
			sub = s.substring(index1, index2);
			stringStack.push(sub);			
			index1 = index2 + 1;
			index2 = s.indexOf(' ', index1);

			stringStack.push(" "); //kind of a cheap way to make sure the space bewteen substrings is pushed as a stack element (specifically for the purposes of reverse)
			 
		}
		
		sub = s.substring(index1, s.length());
		stringStack.push(sub);
		
		return stringStack;
	}
	
	public static String reverse(String s){
		Stack stringToStack;
		//checks for space delimiter to decide whether to create a CharStack or a SubstringStack
		if (s.indexOf(' ') == -1){
			stringToStack = stringToCharStack(s);
		}
		else {
			stringToStack = stringToSubstringStack(s);
		}
		
		//initializes reversedString and sets original stack size for use in for loop, which will dynamically change the stack size with each pop
		String reversedString = "";
		int stackSize = stringToStack.size();
		
		
		for (int i = 0; i < stackSize; i++){
			reversedString += stringToStack.pop();
		}
		
		return reversedString;
	}
	
	public static boolean isPalindrome(String s){		
		//could potentially be more efficient if only half of the String is reversed and checked with first half of existing String, but hey reverse method already exists!
		String reversedString = reverse(s);
		return reversedString.equals(s);		
	}
	
	public static boolean parenCheck(String s){
		//a more complex version of this method exists two methods below (commented out), but it only works for special cases
		int counter = 0;
		Stack<Character> stringToCharStack = stringToCharStack(s);
		int stackSize = stringToCharStack.size();
		
		for (int i = 0; i < stackSize; i++){
			char currentPop = stringToCharStack.pop();
			
			if (currentPop == ')'){
				counter++;
			}
			
			else if (currentPop == '('){
				counter--;
			}
			
			if (counter < 0){
				return false;
			}
		}
		return counter == 0;
	}
	
	public static boolean parenCheck2(String s){
		
		//3 counters, whatever type of bracket that appears first will change increment c1
		//([)] c2 can never be less than c1 (i.e. counter 2 needs to resolve to 0 before c1)
		
		int c1 = 0; //counter for ()
		int c2 = 0; //counter for {}
		int c3 = 0; //counter for []
		int c1p = 0; //place to store prior values of c1 before increment/decrement for false check purposes
		int c2p = 0; //"" but for c2
		int c3p = 0; // "" but for c3
		Stack<Character> stringToCharStack = stringToCharStack(s);
		int stackSize = stringToCharStack.size();
		
		for (int i = 0; i < stackSize; i++){
			char currentPop = stringToCharStack.pop();
			
			if (currentPop == ')'){
				c1p = c1;
				c1++;
			}			
			else if (currentPop == '('){
				c1p = c1;
				c1--;
			}
			
			else if (currentPop == '}'){
				c2p = c2;
				c2++;
			}
			else if (currentPop == '{'){
				c2p = c2;
				c2--;
			}
			
			else if (currentPop == ']'){
				c3p = c3;
				c3++;
			}
			else if (currentPop == '['){
				c3--;
			}
			
			if (c1 < 0 || c2 < 0 || c3 < 0){
				return false;
			}
			
			if (c1 > c1p && c2 <= c2p && c3 <= c3p && c2 != 0 && c3 != 0){
				if (currentPop == '{' || currentPop == '['){
					return false;
				}
			}
			
			if (c2 > c2p && c1 <= c1p && c3 <= c3p && c1 != 0 && c3 != 0){
				if (currentPop == '(' || currentPop == '['){
					return false;
				}
			}
			
			if (c3 > c3p && c1 <= c1p && c2 <= c2p && c1 != 0 && c2 != 0){
				if (currentPop == '(' || currentPop == '{'){
					return false;
				}
			}
			
		}
		return c1 == 0 && c2 == 0 && c3 == 0;
	}
	
 	/* public static boolean parenCheck(String s){
		//only works for special cases where there are only nested parentheses; does not work for consecutive open/closed parentheses
		
		//convert String s to stack and reversed version to stack as well
		Stack<Character> stringToStack = stringToCharStack(s);
		Stack<Character> reversedStringStack = stringToCharStack(reverse(s)); //Temporary implementation; there is probably a more efficient implementation		
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
		
		String s1 = reverse("Huan");
		System.out.println(s1);
		System.out.println(isPalindrome("Huan"));
		System.out.println(isPalindrome("racecar"));
		System.out.println(stringToCharStack("racecad").pop());
		System.out.println(stringToSubstringStack("Who am I really?    really?"));
		System.out.println(reverse("WhoamIreally?"));
		System.out.println(reverse("Who am I really?"));
		System.out.println(reverse("i am what am i"));
		System.out.println(isPalindrome("i am what am i"));
		System.out.println(parenCheck2("(x+3)")); //true
		System.out.println(parenCheck2("(x+(3)")); //false
		System.out.println(parenCheck2("(x+(3))")); //true
		System.out.println(parenCheck2("x+(x+3)")); //true
		System.out.println(parenCheck2(")(x+3)")); //false
		System.out.println(parenCheck2(")(x+3)(")); //false
	System.out.println(parenCheck2("{[(]x+3)}(x+2)")); //should be true but will be false with second implemenation of parenCheck 
		
		
	}
	
}