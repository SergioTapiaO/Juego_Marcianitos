package Pr2.Controller;

import Pr2.Model.Game;

public class ListCommand extends Command {
	
	private static final String LIST = "Prints the list of available ships.";
	private static final String NAME = "list";
	private static final String SHORTCUT = "l";

	public ListCommand(String name, String shortCut, String details, String help) {
		super(NAME, SHORTCUT, NAME, LIST);
	}

	public boolean execute(Game game) {
		return game.listExecute();
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