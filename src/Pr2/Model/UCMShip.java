package Pr2.Model;

import Pr2.Model.Game;

public class UCMShip extends Ship{
	private final static int LIFEUCMSHIP = 3;
	private final static int DAMAGEUCMSHIP = 1;
	private int points;
	private boolean enableMisile;
	private boolean posibleShock;
	public int numMissile = 0;
	
	Shockwave shockwave;
	UCMMissile laser;
	SuperMissile superMissile;
	
	public UCMShip(Game game, int X, int Y, int life) {
		super(game, X, Y, LIFEUCMSHIP);
		points = 0;
		enableMisile = true;
		posibleShock = false;
		laser = null;
		shockwave = new Shockwave(this.game, -1, -1, 0);
		superMissile = null;
	}
	
	public String stateString() {
		String aux = "Life : " + live + "\n";
		String s = "Shockwave : " + shockwaveToString() + "\n";
		String missile = "SuperMissile: " + numMissile() +"\n";
		return aux + "Points : " + points +"\n" + s + missile;
	}
	
	public String toString() {
		if (live > 0) {
			return ("^__^"); // Si la UCMShip esta con vida
		}
		return ("!xx!");
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
	
	public boolean move (int numCells) {
		if (numCells > 2 || numCells < -2) {
			return false;
		}
		else if (getY()+numCells < 0 || getY()+numCells >= game.DIM_Y) {
			return false;
		}
		else {
			y += numCells;
			return true;
		}
	}
	
	public int downLife() {
		return live-=1;
	}
	
	public boolean isOnPosition(int X, int Y) {
		return ((x == X) && (y == Y));
	}
	
	public static void Info() {
		System.out.println("^__^:Harm: " + DAMAGEUCMSHIP + " - Shield: " + LIFEUCMSHIP);
	}
	
	public int damage() {
		return DAMAGEUCMSHIP;
	}
	
	public void lookIfDead() {
		if(laser != null && laser.live == 0) {
			laser = null;
		}
		if(superMissile != null && superMissile.live == 0) {
			superMissile = null;
		}
	}
	
	public boolean shootMisile() {
		// Mira si puede disparar, si puede lo pone a false y añade el misil a la lista
		lookIfDead();
		if(canShoot()) {
			laser = new UCMMissile(this.game, getX(), getY(), 1);
			game.addObject(laser);
			return true;
		}
		else return false;
	}
	
	public boolean shootSuperMissile() {
		// Mira si puede disparar, si puede lo pone a false y añade el misil a la lista
		lookIfDead();
		if(canShoot() && numMissile > 0) {
			superMissile = new SuperMissile(this.game, getX() - 1, getY(), 1);
			game.addObject(superMissile);
			numMissile--;
			return true;
		}
		else return false;
	}
	
	public void enableMissile() {
		laser = null;
		superMissile = null;
	}
	
	public boolean canShoot() {
		return laser == null && superMissile == null;
	}
	
	public boolean receiveBombAttack(int damage) {
		getDamage(damage);
		return true;
	}
	
	public boolean shootShockwave() {
		if(shockActivated()) {
			game.useShockwave();
			disableShockwave();
			return true;
		}
		else return false;
	}
	
	public void activateShockwave() {
		this.posibleShock = true;
	}
	
	public void disableShockwave() {
		this.posibleShock = false;
	}
	
	public boolean shockActivated() {
		return this.posibleShock;
	}
	
	public String shockwaveToString() {
		if(shockActivated()) {
			return "YES";
		}
		else return "NO";
	}
	
	public void receivePoints(int points) {
		this.points += points;
	}
		
	public int getPoints() {
		return this.points;
	}
	
	public String stringify() {
		String UCM = "P;" + getX() + ", " + getY() + ";" + getLive() + ";" + getPoints();
		if(shockActivated()) {
			UCM = UCM + shockwave.stringify() + "YES";
		}
		else {
			UCM = UCM + shockwave.stringify() + "NO";
		}
		return UCM;
	}
	
	public int numMissile() {
		return numMissile;
	}
	
	public boolean buySuperMissile() {
		if(this.points >= 20) {
			this.points = this.points - 20;
			numMissile++;
			return true;
		}
		return false;
	}
	
	public boolean receiveExplosiveAttack(int damage) {
		getDamage(damage);
		return true;
	}
	
}