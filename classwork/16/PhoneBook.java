import java.io.*;
import java.util.*;

public class PhoneBook{
	
	//initialize an array of objects to store Person data; objects can potentially be linked lists; have not picked an implementation yet
	private Object[] alphaList = new Object[26]; //categorize linked lists by first letter of last name; can lead to extremely skewed Object sizes due to last name distribution by first letter 
	private Object[] hashArray = new Object[1000] //arbitrary size where hashed values of Person data is stored?
	
	//add method
	public void add(Person entry){
		//store Person in a new Node for eventual placement in a linked list
		//use a hash function based on entry.getLN() to convert to an index
		//use linked list's add method to add it to the linnked list object at that array index
		
		
	}
	
	//find method
	public Person find(String ln){
		/
		//convert inputted ln to hash index using hash function
		//gain entry into linked list from that array index
		//traverse linked list and use the get method until ln matches the node containing the Person object (likely will need to use this.getLN)
		//if matches return that Person object in that node
		//to deal with multiple objects with the same last name, it might be necessary to write a recursive method that returns all the Person objects?
		//if traversal reaches null, throw exception or return null
		
	}
	
	//remove method
	public void remove(String ln){
		//convert inputted ln to hash index using hash function
		//gain entry into linked list from that array index
		//traverse linked list until match to ln found
		//use remove method for linked lists
		//if traversal reaches null, throw exception or return
	}
	
	//printList method
	public void printList(){
		//traverse array
		//for each index that does not have a null linked list (front), traverse the linked list and System.out.println each Person object (toString method already written in that class)
		//run until end of array has been reached
	}
	
	
	
}


/* 

Additional Questions:

1) What is the runtime for add? 
2) What is the runtime for find?
3) What is the runtime for remove?
4) What is the runtime for printList?

Brainstorming Area:
-Premise of phone book, is that dataset can get quite large, so order of how algorithm scales will be important
-Some data structures we've dealt with to consider: array, arraylist, linked list, stacks, binary tree, heap, hash table
- 


*/