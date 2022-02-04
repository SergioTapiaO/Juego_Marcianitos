package Pr2.Model;

import Pr2.Model.Game;
import Pr2.Model.Level;
import Pr2.Model.GameObject;

public class BoardInitializer {
	
	private Level level;
	private GameObjectBoard board;
	private Game game;
	
	public  GameObjectBoard initialize(Game game, Level level) {
		this.level = level;
		this.game = game;
		board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);
		
		initializeOvni();
		initializeRegularAliens();
		initializeDestroyerAliens();
		return board;
	}
	
	private void initializeOvni () {
		// Iniciamos las coordenadas
		int x = -1;
		int y = -1;
		// Añadimos el Ovni
		board.add(new Ovni(game, x, y, 1));
	}

	private void initializeRegularAliens () {
		// Iniciamos las coordenadas
		int x = level.getFirstXRegular();
		int y = level.getFirstYregular(); 
		// Añadimos los RegularAlien
		for (int i = 0; i < level.getNumRegularAliens();i++) {
			board.add(new RegularAlien(game, x, y, 2));
			if(i == 3 || i == 7) {
				x++;
				y = level.getFirstYregular();
			}
			else y++;
		}
	}
	
	private void initializeDestroyerAliens() {
		// Iniciamos las coordenadas
		int x = level.getFirstXDestroyer();
		int y = level.getFirstYdestroyer();
		// Añadimos los DestroyerAlien
		for (int i = 0; i < level.getNumDestroyerAliens();i++) {
			board.add(new DestroyerAlien(game, x, y, 1));
			y++;
		}
	}


}
