package Pr2.Controller;

import Pr2.Model.Game;
import Pr2.View.GamePrinter;

public enum PrinterTypes {
	/*BOARDPRINTER("boardprinter", "prints the game formatted as a board of dimension: ", new FormattedPrinter(Game game)),
	SERIALIZER("serializer", "prints the game as plain text", new Stringifier());
	
	private String printerName;
	private String helpText;
	private GamePrinter printerObject;
	
	private PrinterTypes(String name, String text, GamePrinter printer) {
		printerName = name;
		helpText = text;
		printerObject = printer;
	}
	
	public static String printerHelp(Game game) {
		String helpString = "";
		for (PrinterTypes printer : PrinterTypes.values())
			helpString += String.format("%s : %s%s%n", printer.printerName, printer.helpText,
				(printer == BOARDPRINTER ? Game.DIM_X + " x " + Game.DIM_Y : "") );
		return helpString;
	}
	
	public GamePrinter getObject() {
		return printerObject;
	}*/

}
