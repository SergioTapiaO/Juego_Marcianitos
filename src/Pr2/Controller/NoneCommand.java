package Pr2.Controller;

import Pr2.Model.Game;

public class NoneCommand extends Command{
	
	private static final String NONE = "Skips one cycle.";
	private static final String NAME = "none";
	private static final String SHORTCUT = "n";

	public NoneCommand(String name, String shortCut, String details, String help) {
		super(NAME, SHORTCUT, NAME, NONE);
	}

	public boolean execute(Game game) {
		return game.noneExecute();
	}
	
	public Command parse(String[] commandWords) {
		if(!matchCommandName(commandWords[0]) && !commandWords[0].equals("")) {
			return null;
		}
		else {
			return this;
		}
	}	
}