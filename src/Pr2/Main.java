package Pr2;

import java.util.Random;
import java.util.Scanner;
import Pr2.Controller.Controller;
import Pr2.Exceptions.CommandExecuteException;
import Pr2.Exceptions.CommandParseException;
import Pr2.Model.Game;
import Pr2.Model.Level;

public class Main {
	public static void main(String [] args) throws CommandExecuteException, CommandParseException {
		String arg = args[0];
		Level level = Level.parse(arg);
		System.out.println("Level : " + level);
		
		int seed = new Random (System.currentTimeMillis()).nextInt();
		Random rand = new Random(seed);
		
		Game g = new Game(level, rand);
		Scanner scan = new Scanner(System.in);
		Controller c = new Controller (g, scan);
		c.run(level);
	}
}