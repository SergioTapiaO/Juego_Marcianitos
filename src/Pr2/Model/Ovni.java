package Pr2.Model;

import java.util.Random;

public class Ovni extends EnemyShip{
	private final static int LIFEOVNI = 1;
	private final static int POINTS = 25;
	
	private int Points;
	private boolean exist;
	Random rand;
	Level level;
	
	public Ovni(Game game, int X, int Y, int life) {
		super(game, X, Y, LIFEOVNI);
		exist = false;
		rand = game.getRandom();
		level = game.getLevel();
	}
	
	public String toString() {
		return ("O[" + live + "]");
	}
	
	public void update() {
		goLeft();
		if(OutOfOrder()) {
			setOvni(false);
		}
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
	
	public void move() {
		if(exist) {
		goLeft();
			if(OutOfOrder()) {
				setOvni(false);
			}
		}
	}
	
	public int goLeft() {
		return y-=1;
	}
	
	public boolean isOnPosition(int X, int Y) {
		return ((this.x == X) && (this.y == Y));
	}
	
	public boolean getExist() {
		return exist;
	}
	
	
	public void setOvni(boolean aux) {
		this.exist = aux;
	}
	
	public void setOvniPos(int X, int Y) {
		this.x = X;
		this.y = Y;
	}
	
	public boolean OutOfOrder() {
		if(getY() < 0) {
			return true;
		}
		else return false;
	}
	
	public static void Info() {
		System.out.println("[O]vni: Points: " + POINTS + " - Harm: 0 - Shield: " + LIFEOVNI);
	}
	
	public void computerAction() {
		if(!getExist()) {
			if(IExecuteRandomActions.canGenerateRandomOvni(game)) {
				setOvni(true);
				setOvniPos(0, 9);
			}
		}
	}

	@Override
	public int gamePoints() {
		return POINTS;
	}
	
	public boolean receiveMissileAttack(int damage) {
		setOvniPos(-1,-1);
		this.onDelete();
		game.enableMissile();
		game.enableShockWave();
		setOvni(false);
		return true;
	}
	
	public boolean receiveSuperMissileAttack(int damage) {
		setOvniPos(-1,-1);
		this.onDelete();
		game.enableMissile();
		game.enableShockWave();
		setOvni(false);
		return true;
	}
	
	public void onDelete() {
		super.onDelete();
	}
	
	public String stringify() {
		return "O;" + getX() + "," + getY() + ";" + this.live + "\n";
	}
	
}