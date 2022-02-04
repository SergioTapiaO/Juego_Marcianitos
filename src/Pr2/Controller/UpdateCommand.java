package Pr2.Controller;

import Pr2.Model.Game;

public class UpdateCommand extends Command{
	
	private static final String NAME = "update";
	private static final String SHORTCUT = "u";

	public UpdateCommand(String name, String shortCut, String details, String help) {
		super(NAME, SHORTCUT, details, help);
	}

	public boolean execute(Game game) {
		return game.noneExecute();
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
