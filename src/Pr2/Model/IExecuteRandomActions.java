package Pr2.Model;

import Pr2.Model.Game;

public interface IExecuteRandomActions {
	
	static boolean canGenerateRandomOvni(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getOvniFrequency();
	}
	
	static boolean  canGenerateRandomBomb(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getShootFrequency();	
	}
	
}

