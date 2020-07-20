import java.util.*;
import java.io.*;

public class BSTree{
	private TreeNode root;
	
	public BSTree(){
		root = null;
	}
	
	public void seed(){
		TreeNode t;
		
		t = new TreeNode(10);
		this.root = t;
		t = new TreeNode(5);
		root.setLeft(t);
		t = new TreeNode(20);
		root.setRight(t);
		
		root.getLeft().setRight(new TreeNode(8));
		
		t = new TreeNode(15);
		root.getRight().setLeft(t);
		
		t = new TreeNode(22);
		root.getRight().setRight(t);
	}
	
	//legacy version of search, before I realized that you could get a null TreeNode without an exception
/* 	public int search(int searchValue){
		TreeNode currentNode = this.root;
		
		//alternatively could get rid of first while condition and add it is as a conditional return inside the while loop instead
		while(currentNode.getData() != searchValue && (currentNode.getLeft() != null || currentNode.getRight() != null)){
			if (searchValue > currentNode.getData() && currentNode.getRight() != null){
				currentNode = currentNode.getRight();
			}
			else if (currentNode.getLeft() != null){
				currentNode = currentNode.getLeft();
			}
			else{
				throw new NullPointerException();
				//return -1; 
			}
		}
		
		//couldn't think of a way to break out of the tree structure without needing to check the deepest level of the tree for the value
		if (currentNode.getData() == searchValue){
			return searchValue;
		}
		
		else{
			throw new NullPointerException();
			//return -1;
		}
		
	} */
	
	public int search(int searchValue){
		TreeNode currentNode = this.root;
		
		while (currentNode != null){
			int currentValue = currentNode.getData();
			if (currentValue == searchValue){
				return currentValue;
			}
			else if (searchValue > currentValue){
				currentNode = currentNode.getRight();
			}
			else{
				currentNode = currentNode.getLeft();
			}
		}
		
		throw new NullPointerException();
	}
	
	//insert
	
	//delete
	
	//traverse/print
	//
	public static void main(String[] args){
		BSTree seeded = new BSTree();
		seeded.seed();
		try {System.out.println(seeded.search(150));}
		catch (NullPointerException e){System.out.println("no such element");}
		System.out.println(seeded.search(15));
		System.out.println(seeded.search(20));
		System.out.println(seeded.search(22));
		System.out.println(seeded.search(10));
		System.out.println(seeded.search(5));
		System.out.println(seeded.search(8));
		try {System.out.println(seeded.search(1));}
		catch (NullPointerException e){System.out.println("no such element");}
	}//*/
	
	
}