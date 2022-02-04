package Pr2.Controller;

import Pr2.Controller.Command;
import Pr2.Model.Game;

public class ExitCommand extends Command {
	
	private static final String EXIT = "Terminates the program.";
	private static final String NAME = "exit";
	private static final String SHORTCUT = "e";

	public ExitCommand(String name, String shortCut, String details, String help) {
		super(NAME, SHORTCUT, NAME, EXIT);
	}

	public boolean execute(Game game) {
		return game.exitExecute();
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
