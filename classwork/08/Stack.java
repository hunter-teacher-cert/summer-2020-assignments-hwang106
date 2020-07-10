import java.util.*;
import java.io.*;

// 

class Stack {
	
	private int length;
	private LList stackList;
	
	public Stack(){
		stackList = new LList();
		length = 0;
	}
	
	public void push(String data){
		this.stackList.addFront(data);
		this.length++;
	}
	
	public Node pop(){
		Node top = this.stackList.getHead(); //added a getter method for head in LList class
		
		if (this.length == 0){
			throw new NoSuchElementException("What's poppin'; there are no stacks to pop off");
		} 
		
		this.stackList.removeFront();
		this.length--;
		return top;
	}
	
	public Node top(){
		return this.stackList.getHead();
	}
	
	public String toString(){
		String s = "";
		
		for (int i = 0; i < this.length; i++){
			s += this.stackList.get(i);
			s += "\n";
		}
		
		return s;
	}
		
	public static void main(String[] args){
		Stack test = new Stack();
		test.push("bottom");
		test.push("middle");
		test.push("top");
		System.out.println(test);
		
		System.out.println(test.pop());
		System.out.println(test);
		System.out.println(test.top());
		test.pop();
		System.out.println(test);
		test.pop();
		System.out.println(test);
		test.pop();
		System.out.println(test);
	} 
	
}

