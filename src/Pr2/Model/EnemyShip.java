package Pr2.Model;

public abstract class EnemyShip extends Ship{

	protected Move dir;
	
	public EnemyShip(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}
	
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}
	
	public abstract int gamePoints();
	
	public void onDelete() {
		game.receivePoints(gamePoints());
	}
	
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean receiveMissileAttack(int damage) {
		return true;
	}
	
	public boolean receiveSuperMissileAttack(int damage) {
		return true;
	}

	public boolean receiveExplosiveAttack(int damage) {
		return true;
	}
}