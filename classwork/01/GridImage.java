import java.io.*;
import java.util.*;


public class GridImage{
	
	public static void main(String[] args){
		
		int testArray[][] = new int[20][20];
		printArray(testArray);
		rowPop(testArray, 3, 5);
		printArray(testArray);
		colPop(testArray, 2, 9);
		printArray(testArray);
		invert(testArray);
		printArray(testArray);
		diagonal(testArray, 5, 3, 0, 99);
		printArray(testArray);
		diagonal(testArray, 5, 3, 1, 88);
		printArray(testArray);
		diagonal(testArray, 5, 3, 2, 77);
		printArray(testArray);
		diagonal(testArray, 5, 3, 3, 66);
		printArray(testArray);
		
		
	}//end main
	
	public static void rowPop(int[][] d2, int r, int value){
		
		for(int c = 0; c < d2[r].length; c++){
			d2[r][c] = value;
		}
		
	}//end rowPop
	
	public static void colPop(int[][] d2, int c, int value){
		
		for(int r=0; r < d2.length; r++){
			d2[r][c] = value;
		}
		
	}//end colPop
	
	public static void invert(int[][] d2){
		
		for(int r=0; r < d2.length; r++){
			
			for(int c=0; c < d2[r].length; c++){
				
				if (d2[r][c]==0){
					d2[r][c]=255;
				}
				else{
					d2[r][c]=0;
				}
				
			}
		}
		
	}//end invert
	
	public static void diagonal(int[][] d2, int r, int c, int direction, int value){
		if (direction == 0){
			while (r >= 0 && c >= 0){
				d2[r][c] = value;
				r--;
				c--;
			}
		}
		
		else if (direction == 1){
			while (r >= 0 && c <= d2[r].length-1){
				d2[r][c] = value;
				r--;
				c++;
			}			
		}
		
		else if (direction == 2){
			while (r <= d2.length-1 && c >= 0){
				d2[r][c] = value;
				r++;
				c--;
			}			
		}
		
		else if (direction == 3){
			while (r <= d2.length-1 && c <= d2[r].length-1){
				d2[r][c] = value;
				r++;
				c++;
			}			
		}
		
		else {
			System.out.println("You need to choose 0 (up and to the left), 1 (up and to the right), 2 (down and to the left), or 3 (down and to the right).");
		}
		
	}//end diagonal
	
	public static void printArray(int[][] a) {
		
		
		for (int r = 0; r < a.length; r++){
					
			for (int c = 0; c < a[r].length; c++) { //use a[r], since Java can have "jagged" arrays, not rectangular
				System.out.printf("%03d ", a[r][c]);
			}//end for c
			
			System.out.println();
			
		}//end for r
		
		System.out.println();
		
	}//end printArray
	
	
}//end class