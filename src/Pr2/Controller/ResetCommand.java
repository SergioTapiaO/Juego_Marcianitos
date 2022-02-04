package Pr2.Controller;

import Pr2.Model.Game;

public class ResetCommand extends Command{

	private static final String RESET = "Starts a new game.";
	private static final String NAME = "reset";
	private static final String SHORTCUT = "r";
	
	public ResetCommand(String name, String shortCut, String details, String help) {
		super(NAME, SHORTCUT, NAME, RESET);
	}

	public boolean execute(Game game) {
		game.resetExecute();
		return true;
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
