package controller;
import view.view;
import model.HighScore;
import model.Gameboard;
import model.Player;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;


public class BattleshipsController {
	public void run() throws IOException {
		HighScore hs = new HighScore();
		// TODO Auto-generated method stub
		view view = new view();
		view.PrintWelcomeMenu();
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		if (choice == 1) {
			sc.nextLine(); // Resolve state issue with Scanner.
			view.AskForPlayerName(1);
			String name = sc.nextLine();
			Player player1 = new Player(name, false);
			view.AskForPlayerName(2);
			name = sc.nextLine();
			Player player2 = new Player(name, false);
			startGame(player1, player2, view,hs);
			//view.PrintGameBoard(player1.getGb().getBoard());
			//view.printTestBoard(player1.getGb().getBoard());
			//view.printBoardInNumbers(player1.getGb().getBoard());
			//player1.getGb().printTest();
			
		}
		else if (choice == 2) {
			sc.nextLine(); // Resolve state issue with Scanner.
			view.AskForPlayerName(1);
			String name = sc.nextLine();
			Player player1 = new Player(name, false);
			Player player2 = new Player("Computer", true);
			startGame(player1,player2,view, hs);
			
		}else if (choice == 3) {
			view.printHighScores(hs.getHighScores());
			run();
		}
		else if (choice == 0) {
			System.exit(0);
		}
	}
	
	public void startGame(Player player1, Player player2, view view, HighScore hs) throws IOException {
		while (!player1.getGb().isGameOver() && !player2.getGb().isGameOver()) {
			playTurn(player1, view);
			if(player1.getGb().isGameOver()) {
				gameOver(player1, view, hs);
				break;
			}
			playTurn(player2, view);
			if(player2.getGb().isGameOver()) {
				gameOver(player2, view,hs);
				break;
			}
		}
	}

	/*
	 * Method to handle the game over state.
	 */
	private void gameOver(Player p, view v, HighScore hs) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		String winnerName = p.getName();
		int position = hs.checkForNewHighscore(p.getScore());
		if (position < 5) {
			hs.AddEntry(p.getName(), p.getScore(), position);
			v.printWinnerNewHS(winnerName);
		}else {
			v.printWinner(winnerName);
		}
		
		String response = sc.nextLine();
		if(response.equalsIgnoreCase("y")) {
			run();
		} else {
			System.exit(0);
		}

	}
	/*
	 * Primary method for each players turn.
	 */
	public void playTurn(Player player, view v){
		String name = player.getName();
		if (player.isComputer() == false) {
			Scanner scan = new Scanner(System.in);
			int [][] currentGB = player.getGb().getBoard();
			v.printPlayerTurn(name);
			v.PrintGameBoard(currentGB);
			boolean doneShooting = false;
			while (!doneShooting) {
				String input = scan.nextLine();
				int result = CheckInput(input);
				if (result == -1) {
					v.printErrorShooting();
				}
				else if(result == -2) {
					v.printErrorInput();
				}
				else {
					int x = result/10;
					int y = result %10;
					int fire = player.shoot(x, y);
					if(fire == 1 || fire == 2) {
						v.printErrorShooting();
					}
					else if( fire == 0) {
						v.printMiss();
						doneShooting = true;
					}
					else if( fire == 3 ) {
						v.printHit();
						doneShooting = true;
					}
				}

			}
			player.increaseScore();
		} else {
			player.computerTurn();
			player.increaseScore();
		}


	}

	/*
	 * Method for checking the user input to where the user wish to shoot.
	 */
	public int CheckInput(String line) {
		int input = 0;
		ArrayList allowedList = new ArrayList();
		char[] allowedChars = {'a','A','b','B','c','C','d','D','e','E','f','F','g','G','h','H','i','I','j','J'};
		for(int i = 0; i < allowedChars.length; i++) {
			allowedList.add(allowedChars[i]);
		}			
		if (line.length() != 2) {
			input = -1;
		}
		else if(!allowedList.contains(line.charAt(0))) {
			input = -2;
		}
		else {
			if(line.charAt(0) =='a' || line.charAt(0) =='A') {
				input = 0;
			}
			if (line.charAt(0) =='b'|| line.charAt(0) =='B') {
				input = 10;
			}
			if (line.charAt(0) =='c'|| line.charAt(0) =='C') {
				input = 20;
			}
			if (line.charAt(0) =='d'|| line.charAt(0) =='D') {
				input = 30;
			}
			if (line.charAt(0) =='e'|| line.charAt(0) =='E') {
				input = 40;
			}
			if (line.charAt(0) =='f'|| line.charAt(0) =='F') {
				input = 50;
			}
			if (line.charAt(0) =='g'|| line.charAt(0) =='G') {
				input = 60;
			}
			if (line.charAt(0) =='h'|| line.charAt(0) =='H') {
				input = 70;
			}
			if (line.charAt(0) =='i'|| line.charAt(0) =='I') {
				input = 80;
			}
			if (line.charAt(0) =='j'|| line.charAt(0) =='J') {
				input = 90;
			}
			String secondInput = ""+line.charAt(1);
			input = input + Integer.parseInt(secondInput);
		}
		return input;
	}

}
