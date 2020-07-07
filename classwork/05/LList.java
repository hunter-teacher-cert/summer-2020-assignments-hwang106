
import java.io.*;
import java.util.*;

public class LList {
	
	private Node head;
	
	public LList() {
		head = null;
	}
	
	
	public void addFront(String data){
	Node newNode = new Node(data);

	// first point the new node to the beginning
	newNode.setNext(head);

	// point head to the new node
	head = newNode;

    }
	
	public boolean isEmpty(){
		return this.head == null;
	}
	
	public String get(int index){ //indexed at 0 like arrays
		
		if (index >= 0) { //conditional to check for out of bounds index (less than min)
		
			Node tmp = this.head;
			
			for (int i = 0; i < index; i++) {
				if (tmp != null){ //conditional to check for out of bounds index (greater than max)
					tmp = tmp.getNext();
				}
				/* else { //if the index is out of bounds, exits for loop early
					return null;
				} */
			} 
			
			if (tmp != null) { //prevents NullPointerException if 
				return tmp.getData();
			}
			
			else {
				return null;
			}
		}
		
		return null;
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
	
	public static void main(String[] args){
		LList l = new LList();
		
		System.out.println(l.head);
		l.addFront("Curly");
		System.out.println(l.head);
		System.out.println(l.head.getNext());
		l.addFront("Larry");
		System.out.println(l.head);
		System.out.println(l.head.getNext());
		l.addFront("Huan");
		System.out.println(l.head);
		System.out.println(l.head.getNext());
		
		System.out.println(l);
		
		System.out.println(l.get(0));
		System.out.println(l.get(1));
		System.out.println(l.get(2));
		System.out.println(l.get(3));
		System.out.println(l.get(-1));
		System.out.println(l.get(1000000000));
	}
	

	
	
}