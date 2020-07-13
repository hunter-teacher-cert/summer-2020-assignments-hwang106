import java.io.*;
import java.util.*;

public class StringStack{
	
	public static String reverse(String s){
		Stack<Character> stringToStack = new Stack<Character>();
		String reversedString = "";
		
		for (int i = 0; i < s.length(); i++){
			stringToStack.push(s.charAt(i));
		}
		
		for (int i = 0; i < s.length(); i++){
			reversedString += stringToStack.pop();
		}
		
		return reversedString;
	}
	
	public static boolean isPalindrome(String s){
		
		String reversedString = reverse(s);
		return reversedString.equals(s);
		
	}
	
	
	public static void main(String[] args){
		
		String s1 = reverse("Huan");
		System.out.println(s1);
		System.out.println(isPalindrome("Huan"));
		System.out.println(isPalindrome("racecar"));
		
	}
	
}