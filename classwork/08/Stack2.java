import java.io.*;
import java.util.*;

public class Stack2{
	
	//private int length; commenting out to use the default size method instead
	private LinkedList<String> stackList; //wondering about declaring the List interface instead of a specific implementation in case it needs to switch from LinkedList to ArrayList or something else. 
		
	public Stack2(){
		//length = 0; 
		stackList = new LinkedList<String>();
	}
	
	public void push(String data){
		this.stackList.add(data);
		
	}
	
	public void setTop(String data){
		this.stackList.set(this.stackList.size()-1, data);
	}
	
	public String pop(){
		String value = this.stackList.get(this.stackList.size()-1);
		this.stackList.remove(this.stackList.size()-1);
		return value;
	}
	
	public String toString(){
		String s = "--/\\--" + "\n";
		
		for (int i = this.stackList.size(); i > 0; i--){
			s += this.stackList.get(i-1);
			s += "\n";
		}
		
		s += "--\\/--" + "\n";
		
		return s;
	}
	
	public String top(){
		return this.stackList.get(this.stackList.size()-1);
	}
	
	public boolean isEmpty(){
		return this.stackList.size() == 0;
	}
	
	public int getLength(){
		return this.stackList.size();
	}
	
	
	public static void main(String[] args){
		Stack2 s1 = new Stack2();
		s1.push("bottom");
		s1.push("middle");
		s1.push("top");
		
		System.out.println(s1);
		
		s1.setTop("new top");
		System.out.println(s1);
		
		System.out.println(s1.pop());
		System.out.println(s1.top());
		System.out.println(s1);
		s1.pop();
		System.out.println(s1);
		
		s1.pop();
		System.out.println(s1);
		

	}
	
}