package Pr2.Model;


public enum Level {
 
	EASY(4, 2, 0.2, 3, 0.5, 1, 1, 3, 2, 4), 
	HARD(8, 4, 0.3, 2, 0.2, 2, 1, 3, 3, 3),
	INSANE(12, 4, 0.5, 1, 0.1, 3, 1, 3, 4, 3);

	private int numRegularAliens;
	private int numDestroyerAliens;
	private int numCyclesToMoveOneCell;
	private double ovniFrequency;
	private double shootFrequency;
	private int numRowsOfRegularAliens;
	private double turnExplodeFrequency = 0.05; // actualmente no depende del nivel
	private int firstXregular;
	private int firstYregular;
	private int firstXdestroyer;
	private int firstYdestroyer;

	private Level(
			int numRegularAliens, 
			int numDestroyerAliens, 
			double shootFrequency, 
			int numCyclesToMoveOneCell, 
			double ovniFrequency, 
			int numRowsOfRegularAliens,
			int firstXregular,
			int firstYregular,
			int firstXdestroyer,
			int firstYdestroyer)
	{
		this.numRegularAliens = numRegularAliens;
		this.numDestroyerAliens = numDestroyerAliens;
		this.shootFrequency = shootFrequency;
		this.numCyclesToMoveOneCell = numCyclesToMoveOneCell;
		this.ovniFrequency = ovniFrequency;
		this.numRowsOfRegularAliens = numRowsOfRegularAliens;
		this.firstXregular = firstXregular;
		this.firstYregular = firstYregular;
		this.firstXdestroyer = firstXdestroyer;
		this.firstYdestroyer = firstYdestroyer;

	}
	

	public int getNumRegularAliens() {
		return numRegularAliens;
	}
	
	public int getNumDestroyerAliens() {
		return numDestroyerAliens;
	}

	public double getShootFrequency() {
		return shootFrequency;
	}
	
	public int getNumCyclesToMoveOneCell() {
		return numCyclesToMoveOneCell;
	}

	public double getOvniFrequency() { 
		return ovniFrequency;
	}
	public int getNumRowsOfRegularAliens() {
		return numRowsOfRegularAliens;
	}
	
	public int getNumRegularAliensPerRow() {
		return numRegularAliens / numRowsOfRegularAliens;
	}
	
	public int  getNumDestroyerAliensPerRow() {
		return getNumDestroyerAliens();
	}
	
	public int getFirstXRegular() {
		return firstXregular;
	}
	
	public int getFirstYregular() {
		return firstYregular;
	}
	
	public int getFirstXDestroyer() {
		return firstXdestroyer;
	}
	
	public int getFirstYdestroyer() {
		return firstYdestroyer;
	}
	
	public static Level parse(String cadenaEntrada) {
		for (Level level : Level.values())
			if (level.name().equalsIgnoreCase(cadenaEntrada))
				return level;
	    return EASY;
	}

	public double getTurnExplodeFrequency(){
		return turnExplodeFrequency;
	}
}
