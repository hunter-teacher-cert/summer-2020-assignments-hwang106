import java.io.*;
import java.util.*;

public class StackDriver{
	
	public static void main(String[] args){
		
		Stack s1 = new Stack(); //to test out Stack2, just replace with Stack2 s1 = newStack2()
		System.out.println("This is what the initialized empty stack looks like \n" + s1);
		System.out.println("Is this stack empty? \n" + s1.isEmpty());
		System.out.println("This stack has a size of " + s1.getLength());
		
		//Testing exception thrown if main attempts to pop off empty stack
		
		try {
			s1.pop();
		}
		
		catch (Exception e){
			System.out.println("What's poppin'? Nothing! You can't pop off an empty stack!");
			e.printStackTrace();
		}
		
		
		s1.push("bottom");
		System.out.println("This is what the stack looks like after pushing one element \n" + s1);
		
		s1.push("middle");
		System.out.println("This is what the stack looks like after pushing another element \n" + s1);
		
		s1.push("top");
		System.out.println("This is what the stack looks like after pushing a third element \n" + s1);
		
		System.out.println("Is this stack empty? \n" + s1.isEmpty());
		System.out.println("This stack has a size of " + s1.getLength());
		System.out.println("The top of this stack returns " + s1.top());
		
		s1.setTop("new top");
		System.out.println("This is what the stack looks like using setTop \n" + s1);
		System.out.println("Is this stack empty? \n" + s1.isEmpty());
		System.out.println("This stack has a size of " + s1.getLength());
		System.out.println("The top of this stack returns " + s1.top());
		
		s1.pop();
		System.out.println("This is what the stack looks like after invoking pop once \n" + s1);
		s1.pop();
		System.out.println("This is what the stack looks like after invoking pop again \n" + s1);
		s1.pop();
		System.out.println("This is what the stack looks like after invoking pop yet again \n" + s1);
		System.out.println("The program is about to try to invoke pop on an empty stack; you should expect an exceptional exception.");
		s1.pop(); //this should cause an exception
		
		
		
		
	}
	
	
}