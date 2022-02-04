package Pr2.View;

import Pr2.Model.Game;
import Pr2.Util.MyStringUtils;

public class FormattedPrinter extends GamePrinter{
	  
	private final int numRows = 8;
	private final int numCols = 9;
	Game game;
	  String[][] board;
	  final String space = " ";
	
	  public FormattedPrinter (Game game) {
		  this.game = game;
	  }
	  
	  private void encodeGame() {
	    board = new String[numRows][numCols];
	    
	    for (int x = 0; x < numRows; x++) {
	    	for (int y = 0; y < numCols; y++) {
	    		board[x][y] = game.positionToString(x, y);
	    	}
	    }
	  }
	  
	  public String toString() {
	    encodeGame();

	    int cellSize = 7;
	    int marginSize = 2;
	    String vDelimiter = "|";
	    String hDelimiter = "-";
	    
	    String rowDelimiter = MyStringUtils.repeat(hDelimiter, (numCols * (cellSize + 1)) - 1);
	    String margin = MyStringUtils.repeat(space, marginSize);
	    String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);
	    
	    StringBuilder str = new StringBuilder();
	    
	    str.append(lineDelimiter);
	    
	    for(int i=0; i<numRows; i++) {
	        str.append(margin).append(vDelimiter);
	        for (int j=0; j<numCols; j++) {
	          str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
	        }
	        str.append(lineDelimiter);
	    }
	    return str.toString();
	  }
}
