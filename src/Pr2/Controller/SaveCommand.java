package Pr2.Controller;

import Pr2.Exceptions.*;
import Pr2.Model.*;
import Pr2.View.Stringifier;

public class SaveCommand extends Command{

	private static final String SAVE = "Saves the game on a file";
	private static final String NAME = "save";
	private static final String SHORTCUT = "save";
	private static String FILENAME;
	
	public SaveCommand(String name, String shortCut, String details, String help) {
		super(NAME, SHORTCUT, NAME, SAVE);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		Stringifier stringify = new Stringifier(game);
		stringify.saveGame(FILENAME, game.stringify());
		System.out.println("Game successfully saved in file " + FILENAME);
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(!matchCommandName(commandWords[0])) {
			return null;
		}
		else {
			if(commandWords.length != 2) {
				throw new CommandParseException("These command needs two arguments (save + filename)");
			}
			FILENAME = commandWords[1] + ".dat";
			
			return this;
		}
	}

}
