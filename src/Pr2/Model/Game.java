package Pr2.Model;

import java.util.Random;

import Pr2.View.FormattedPrinter;
import Pr2.Model.Level;
import Pr2.Model.AlienShip;
import Pr2.Model.BoardInitializer;
import Pr2.Model.GameObject;
import Pr2.Model.IPlayerController;
import Pr2.Model.UCMShip;
import Pr2.Model.GameObjectBoard;

public class Game implements IPlayerController{
	public final static int DIM_X = 8;
	public final static int DIM_Y = 9;
	public final static int UCMShipLife = 3;
	private int currentCycle;
	private Random rand;
	private Level level;

	GameObjectBoard board;

	private UCMShip player;
	
	private boolean doExit;
	private BoardInitializer initializer;
	
	public Game (Level level, Random random){
		this.rand = random;
		this.level = level;
		initializer = new BoardInitializer();
		initGame();
	}
	
	public Game game() {
		return this;
	}
		
	public void initGame () {
		currentCycle = 0;
		board = initializer.initialize(this, level);
		player = new UCMShip(this, DIM_X - 1, DIM_Y/2, UCMShipLife);
		board.add(player);
	}

	public Random getRandom() {
		return rand;
	}
	
	public Level getLevel() {
		return this.level;
	}
	
	public void reset() {
		initGame();
	}
	
	public void addObject(GameObject object) {
		board.add(object);
	}
	
	public void swapObjects(GameObject object1, GameObject object2) {
		board.swapObjects(object1, object2);
	}
	
	public String positionToString(int x, int y) {
		return board.toString(x, y);
	}

	public boolean isFinished() {
		return playerWin() || aliensWin() || doExit;
	}
	
	public boolean aliensWin() {
		return !player.isAlive() || AlienShip.haveLanded();
	}
	
	private boolean playerWin () {
		return AlienShip.allDead();
	}
	
	public void update() {
		board.computerAction(); // Si tiene que disparar dispara
		board.update(); // Les dice que se muevan
		currentCycle += 1; // Aumenta ciclos
	}
	
	public boolean isOnBoard(int x, int y) {
		return x >= 0 && y >= 0 && x < DIM_X && y < DIM_Y;
	}
	
	public void exit() {
		doExit = true;
	}
	
	public String infoToString() {
		return "Cycles: " + currentCycle + "\n" +
			player.stateString() +
			"Remaining aliens: " + (AlienShip.getRemainingAliens()) + "\n"; 
	}
	
	public String getWinnerMessage () {
		if (playerWin()) return "Player win!";
		else if (aliensWin()) return "Aliens win!";
		else if (doExit) return "Player exits the game";
		else return "This should not happen";
	}
	
	public boolean exitExecute() {
		doExit = true;
		return false;
	}
	
	public boolean listExecute() {
		RegularAlien.Info();
		DestroyerAlien.Info();
		Ovni.Info();
		player.Info();
		return false;
	}

	public boolean noneExecute() {
		update();
		return true;
	}
	
	public boolean resetExecute() {
		initGame();
		return true;
	}
		
	public int levelCycles() {
		return level.getNumCyclesToMoveOneCell();
	}
	
	public int numCycles() {
		return currentCycle;
	}
	
	public void getExplosion(int m, int n, int damage) {
		board.explote(m, n, damage);
	}
	
	@Override
	public boolean move(int numCells) {
		// Hacemos el player.move booleano para que no haya implementaciones en el game
		boolean aux = player.move(numCells);
		update();
		return aux;
	}

	@Override
	public boolean shootMissile() {
		boolean aux = player.shootMisile();
		update();
		return aux;
	}
	
	@Override
	public boolean shockWave() {
		boolean aux = player.shootShockwave();
		update();
		return aux;
	}
	
	public void useShockwave() {
		// Este ataca a la lista
		board.recieveShockwaveAttack();
	}
	
	@Override
	public void receivePoints(int points) {
		// Recibe los puntos cada vez que mata a un alien
		player.receivePoints(points);
	}

	@Override
	public void enableShockWave() {
		player.activateShockwave();
		
	}

	@Override
	public void enableMissile() {
		// Se habilita cuando ha disparado
		player.enableMissile();
		
	}
	
	public boolean shootSuperMissile() {
		update();
		return player.shootSuperMissile();
	}
	
	public String stringify() {
		StringBuilder text = new StringBuilder();
		text.append(board.stringify());
		return text.toString();
	}
	
	public boolean buySuperMissile() {
		return player.buySuperMissile();
	}
	
}