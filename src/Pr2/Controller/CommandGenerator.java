package Pr2.Controller;

import Pr2.Exceptions.CommandParseException;

public class CommandGenerator {
	
	static String name;
	static String shortCut; 
	static String details;
	static String help;

	private static Command[] availableCommands = {
			new ListCommand(name, shortCut, details, help),
			new HelpCommand(name, shortCut, details, help),
			new ResetCommand(name, shortCut, details, help),
			new ExitCommand(name, shortCut, details, help),
			new ListCommand(name, shortCut, details, help),
			new NoneCommand(name, shortCut, details, help),
			new MoveCommand(name, shortCut, details, help),
			new ShockwaveCommand(name, shortCut, details, help),
			new ShootCommand(name, shortCut, details, help),
			new StringifyCommand(name, shortCut, details, help),
			new ListPrintersCommand(name, shortCut, details, help),
			new BuySuperMissileCommand(name, shortCut, details, help),
			new SaveCommand(name, shortCut, details, help)
			};
	
	public static Command parseCommand(String[] commandWords) throws CommandParseException {
		Command command = null;
		boolean found = false;
		int i = 0;
		while(i < availableCommands.length && !found) {
			command = availableCommands[i].parse(commandWords);
			if (command != null) {
				found = true;
			}
			i++;
		}
		return command;
	}
	
	public static String commandHelp() {
		StringBuilder text = new StringBuilder();
		
		for (int i = 0; i < availableCommands.length; i++) {
			text.append(availableCommands[i].helpText());
		}
		return text.toString();
	}
	
}
