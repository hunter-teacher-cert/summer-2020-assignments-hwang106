
import java.io.*;
import java.util.*;

public class LList {
	
	private Node head;
	
	public LList() {
		head = null;
	}
	
	public Node getHead() {
		return this.head;
	}
	
	
	public void addFront(String data){
	
	if (data == null) {
		throw new IllegalArgumentException();
	}//doesn't allow user to put in null for the data of the new Node being added
	
	Node newNode = new Node(data);

	// first point the new node to the beginning
	newNode.setNext(head);

	// point head to the new node
	head = newNode;

    }
	
	public boolean isEmpty(){
		return this.head == null;
	}
	
	public int length(){
		
		int length = 0;
		Node tmp = this.head;
		
		while (tmp != null) {
			tmp = tmp.getNext();
			length++;
		}
		
		return length;
		
	}
	
	public String get(int index){ //indexed at 0 like arrays
		
		if (index >= 0 && index < this.length()) { //conditional to check for out of bounds index
		
			Node tmp = this.head;
			
			for (int i = 0; i < index; i++) {
				tmp = tmp.getNext();		
			} 		
			return tmp.getData();	
		}
		
		throw new IndexOutOfBoundsException(); //exception if index is out of bounds
	}
	
	
	public void set(int index, String value){
		
		if (value == null) {
			throw new IllegalArgumentException();
		}

		if (index >=0 && index < this.length()) { //conditional to check for out of bounds index; does nothing if out of bounds
		
			Node tmp = this.head;
		
		
			for (int i = 0; i < index; i++){				
				tmp = tmp.getNext();
			}
			
			tmp.setData(value);

			return;

		}
		
		throw new IndexOutOfBoundsException(); //exception if index is out of bounds
		
	}
	
	public void insert(int index, String value){
		
		if (value == null) {
			throw new IllegalArgumentException();
		}
		
		if (index > 0 && index <= this.length()) { //for situations where user is not adding to the front
			//need to find what is currently at that index and before it
			Node tmpPre = this.head;
			Node tmpPost = null;
			
			for (int i = 0; i < index - 1; i++){
				tmpPre = tmpPre.getNext();			
			}
			
			//sets node that was originally at the index 
			tmpPost = tmpPre.getNext();
			
			//create newNode with parameter value, pointing at what was previously at that index
			Node newNode = new Node(value, tmpPost); 
			
			//need to have what was before that index point at newNode		
			tmpPre.setNext(newNode);
			
			return;

		}
		
		else if (index == 0) { //for situations where user is adding to the front (the reason this is needed because index-1 for 0 is -1 and would exit for loop and do the same thing as index = 1)
			addFront(value);
			return;
		}
		
		throw new IndexOutOfBoundsException(); //exception if index is out of bounds
		
	}
	
	public int search(String key) {
		
		if (key == null) {
			throw new IllegalArgumentException();
		}
		
		Node tmp = this.head;
		int index = 0;
		
		while (tmp != null && !tmp.getData().equals(key)) {
			tmp = tmp.getNext();
			index++;
		}
		
		if (tmp != null) { //returns index if the whole list wasn't traversed without a match
			return index;
		}
		
		else {
			throw new NoSuchElementException(); //exception representing no match found (would be useful if the main function depends on this value to continue)
		}
	}
	
	public String toString(){
		String s = "";
		
		Node tmp;
		
		tmp = this.head;
		
		
		while (tmp != null) {
			s += tmp.getData() + "-->";
			tmp = tmp.getNext();
		}
		
		s = s + "null";
		
		return s;
		
	}
	
	public void removeFront() {
		if (this.head == null){
			throw new NoSuchElementException("Empty Linked List"); //exception to prevent removing the initial null head node from a LList object
		}
		
		this.head = this.head.getNext();
	}
	
	public void remove(int index) {
		//simpler but less clean approach is to locate node right before index and change its next reference to the node right after index
		
		//more comprehensive approach is to do the above and change the reference of the index node to null (is this necessary though, or will garbage collection eliminate an unnamed node with nothing else referring to it, even when it is referring to something else?)
		
		if (index > 0 && index < this.length()) {//prevents out of bounds index
		
			Node tmp = this.head;
			
			for (int i = 0; i < index - 1; i++){
				tmp = tmp.getNext();
			}
			
			if (tmp.getNext() != null) { //if not at boundary condition
				tmp.setNext(tmp.getNext().getNext()); 
				return;
			}
			
			else if (tmp.getNext() == null) { //if at boundary condition; can just be else; else if was a legacy of previous implementation
				tmp.setNext(null);
				return;
			}
		
		}
		
		else if (index == 0) {
			this.removeFront();
			return;
		}

		throw new IndexOutOfBoundsException();
	}
	
	public static void main(String[] args){
		LList l = new LList();
		try {
		l.addFront("Curly");
		l.addFront("Larry");
		l.addFront("Huan");
		l.addFront(null);
		}
		
		catch(Exception e){
			System.out.println("Yuck");
			e.printStackTrace();
			
		}
		
		finally {
		System.out.println(l);
		
	
 		System.out.println(l.get(0));
		System.out.println(l.get(1));
		System.out.println(l.get(2));
		l.insert(3, "ming");
		System.out.println(l);
		l.remove(0);
		l.remove(0);
		l.remove(0);
		//l.remove(3);
		System.out.println(l);
		}
		/* System.out.println(l.get(3));
		System.out.println(l.get(-1));
		System.out.println(l.get(4)); 
		
		l.insert(3, "Ming");
		
		System.out.println(l);
		
		
		

		System.out.println(l.search("Ming"));
		System.out.println(l.search(new String("Ming")));
		System.out.println(l.length());
		l.remove(2);
		System.out.println(l);
		System.out.println(l.length());  */
	}
	

	
	
}