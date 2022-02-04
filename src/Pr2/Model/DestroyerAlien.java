package Pr2.Model;

import java.util.Random;

public class DestroyerAlien extends AlienShip{
	private final static int LIFEDESTROYERSHIP = 1;
	private final static int POINTS = 10;
	private final static int DAMAGEDESTROYERSHIP = 1;
	
	private int Points;
	private int Damage;
	private boolean shooted;
	private Bomb bomb;
	Random rand;
	
	public DestroyerAlien(Game game, int X, int Y, int life) {
		super(game, X, Y, LIFEDESTROYERSHIP);
		Points = POINTS;
		Damage = DAMAGEDESTROYERSHIP;
		shooted = false;
		bomb = null;
		rand = game.getRandom();
	}
	
	public String toString() {
		return ("D[" + live + "]");
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getLife() {
		return live;
	}
		
	public int downLife() {
		return live-=1;
	}
	
	public boolean isOnPosition(int X, int Y) {
		return ((x == X) && (y == Y));
	}
	
	public boolean isShooted() {
		return shooted;
	}
	
	public void setShooted(boolean aux) {
		this.shooted = aux;
	}
	
	public boolean CanShoot() {
		return bomb == null;
	}
	
	public static void Info() {
		System.out.println("[D]estroyer ship: Points: " + POINTS + " - Harm: " + DAMAGEDESTROYERSHIP + " - Shield: " + LIFEDESTROYERSHIP);
	}
	
	// Computer action y añado la bomba por game
	public void computerAction() {
		ifIsDead();
		if(CanShoot()) {
			if(IExecuteRandomActions.canGenerateRandomBomb(game)) {
				bomb = new Bomb(this.game, getX(), getY(), DAMAGEDESTROYERSHIP);
				game.addObject(bomb);
			}
		}
	}
	
	public void ifIsDead() {
		if(bomb != null && bomb.live == 0) {
			bomb = null;
		}
	}

	@Override
	public int gamePoints() {
		return POINTS;
	}
	
	public String stringify() {
		return "D;" + getX() + "," + getY() + ";" + getLife() + ";" + this.cyclestomove + ";"
				+ this.dir + stringifyBomb();
	}
	
	public String stringifyBomb() {
		ifIsDead();
		if(CanShoot()) return "\n";
		else return " B;" + bomb.getX() + ";" + bomb.getY() + "\n";
	}
	
}