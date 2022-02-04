package Pr2.Model;

public class ExplosiveShip extends AlienShip{

	private final static int DAMAGE = 1;
	private final static int POINTSEXPLOSIVE = 5;
	
	public ExplosiveShip(Game game, int x, int y, int Life, int cycles, Move dir) {
		super(game, x, y, Life);
		this.cyclestomove = cycles;
		this.dir = dir;
	}
	
	public String toString() {
		return ("E[" + getLive() + "]");
	}
	
	public int getX () {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getLive() {
		return live;
	}
	
	public boolean isOnPosition(int X, int Y) {
		return ((x == X) && (y == Y));
	}
	
	public void onDelete() {
		super.onDelete();
		explote();
	}
	
	public void explote() {
		for(int i = -1;i < 2; i++) {
			for(int j = -1;j < 2;j++) {
				game.getExplosion(this.getX() + i,this.getY() + j, this.DAMAGE);
			}
		}
	}
	
	@Override
	public int gamePoints() {
		return POINTSEXPLOSIVE;
	}
	
	public String stringify() {
		return "E;" + getX() + "," + getY() + ";" + getLive() + ";" + this.cyclestomove + ";"
				+ this.dir + "\n";
	}
}


