package Pr2.Model;

import Pr2.Model.DestroyerAlien;

public abstract class AlienShip extends EnemyShip{

	protected static int cont = 0;
	protected static boolean final_row = false;
	
	protected  boolean onBorder = false;
	private static int ALIENSONBORDER;
	protected int cyclestomove = game.getLevel().getNumCyclesToMoveOneCell();
	
	public AlienShip(Game game, int x, int y, int live) {
		super(game, x, y, live);
		cont++;
		dir = Move.RIGHT;
	}

	public static boolean haveLanded() {		
		return final_row;
	}
	
	public static boolean allDead() {
		return cont == 0;
	}
	
	public static int getRemainingAliens() {
		return cont;
	}
		
	// Suma puntos y reduce el contador
	public void onDelete() {
		super.onDelete();
		cont--;
	}
	
	public void move() {
		// Si los ciclos son 0, los actualizo, muevo y compruebo si estan en el borde
		if(cyclestomove == 0) {
			cyclestomove = game.getLevel().getNumCyclesToMoveOneCell();
			move(dir);
			if(x == 7) {
				final_row = true;
			}
			if(onBorder()) {
				ALIENSONBORDER = cont;
			}
		}
		// Si estan en el borde, empiezan a bajar a la siguiente fila
		else if(ALIENSONBORDER > 0 && !haveLanded()) {
			x++;
			dir = dir.change();
			ALIENSONBORDER--;			
		}
		// Disminuimos el numero de ciclos
		else {
			cyclestomove--;
		}
		 
	}
	
	private void move(Move dir) {
		if (dir == Move.RIGHT) {
			y+=1;
		}
		else if (dir == Move.LEFT) {
			y-=1;
		}
	}
	
	private boolean onBorder() {
		return (y == 0 || y == 8);
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
	
	public boolean receiveExplosiveAttack(int damage) {
		getDamage(damage);
		return true;
	}
	

	public boolean receiveShockWaveAttack(int damage) {
		getDamage(damage);
		game.enableShockWave();
		return true;
	}
	
}