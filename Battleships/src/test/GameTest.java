package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.BattleshipsController;
import model.Gameboard;
import model.Player;

/*
 * Main testing class for the game. Since this game is so small, its easier to contain the important unit tests into
 * a single file.
 */

class GameTest {
	int[][] MockBoard = new int[10][10];
	Player testPlayer = new Player("Tester", false);
	BattleshipsController cont = new BattleshipsController();
	
	@BeforeEach
	void setUp() throws Exception {
		int[][] MockBoard = new int[10][10];
		Player testPlayer = new Player("Tester", false);
		BattleshipsController cont = new BattleshipsController();
	}

	@Test
	void testShootingHit() { 
		MockBoard[8][0] =3;
		testPlayer.getGb().setBoard(MockBoard);
		int result = testPlayer.getGb().shoot(0, 8);
		assertEquals(result, 3);
	}
	@Test
	void testShootingMiss() {	//Testing missing
		MockBoard[8][0] =0;
		testPlayer.getGb().setBoard(MockBoard);
		int result = testPlayer.getGb().shoot(0, 8);
		assertEquals(result, 0);
	}
	@Test
	void testShootingMarkingMissOnTheBoard() { //Making sure we are marking misses correctly.
		MockBoard[8][0] =0;
		testPlayer.getGb().setBoard(MockBoard);
		int result = testPlayer.getGb().shoot(0, 8);
		int change = testPlayer.getGb().getBoard()[8][0];
		assertEquals(change, 1);
	}
	@Test
	void testGameOver() { //Making sure the game over function works as intended
		MockBoard[8][0] =3;
		testPlayer.getGb().setBoard(MockBoard);
		int result = testPlayer.getGb().shoot(0, 8);
		boolean over = testPlayer.getGb().isGameOver();
		assertTrue(over);
	}
	@Test
	void testGameisNotOver() {
		MockBoard[8][0] =3;
		testPlayer.getGb().setBoard(MockBoard);
		boolean over = testPlayer.getGb().isGameOver();
		assertFalse(over);
	}
	@Test
	void testGameboardCreation() { //Making sure we are setting up the right amount of boats. Should be 30 "hull" pieces of boats.
		Gameboard gb = new Gameboard();
		int counter = 0;
		for(int y = 0; y <10; y++) {
			for (int x = 0; x < 10; x++) {
				if(gb.getBoard()[y][x] == 3) {
					counter++;
				}
			}
		}
		assertEquals(counter, 30);
	}

}
