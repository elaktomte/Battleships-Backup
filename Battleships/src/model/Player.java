package model;

import java.util.Random;

public class Player {
	String name = "";
	boolean isComputer = false;
	Gameboard gb;

	public Player(String name, boolean isComputer) {
		this.name = name;
		this.isComputer = isComputer;
		gb = new Gameboard();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isComputer() {
		return isComputer;
	}

	public void setComputer(boolean isComputer) {
		this.isComputer = isComputer;
	}

	public Gameboard getGb() {
		return gb;
	}

	public void setGb(Gameboard gb) {
		this.gb = gb;
	}
	public int shoot(int x, int y) {
		int result = gb.shoot(x, y);
		return result;
	}

	
	/*
	 * This method handles the computer players turn.
	 */
	public void computerTurn() {
		boolean doneShooting = false;
		Random rnd = new Random();
		while(!doneShooting) {
			int x = rnd.nextInt(10);
			int y = rnd.nextInt(10);
			
			int result = shoot(x,y);
			if(result == 0 || result == 3) {
				doneShooting = true;
			}
		}
	}


}
