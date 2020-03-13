package view;
import java.util.*;

/*
 * * |A B C D E F G H I J
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
public class view {
StringBuilder sb = new StringBuilder();


/*
 * Standard metod for printing out the gameboard.
 * 0 is the standard print
 * 1 is a miss
 * 2 is the hit
 * 3 is a boat that is hidden.
 */

	public void PrintGameBoard(int [][] arr) {
		sb.append(" | A B C D E F G H I J");
		System.out.println(sb.toString());
		sb.delete(0, sb.length());
		for (int i = 0; i <arr.length; i++ ) {
			
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 0 || arr[i][j] == 3) {
					sb.append("* ");
				}
				else if(arr[i][j] == 1) {
					sb.append("O ");
				}
				else if (arr[i][j] == 2) {
					sb.append("X ");
				}
			}
			System.out.println(i+"| "+sb.toString());
			sb.delete(0, sb.length());
		}
	}
	public void PrintWelcomeMenu() {
		System.out.println("Welcome to Battleships!\n"
				+ "Press 1 to play \n"
				+ "Press 2 to play versus computer \n"
				+ "Press 0 to quit \n");
				
	}
	public void AskForPlayerName(int i) {
		System.out.println("What is the name for player"+i);
	}
	public void printTestBoard(int [][] arr) {
		sb.append(" | A B C D E F G H I J");
		System.out.println(sb.toString());
		sb.delete(0, sb.length());
		for (int i = 0; i <arr.length; i++ ) {
			
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 0) {
					sb.append("* ");
				}
				else if(arr[i][j] == 1) {
					sb.append("O ");
				}
				else if (arr[i][j] == 2) {
					sb.append("X ");
				}
				else if (arr[i][j] == 3) {
					sb.append("# ");
				}
			}
			System.out.println(i+"| "+sb.toString());
			sb.delete(0, sb.length());
		}
	}
	public void printBoardInNumbers(int [][] arr) {
		sb.append(" | A B C D E F G H I J");
		System.out.println(sb.toString());
		sb.delete(0, sb.length());
		for (int i = 0; i <arr.length; i++ ) {
			
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 0) {
					sb.append("0 ");
				}
				else if(arr[i][j] == 1) {
					sb.append("1 ");
				}
				else if (arr[i][j] == 2) {
					sb.append("2 ");
				}
				else if (arr[i][j] == 3) {
					sb.append("3 ");
				}
			}
			System.out.println(i+"| "+sb.toString());
			sb.delete(0, sb.length());
		}
	}
	public void printPlayerTurn(String name) {
		System.out.println("It's "+name+"'s turn. Where do you wish to fire?");
	}
	public void printErrorShooting() {
		System.out.println("You have already fired there or invalid square, please try another one.");
	}
	public void printMiss() {
		System.out.println("Miss.");
		System.out.println("\n");
		
	}
	public void printHit() {
		System.out.println("A Successful hit!");
		System.out.println("\n");
		
	}
	public void printWinner(String winnerName) {
		System.out.println(winnerName+" Has won the game! Congratulations. Do you wish to play again? (Y/N)");
		
	}
	public void printErrorInput() {
		System.out.println("Error with entered input. The input should be in 2 characters. Top row first, number after.\n"
				+ "For example, a7 or b4 .");
		
	}
		
}
	

