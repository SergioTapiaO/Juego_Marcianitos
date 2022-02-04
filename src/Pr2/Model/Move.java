package Pr2.Model;

public enum Move {
	LEFT, RIGHT, DOWN, UP, NONE;
	
	public Move change() {
		if(this == LEFT) return RIGHT;
		if(this== RIGHT) return LEFT;
		return this;
	}
}
