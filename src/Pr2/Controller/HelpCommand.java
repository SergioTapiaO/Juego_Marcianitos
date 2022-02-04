package Pr2.Controller;

import Pr2.Controller.Command;
import Pr2.Model.Game;

public class HelpCommand extends Command{
	
	private static final String HELP = "Prints this help message.";
	private static final String NAME = "help";
	private static final String SHORTCUT = "h";

	public HelpCommand(String name, String shortCut, String details, String help) {
		super(NAME, SHORTCUT, NAME, HELP);
	}
	
	public boolean execute(Game game) {
		System.out.print(CommandGenerator.commandHelp());
		return false;
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
