import java.util.*;
import java.io.*;

// 

class Stack {
	
	private int length;
	private LList stackList;
	
	//stack constructor that hijacks LList's constructor
	public Stack(){
		stackList = new LList();
		length = 0;
	}
	
	//takes String parameter and uses LList's addFront method to place a node with the given parameter to the "top" of the stack
	public void push(String data){
		this.stackList.addFront(data);
		this.length++;
	}
	
	//returns value of the topmost stack, while removing it from the LList stackList structure.
	public Node pop(){
		Node top = this.stackList.getHead(); //added a getter method for head in LList class, also realized this wouldn't be necessary if this method returned a string (could just use the existing get method)
		
		if (this.length == 0){
			throw new NoSuchElementException("What's poppin'? There are no stacks to pop off");
		} 
		
		this.stackList.removeFront();
		this.length--;
		return top;
	}
	
	//in essence a getter for the top of the stackList
	public Node top(){
		return this.stackList.getHead();
	}
	
	//this method replaces the top stack with something else without returning any values
	public void setTop(String data){
		this.stackList.set(0, data);
	}
	
	public String toString(){
		String s = "--/\\--" + "\n"; //Probably not the most space efficient way to display data, but the vertical String structure corresponds to our analogy for the stack structure.
		
		for (int i = 0; i < this.length; i++){
			s += this.stackList.get(i);
			s += "\n";
		}
		
		s += "--\\/--" + "\n";
		
		return s;
	}
	
	//checks if stack is empty
	public boolean isEmpty(){
		return this.stackList.isEmpty();
	}
	
	public int getLength(){
		return this.length;
	}
	

	//with these assignments, it's been more efficient to test from the main within the class, but I will stop being lazy and make a driver soon
	public static void main(String[] args){
		Stack test = new Stack();
		test.push("bottom");
		test.push("middle");
		test.push("top");
		test.setTop("new top");
		System.out.println(test);
		System.out.println(test.isEmpty());
		
		System.out.println(test.pop());
		System.out.println(test);
		System.out.println(test.top());
		test.pop();
		System.out.println(test);
		System.out.println(test.isEmpty());
		test.pop();
		System.out.println(test);
		System.out.println(test.isEmpty());

	} 
	
}

