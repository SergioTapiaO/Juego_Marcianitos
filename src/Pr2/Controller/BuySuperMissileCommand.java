package Pr2.Controller;

import Pr2.Exceptions.CommandExecuteException;
import Pr2.Model.Game;

public class BuySuperMissileCommand extends Command {
	private static final String BUY = "Buy super missile.";
	private static final String NAME = "buySuperMissile";
	private static final String SHORTCUT = "b";

	public BuySuperMissileCommand(String name, String shortCut, String details, String help) {
		super(NAME, SHORTCUT, NAME, BUY);
	}

	public boolean execute(Game game) throws CommandExecuteException {
		boolean aux = game.buySuperMissile();
		if(!aux) {
			throw new CommandExecuteException("Don't have enough points");
		}
		return aux;
	}
	
	public Command parse(String[] commandWords) {
		if(!matchCommandName(commandWords[0])) {
			return null;
		}
		else {
			return this;
		}
	}
}
