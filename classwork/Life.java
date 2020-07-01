
import java.io.*;
import java.util.*;


class Life{
	//Creates board of arbitrary size, filled with - by default, to represent lack of life. 
	public static char[][] createNewBoard(int rows, int cols){
		char[][] board = new char[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++){
				board[r][c] = '-';
			}
		}
		return board;
	}
	
	//Prints char arrays
	public static void printBoard(char[][] board){
		for (int r = 0; r < board.length; r++){
			for (int c = 0; c < board[r].length; c++){
				System.out.printf("%c", board[r][c]);
			}
			System.out.println();
		}
		System.out.println("\n\n----------------------------------------------------------------------------------------------\n\n");
	}
	
	//Sets individual cells to specified value
	public static void setCell(char[][] board, int r, int c, char val){
		if (r>=0 && c >=0 && r<board.length && c<board[r].length) //to prevent out of bounds error
			board[r][c] = val;
	}
	
	//counts adjacent (including diagonally adjacent) cells if a living neighbor is present; "universe is flat" -Tsee
	public static int countNeighbors(char[][] board, int r, int c){
		int neighbors;
		if (board[r][c] == 'X'){
			neighbors = -1; //intializes neighbors to -1 if starting cell is alive (since traversing the array will count self, which should not be counted as a neighbor)
		}
		else {
			neighbors = 0; //initializes neighbors to 0 if cell in question is initially dead
		}
		for (int i = r-1; i <= r + 1; i++){
			if (i >= 0 && i < board.length){
				for(int j = c-1; j <= c + 1; j++){
					if (j >= 0 && j < board[r].length){
						if (board[i][j] == 'X'){
							neighbors++;
						}
					}
				}
			}
		}
		return neighbors;
	}
	
	/*
		given a board and a cell, determine, based on the rules for Conways' GoL if the cell is alive ('X') or dead (' ') in the next generation.
	*/
	public static char genNextCell(char[][] board, int r, int c){
		
		int numNeighbors = countNeighbors(board, r, c);
		
		if (board[r][c] == 'X' && (numNeighbors == 2 || numNeighbors == 3)){
			return 'X';
		}
		else if (board[r][c] == '-' && numNeighbors == 3){
			return 'X';
		}
		else {
			return '-';
		}
			
		
		//Conways' rules:
			//if living and 2, 3 neighbors, then remain alive
			//if dead and 3 neighbors, then become alive
			//if living not 2, 3 neighbors, dies
		
	}
	
	//for testing purposes; creates randomly populated 3x3 mini-board
	public static void setMiniBoard(char[][] board, int r, int c){
		setCell(board, r, c, 'X'); // intializes the middle of the mini-board as living
		Random random = new Random();
		for (int i = r-1; i <= r+1; i++){
			for(int j = c-1; j <= c+1; j++){
				int chanceOfLife = random.nextInt(100); //generates random number to determine if living or not
				if (chanceOfLife < 25){ //if less than arbitrary chance of life (here 25), then set as living.
					setCell(board,i,j,'X');
				}
			}		
		}
			
	}
	
	//generates randomly populated board; default probability of a cell containing life is hard-coded at 25%; can be set as parameter if important
	public static void setBoard(char[][] board){
		Random random = new Random();
		for (int i = 0; i <= board.length; i++){
			for(int j = 0; j <= board[0].length; j++){
				int chanceOfLife = random.nextInt(100); //generates random number to determine if living or not
				if (chanceOfLife < 25){ //if less than arbitrary chance of life (here 25), then set as living.
					setCell(board,i,j,'X');
				}
			}		
		}
	}
	
	//creates the next generation's board based on Conway's rules in genNextCell method. 
	public static char[][] nextBoard(char[][] board){
		char[][] genNext = createNewBoard(board.length, board[0].length);
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++){
				genNext[r][c] = genNextCell(board, r, c);
			}
		}
		
		return genNext;
		
	}
	
	/**
		*creates multiple boards based on the number of generations desired 
		*@param board starting Game of Life board, pre-poulated by setBoard method
		*@param x number of generations desired
	*/
	public static void generationsOfLife(char[][] board, int x){
		System.out.print("\033[H\033[2J");
		for (int i = 0; i < x; i++){
			board = nextBoard(board);
			//System.out.print("[0;0H\n"); 
			System.out.print("\033[H\033[2J");
			printBoard(board);
			delay(1000);
		}
	}
	
	/*public static void drawBoard(char[][] board) {
		int[][] intboard = new int[board.length][board[0].length];
		for (int r = 0; r < intboard.length; r++) {
			for (int c = 0; c < intboard[0].length; c++) {
				if (board[r][c] == 'X')
					intboard[r][c] = 255;
				else
					intboard[r][c] = 2;
			}
		}
		ImageTest.drawImage(intboard);
		//System.out.println(Arrays.deepToString(intboard));
	}*/
	
	 //helper method to slow down animation 
	  public static void delay(int n)
	  {
		try {
			Thread.sleep(n);
		} 
		catch(InterruptedException e) {}
	  }
			
	public static void main(String[] args){
		char[][] board = createNewBoard(25, 50);
		//printBoard(board);
		//setMiniBoard(board, 5, 5);
		//printBoard(board);
		//System.out.println(countNeighbors(board,5,5));
		setBoard(board);
		//printBoard(board);
		//drawBoard(board);
		generationsOfLife(board, 10);
		//int[][] intBoard = {{255, 0, 255, 0, 255}, {255, 0, 255, 0, 255}, {255, 0, 255, 0, 255}, {255, 0, 255, 0, 255}, {255, 0, 255, 0, 255},};
		//ImageTest.drawImage(intBoard);
		
	}
	
}