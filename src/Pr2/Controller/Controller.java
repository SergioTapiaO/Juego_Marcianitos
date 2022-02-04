package Pr2.Controller;

import java.util.Random;
import java.util.Scanner;

import Pr2.Exceptions.CommandExecuteException;
import Pr2.Exceptions.CommandParseException;
import Pr2.Model.Game;
import Pr2.Model.Level;
import Pr2.View.FormattedPrinter;
import Pr2.View.GamePrinter;;

public class Controller {
	private static final String PROMPT = "Command > ";
	private static final String unknownCommandMsg = "Invalid Command! \n";
	private static final String GAMEOVER = "***GAME OVER***";

	Scanner scan;
	Game game;
		
	
	public Controller(Game game, Scanner scan) {
		this.game = game;
		this.scan = scan;
	}
	
	public void run(Level level) throws CommandExecuteException, CommandParseException {
		
		FormattedPrinter printer = new FormattedPrinter(this.game);
		System.out.println(game.infoToString());
		System.out.println(printer);
		
		while (!game.isFinished()){
			System.out.print(PROMPT);
			String[] words = scan.nextLine().trim(). split ("\\s+");
			try {
				Command command = CommandGenerator.parseCommand(words);
				if (command != null) {
					if (command.execute(game)) {
						System.out.println(game.infoToString());
						System.out.println(printer);
					}
				} else
					System.out.println(unknownCommandMsg);
			} catch (CommandParseException | CommandExecuteException ex) {
				System.out.format(ex.getMessage() + " %n %n");
			}
		}
		System.out.println(game.getWinnerMessage());
		
	}
}