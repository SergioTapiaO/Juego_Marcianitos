package Pr2.Model;

public class SuperMissile extends Weapon{
	
	private boolean exits; // Inicializamos en falso porque hasta que no dispara no existe
	private final int DAMAGE = 2;
	
	public SuperMissile(Game game, int X, int Y, int life) {
		super(game, X, Y, life);
		exits = true;
	}
	
	public String toString() {
		if(live > 0)return ("o");
		else return crushed();
	}
	
	public void move() {
		x--;
		if(OutOfOrder()) {
			this.live = 0;
		}
	}
	
	public boolean isOnPosition(int X, int Y) {
		return ((x == X) && (y == Y));
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean exits() {
		return exits;
	}
	
	public void setSuperMissile(boolean aux) {
		exits = aux;
	}
	
	public boolean OutOfOrder() {
		return (getX() < 0);
	}
	
	public boolean isCrushed() {
		return false;
	}
	
	public String crushed() {
		setSuperMissile(false);
		return("#");
	}
	
	public boolean performAttack(GameObject other) {
		if(this.getX() == other.getX() && this.getY() == other.getY()) {
			other.receiveSuperMissileAttack(DAMAGE);
			this.live = 0;
			this.y = -1;
			return true;
		}
		return false;
	}
	
	public boolean receiveBombAttack(int damage) {
		getDamage(damage);
		return true;
	}
	
	public String stringify() {
		return " X;" + getX() + "," + getY();
	}

}

