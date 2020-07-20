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
	
	//insert always inserts as a new leaf while following rules of a binary tree (i.e. right child always larger than parent; left child always smaller than parent)
	public void insert(int value){
		TreeNode frontNode = this.root;
		int frontValue = 0; //not sure why, but javac says I need to initialize frontValue here, perhaps just in case, we never enter the while loop?
		
		if (frontNode == null){
			frontNode.setData(value);
			return;
		}
		
		TreeNode newNode = new TreeNode(value);
		
		while (frontNode.getLeft() != null || frontNode.getRight() != null){
			frontValue = frontNode.getData();
			
			if (frontValue == value){
				return;
			}
			else if (value > frontValue){
				if (frontNode.getRight() == null){
					frontNode.setRight(newNode);
					return;
				}
				frontNode = frontNode.getRight();
			}
			else{
				if (frontNode.getLeft() == null){
					frontNode.setLeft(newNode);
					return;
				}
				frontNode = frontNode.getLeft();
			}
		}
		
		if (value > frontValue){
			frontNode.setRight(newNode);
			return;
		}
		
		if (value < frontValue){
			frontNode.setLeft(newNode);
			return;
		}
		
		
	}
	
	//delete
	
	//traverse/print
	
/*  	public String toString(){
		return this.toString(this.root);
	}
	
	public String toString(TreeNode node){
		String s = "";
		
		if (node == null){
			s = "null";
		}
		
		else{
			s += node.getData();
			if (root.getLeft() != null || root.getRight() != null){
				s = "(" + s + ", " + this.toString(this.root.getLeft());
				s = s + ", " + this.toString(this.root.getRight()) + ")";
			}
				
		}
		
		return s;
		
	}  */
	
	public String searchPosition(int searchValue){
		int level = 0;
		String position = "root";
		
		TreeNode currentNode = this.root;
		
		while (currentNode != null){
			int currentValue = currentNode.getData();
			if (currentValue == searchValue){
				return position + " " + level;
			}
			else if (searchValue > currentValue){
				currentNode = currentNode.getRight();
				level++;
				position += " right";
			}
			else{
				currentNode = currentNode.getLeft();
				level++;
				position += " left";
			}
		}
		
		return "node not found";
		
		
	}
	
	
	
	
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
		System.out.println(seeded.searchPosition(10));
		System.out.println(seeded.searchPosition(5));
		System.out.println(seeded.searchPosition(20));
		//System.out.println(seeded.searchPosition(3));
		System.out.println(seeded.searchPosition(8));
		System.out.println(seeded.searchPosition(15));
		System.out.println(seeded.searchPosition(22));
		seeded.insert(3);
		seeded.insert(4);
		seeded.insert(23);
		seeded.insert(12);
		seeded.insert(18);
		//seeded.insert(3);
		
		System.out.println(seeded.searchPosition(3));
		System.out.println(seeded.searchPosition(4));
		System.out.println(seeded.searchPosition(23));
		System.out.println(seeded.searchPosition(12));
		System.out.println(seeded.searchPosition(18));
		
		
	}//*/
	
	
}