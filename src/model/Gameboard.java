package model;
import java.util.*;
/*
 * This is the model class that represents the gameboard.
 * 
 *  |A B C D E F G H I J
 * ---------------------
 * 0|
 * 1|
 * 2|
 * 3|
 * 4|
 * 5|
 * 6|
 * 7|
 * 8|
 * 9|
 * 
 */

/*
 * Number of boats and sizes:
 * Size:5	NO:1
 * Size:4	NO:2
 * Size:3	NO:3
 * Size:2	NO:4
 *  
 */

public class Gameboard {
	int [][] board = new int [10][10];


	public Gameboard() {
		//board = new int [10][10];
		insertBoat(5,true);
		insertBoat(4,true);
		insertBoat(4,false);
		insertBoat(3,true);
		insertBoat(3,false);
		insertBoat(3,true);
		insertBoat(2,true);
		insertBoat(2,true);
		insertBoat(2,false);
		insertBoat(2,false);
	}


	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}
	/*
	 * Main method to insert boats. Only called in constructor to set up the board randomly.
	 */
	public void insertBoat(int size, boolean horisontal) {
		Random rnd = new Random();
		//System.out.println("Trying to insert a boat with size: "+size+" Horisontally? : "+horisontal);
		int locationX = rnd.nextInt(10);
		int locationY = rnd.nextInt(10);
		if (locationX + size >10) {
			locationX = 10-size;
		}
		if (locationY + size > 10) {
			locationY = 10-size;
		}
		boolean available = true;


		if (horisontal) {
			for(int i = 0; i < size; i++) {
				if (this.board[locationX+i][locationY] != 0) {
					available = false;
				}
			}
			if (available) {
				for(int i = 0; i < size; i++) {
					this.board[locationX+i][locationY] = 3;
				}
				//System.out.println("added a boat vertically with size : "+size+" Horisontally starting on  X: "+locationX+ " Y: "+locationY);
			}
			else {
				insertBoat(size, false);
			}
		} else if (!horisontal) {
			for (int i = 0; i < size; i++ ) {
				if (this.board[locationX][locationY+i] != 0) {
					available = false;
				}
			}
			if (available) {
				for(int i = 0; i < size; i++) {
					this.board[locationX][locationY+i] = 3;
				}
				//System.out.println("added a boat vertically with size : "+size+" Vertically starting on  X: "+locationX+ " Y: "+locationY);
			}else {
				insertBoat(size, true);
			}
		}
		//TODO: Fixa logiken	

	}
	/*
	 * Main method for shooting. Returns the value of the square to evaluate what kind of shot it was.
	 *
	 */
	public int shoot(int x, int y) {
		int response = board[y][x];
		if (board[y][x] == 3) { // HIT
			board[y][x] = 2;
		}
		else if (board[y][x] == 2) { // shot an already tested spot.
			board[y][x] = 2;
		}
		else if (board[y][x] == 0) { // Miss
			board[y][x] = 1;
		} else if (board[y][x] == 1) { // Shot an already tested spot.
			board[y][x] = 1;
		}
		return response;
	}
	public boolean isGameOver() {
		boolean response = true;
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j<10; j++ ) {
				if(board[i][j] == 3) {
					response = false;
					break;
				}
			}
		}
		
		return response;
	}
	public void printTest() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				sb.append(" "+board[i][j]);
			}
			System.out.println(sb.toString());
			sb.delete(0, sb.length());
		}
	}

}
