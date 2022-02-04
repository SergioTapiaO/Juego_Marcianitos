package Pr2.Model;

public interface IPlayerController {
	
	// PLAYER ACTIONS	
	// Llegan a traves de los comandos
	public boolean move (int numCells);
	public boolean shootMissile();
	public boolean shockWave();
	
	// CALLBACKS
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();
	
}
