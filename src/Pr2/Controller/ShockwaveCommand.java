package Pr2.Controller;

import Pr2.Exceptions.CommandExecuteException;
import Pr2.Model.Game;

public class ShockwaveCommand extends Command{
	
	private static final String SHOCKWAVE = "UCM-Ship releases a shock wave.";
	private static final String NAME = "shockwave";
	private static final String SHORTCUT = "w";

	public ShockwaveCommand(String name, String shortCut, String details, String help) {
		super(NAME, SHORTCUT, NAME, SHOCKWAVE);
	}

	public boolean execute(Game game) throws CommandExecuteException {
		boolean aux = game.shockWave();
		if(!aux) {
			throw new CommandExecuteException("shockwave is not avaiable");
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
