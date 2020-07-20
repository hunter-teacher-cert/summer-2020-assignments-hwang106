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
	
	public int search(int searchValue){
		TreeNode currentNode = this.root;
		
		while(currentNode.getData() != searchValue && (currentNode.getLeft() != null || currentNode.getRight() != null)){
			if (searchValue > currentNode.getData() && currentNode.getRight() != null){
				currentNode = currentNode.getRight();
			}
			else if (currentNode.getLeft() != null){
				currentNode = currentNode.getLeft();
			}
			else{
				return -1;
			}
		}
		
		if (currentNode.getData() == searchValue){
			return searchValue;
		}
		
		else{
			//throw new NoSuchElementException();
			return -1;
		}
		
	}
	
	//insert
	
	//delete
	
	//traverse/print
	
	public static void main(String[] args){
		BSTree seeded = new BSTree();
		seeded.seed();
		System.out.println(seeded.search(150));
		System.out.println(seeded.search(15));
		System.out.println(seeded.search(22));
		System.out.println(seeded.search(10));
		System.out.println(seeded.search(5));
		System.out.println(seeded.search(8));
		System.out.println(seeded.search(1));
	}
	
	
}