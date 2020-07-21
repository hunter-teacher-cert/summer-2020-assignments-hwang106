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

		
		TreeNode newNode = new TreeNode(value);
		
		if (this.root == null){
			this.root = newNode;
			return;
		}
		
		TreeNode frontNode = this.root;
		int frontValue;
		
		
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
		
		frontValue = frontNode.getData();
		
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
	public void delete(int key){
		
		/*
		algorithm 1
		-search for TreeNode matching key
		-"re-branch" tree such that the child with the fewest branches replaces the deleted TreeNode
		-connect lagging TreeNode to child with fewest branches
		-if right branch, traverse left from that branch until null
		-connect lagging TreeNode to the former left branch of the deleted TreeNode
		-vice versa; or for simplicity, just always choose one side
		*/
		
		if (this.root == null){
			return;
			//potentially throw exception instead
		}
		
		TreeNode current = this.root;
		TreeNode lagging = current;
		boolean isLeftChild = true;
		
		while (current != null){
			int currentValue = current.getData();
			
			if (currentValue == key){
				//special case if the node to be deleted is a terminal node
				if (current.getLeft() == null && current.getRight() == null){
					if (isLeftChild){
						lagging.setLeft(null);
						return;
					} else{
						lagging.setRight(null);
						return;
					}
				}
				//more common case, where lagging node is rewired to connect to the left child of the current node by default, and rightmost branch of this connection before null is rewired to the "root" of the right branch of the former current node (programatically the latter rewiring happens first, so access isn't lost)
				TreeNode current2 = current.getLeft();
				TreeNode lagging2 = current2;
				while (current2 != null){
					lagging2 = current2;
					current2 = current2.getRight();
				}
				
				lagging2.setRight(current.getRight());
				
				if (isLeftChild){
					lagging.setLeft(current.getLeft());
					return;
				} else{
					lagging.setRight(current.getLeft());
					return;
				}
			}
			
			if (key > currentValue){
				lagging = current;
				current = current.getRight();
				isLeftChild = false;
			} else{
				lagging = current;
				current = current.getLeft();
				isLeftChild = true;
			}
		}
		
		return;
		//consider throwing NoSuchElementException instead
		

		
		/*
		algorithm 2
		-search for TreeNode matching key
		-create new TreeNode that points to TreeNode matching key
		-remove connection from lagging TreeNode (parent) to TreeNode with matching key
		-recursively traverse the new TreeNode, getting the values of each branch, and adding it to original BSTree, invoking the already-made insert method (possibly store values in an array, though seems overly complicated)
		*/
		
		
		
	}
	
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
		//seeded.seed();
		/* try {System.out.println(seeded.search(150));}
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
		System.out.println(seeded.searchPosition(22)); */
		seeded.insert(3);
		seeded.insert(4);
		seeded.insert(23);
		seeded.insert(12);
		seeded.insert(18);
		seeded.insert(13);
		seeded.insert(2);
		seeded.insert(1);
		seeded.insert(20);
		//seeded.insert(3);
		
		System.out.println(seeded.searchPosition(3));
		System.out.println(seeded.searchPosition(4));
		System.out.println(seeded.searchPosition(23));
		System.out.println(seeded.searchPosition(12));
		System.out.println(seeded.searchPosition(18));
		System.out.println(seeded.searchPosition(13));
		System.out.println(seeded.searchPosition(2));
		System.out.println(seeded.searchPosition(1));
		System.out.println(seeded.searchPosition(20));
		
		seeded.delete(23);
		System.out.println(seeded.searchPosition(3));
		System.out.println(seeded.searchPosition(4));
		System.out.println(seeded.searchPosition(23));
		System.out.println(seeded.searchPosition(12));
		System.out.println(seeded.searchPosition(18));
		System.out.println(seeded.searchPosition(13));
		System.out.println(seeded.searchPosition(2));
		System.out.println(seeded.searchPosition(1));
		System.out.println(seeded.searchPosition(20));
		
		
	}//*/
	
	
}