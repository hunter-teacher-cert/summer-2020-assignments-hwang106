
import java.io.*;
import java.util.*;

class Life{
	
	public static char[][] createNewBoard(int rows, int cols){
		char[][] board = new char[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++){
				board[r][c] = '-';
			}
		}
		return board;
	}
	
	public static void printBoard(char[][] board){
		for (int r = 0; r < board.length; r++){
			for (int c = 0; c < board[r].length; c++){
				System.out.printf("%c", board[r][c]);
			}
			System.out.println();
		}
		System.out.println("\n\n----------------------------------------\n\n");
	}
	
	public static void setCell(char[][] board, int r, int c, char val){
		if (r>=0 && c >=0 && r<board.length && c<board[r].length) //to prevent out of bounds error
			board[r][c] = val;
	}
	
	/*
		Count and return the number of living neighbors around board[r][c]
		
		approach 1 - lots of if statments
		approach 2 - you can loop over the grid from board[r-1][c-1] to board [r+1][c+1]
	*/
	
	public static int countNeighbors(char[][] board, int r, int c){
		int neighbors = -1; //intializes neighbors to -1 (since traversing the array will count self, which should not be counted as a neighbor)
		for (int i = r-1; i <= r+1; i++){
			for(int j = c-1; j <= c+1; j++){
				if (i>=0 && j >=0 && i<board.length && j<board[r].length){
					if (board[i][j] == 'X'){
						neighbors++;
					}
				}
			}
		}
		return neighbors;
	}
	
	/*
		given a board and a cell, dtermine, based on the rules for Conways' GoL if the cell is alive ('X') or dead (' ') in the next generation.
	*/
	public static char genNextGenCell(char[][] board, int r, int c){
		//calculate the number of living neighbors around board [r][c]
		
		//determine if board[r][c] is living or dead
			//if living and 2, 3 neighbors, then remain alive
			//if dead and 3 neighbors, then become alive
			//if living not 2, 3 neighbors, dies
		
		return ' ';
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
	
	public static void main(String[] args){
		char[][] board = createNewBoard(25, 25);
		printBoard(board);
		setMiniBoard(board, 0, 0);
		printBoard(board);
		System.out.println(countNeighbors(board,0,0));
		
	}
	
}