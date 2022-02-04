package Pr2.Controller;

import Pr2.Model.Game;
import Pr2.View.FormattedPrinter;
import Pr2.View.Stringifier;

public class StringifyCommand extends Command{

	private static final String STRINGIFY = "Prints the information of the game on text";
	private static final String NAME = "stringify";
	private static final String SHORTCUT = "g";
	
	public StringifyCommand(String name, String shortCut, String details, String help) {
		super(NAME, SHORTCUT, NAME, STRINGIFY);
	}

	@Override
	public boolean execute(Game game) {
		Stringifier stringgifier = new Stringifier(game);
		System.out.println(stringgifier);
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
