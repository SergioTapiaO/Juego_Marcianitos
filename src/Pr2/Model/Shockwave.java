package Pr2.Model;

public class Shockwave extends Weapon {
	
	private boolean existShockwave;
	
	public Shockwave(Game game, int x, int y, int live) {
		super(game, x, y, live);
		existShockwave = false;
	}
	
	public boolean getExistShockwave() {
		return existShockwave;
	}
	
	public void setShockwave(boolean aux) {
		this.existShockwave = aux;
	}
	
	public String toStringShockwave(){
		if(!getExistShockwave() || this == null) {
			return "NO";
		}
		else return "YES";
	}

	public boolean performAttack(GameObject other) {
		if(this.getX() == other.getX() && this.getY() == other.getY()) {
			other.receiveShockWaveAttack(DAMAGE);
			this.live = 0;
			this.y = -1;
			return true;
		}
		return false;
	}
	
	public String statetoShock() {
		if(!getExistShockwave() )return "NO";
		else return "SI";		
	}
	
	public String stringify() {
		return " W;";
	}
}
