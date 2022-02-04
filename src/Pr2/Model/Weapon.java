package Pr2.Model;

public class Weapon extends GameObject{

	protected Move dir;
	protected static final int DAMAGE = 1;
	
	public Weapon(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean performAttack(GameObject other) {
		// Delegado a missile y bomb
		return true;
	}

	@Override
	public String stringify() {
		// TODO Auto-generated method stub
		return "";
	}

}
