package Pr2.Controller;

import Pr2.Model.Game;

public class ListPrintersCommand extends Command{

	private static final String NAME = "listPrinters";
	private static final String SHORTCUT = "lp";
	private static final String HELP = "Show the diferents types of printers";
	
	public ListPrintersCommand(String name, String shortCut, String details, String help) {
		super(NAME, SHORTCUT, NAME, HELP);
	}

	@Override
	public boolean execute(Game game) {
		System.out.println("boardPrinter : prints the game formatted as a board of dimension: 9x8");
		System.out.println("stringifier : prints the game as plain text");
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(!matchCommandName(commandWords[0])) {
			return null;
		}
		else {
			return this;
		}
	}

}
