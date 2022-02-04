package Pr2.View;

import Pr2.Exceptions.FileContentsException;
import Pr2.Model.Game;
import java.io.FileWriter;
import java.io.IOException;

public class Stringifier extends GamePrinter{
	
	private  String first;
	private  String second;
	private  String third;
	
	public Stringifier(Game game) {
		this.game = game;
		this.first = "� Space Invaders v2.0 �\n";
		this.second = "G;" + game.numCycles();
		this.third = "L;" + game.getLevel();
	}

	@Override
	public String toString() {
		System.out.println(first);
		System.out.println(second);
		System.out.println(third);
		return game.stringify();
	}
	
	public void saveGame(String nombFichero, String gameInfo)  {
		try {
			FileWriter pw = new FileWriter(nombFichero);
			pw.write(gameInfo);
			pw.close();
		} catch (IOException ioe) {
			System.out.println("Not able to save on file");
		}
	}

}
