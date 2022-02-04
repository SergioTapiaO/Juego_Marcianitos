package Pr2.Model;

import java.util.Random;

public class RegularAlien extends AlienShip{
	private final static int LIFEREGULARSHIP = 2;
	private final static int POINTSREGULARSHIP = 5;
	
	private int Points;
	Random rand;
	
	public RegularAlien(Game game, int x, int y, int Life) {
		super(game, x, y, LIFEREGULARSHIP);
		Points = POINTSREGULARSHIP;
		this.rand = game.getRandom();
	}
	
	public String toString() {
		return ("C[" + live + "]");
	}
	
	public int getX () {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getLife() {
		return live;
	}
	
	public int getPoints() {
		return Points;
	}
	
	public int goLeft() {
		return y-=1;
	}
	
	public int goRight() {
		return y+=1;
	}
	
	public int goDown() {
		return x+=1;
	}
	
	public int downLife() {
		return live-=1;
	}
	
	public boolean isOnPosition(int X, int Y) {
		return ((x == X) && (y == Y));
	}
	
	public static void Info() {
		System.out.println("[R]egular ship: Points: " + POINTSREGULARSHIP + " - Harm: 0 - Shield: " + LIFEREGULARSHIP);
	}

	@Override
	public int gamePoints() {
		return POINTSREGULARSHIP;
	}
			
	public void computerAction() {
		if(rand.nextDouble() < game.getLevel().getTurnExplodeFrequency()) {
			ExplosiveShip explosiveShip = new ExplosiveShip(game, this.x, this.y, getLive(), this.cyclestomove, this.dir);
			game.swapObjects(this, explosiveShip);
			AlienShip.cont--;
		}
	}
	
	public boolean receiveExplosiveAttack(int damage) {
		getDamage(damage);
		return true;
	}
	
	public String stringify() {
		return "R;" + getX() + "," + getY() + ";" + getLife() + ";" + this.cyclestomove + ";"
				+ this.dir + "\n";
	}
}