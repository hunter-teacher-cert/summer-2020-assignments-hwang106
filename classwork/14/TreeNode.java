import java.io.*;
import java.util.*;

public class TreeNode{
	private int data;
	private TreeNode leftChild;
	private TreeNode rightChild;
	
	//constructors
	public TreeNode(){
		//data = 0; rewritten with second constructor
		this(0);
	}
	
	public TreeNode(int data){
		this.data = data;
		leftChild = null;
		rightChild = null;
	}
	
	//getters
	public int getData(){
		return this.data;
	}
	
	public TreeNode getLeft(){
		return this.leftChild;
	}
	
	public TreeNode getRight(){
		return this.rightChild;
	}
	
	//setters
	public void setData(int data){
		this.data = data;
	}
	
	public void setLeft(TreeNode left){
		this.leftChild = left;
	}
	
	public void setRight(TreeNode right){
		this.rightChild = right;
	}
	
	public String toString(){
		String s = "";
		return s += this.data;
	}
	
}