package Pr2.Controller;

import Pr2.Exceptions.CommandExecuteException;
import Pr2.Model.Game;

public class ShootCommand extends Command{
	
	private static final String SHOOT = "UCM-Ship launches a missile.";
	private static final String NAME = "shoot";
	private static final String SHORTCUT = "s";
	public boolean superMissile;

	public ShootCommand(String name, String shortCut, String details, String help) {
		super(NAME, SHORTCUT, NAME, SHOOT);
	}

	public boolean execute(Game game) throws CommandExecuteException {
		if(superMissile) {
			boolean aux1 = game.shootSuperMissile();
			if(!aux1) {
				throw new CommandExecuteException("Don't have superMissile");
			}
			return aux1;
		}
		boolean aux = game.shootMissile();
		if(!aux) {
			throw new CommandExecuteException("There is already a missile on board");
		}
		return aux;
	}
	
	public Command parse(String[] commandWords) {
		if(!matchCommandName(commandWords[0])) {
			return null;
		}
		else {
			if(commandWords.length == 1) {
				superMissile = false;
			}
			else if(commandWords[1].equalsIgnoreCase("supermissile")){
				superMissile = true;
			}
			return this;
		}
	}
}
