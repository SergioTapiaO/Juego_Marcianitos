package Pr2.Controller;

import Pr2.Exceptions.CommandParseException;
import Pr2.Exceptions.CommandExecuteException;
import Pr2.Model.Game;

public class MoveCommand extends Command{
	
	private static final String MOVE = "<left|right><1|2>: Moves UCM-Ship to the indicated direction.";
	private static final String NAME = "move";
	private static final String SHORTCUT = "m";
	public String side;
	public int num;

	public MoveCommand(String name, String shortCut, String details, String help) {
		super(NAME, SHORTCUT, NAME, MOVE);
	}

	public boolean execute(Game game) throws CommandExecuteException{
		boolean aux = game.move(num);
		if(!aux) {
			throw new CommandExecuteException("Can't move that way or wrong instruction");
		}
		return aux;
	}
	
	public Command parse(String[] commandWords) throws CommandParseException {
		if(!matchCommandName(commandWords[0])) {
			return null;
		}
		else {
			if(commandWords.length <= 2) {
				throw new CommandParseException("move command needs more arguments\n");
			}
			side = commandWords[1];
			num = Integer.parseInt(commandWords[2].trim());
			if(side.equalsIgnoreCase("left") || side.equalsIgnoreCase("l")) {
				num = num*-1;
			}
			
			return this;
		}
	}
}
