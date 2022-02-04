package Pr2.Model;

public class Bomb extends Weapon{
	private boolean exits = false; // Inicializamos en falso porque hasta que no dispara no existe
	private final int DAMAGE = 1;
	
	public Bomb(Game game, int X, int Y, int life) {
		super(game, X, Y, life);
		dir = Move.DOWN;
	}
	
	public String toString() {
		return(".");
	}
	
	public boolean performAttack(GameObject other) {
		if(this.getX() == other.getX() && this.getY() == other.getY()) {
			other.receiveBombAttack(DAMAGE);
			this.live = 0;
			this.y = -1;
			return true;
		}
		return false;
	}
	
	public void move() {
		x++;
		if(OutOfOrder()) {
			// Si se sale del mapa muere
			this.live = 0;
		}
	}
	
	public boolean isOnPosition(int X, int Y) {
		return ((this.x == X) && (this.y == Y));
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
	
	public void setExits(boolean aux) {
		exits = aux;
	}
	
	public boolean OutOfOrder() {
		return(x > Game.DIM_X);
	}
	
	public boolean receiveMissileAttack(int damage) {
		getDamage(damage);
		game.enableMissile();
		return true;
	}
	
	public boolean receiveSuperMissileAttack(int damage) {
		getDamage(damage);
		game.enableMissile();
		return true;
	}
}