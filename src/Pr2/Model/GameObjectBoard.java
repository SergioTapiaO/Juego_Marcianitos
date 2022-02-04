package Pr2.Model;

import Pr2.Model.GameObject;

public class GameObjectBoard {
	private GameObject[] objects;
	private int currentObjects;
	private final static int DAMAGE = 1;
	
	public GameObjectBoard (int width, int height) {
		objects = new GameObject[width * height];
		this.currentObjects = 0;
	}
	
	private int getCurrentObjects () {
		return currentObjects;
	}
	
	public void add (GameObject object) {
		objects[this.currentObjects] = object;
		this.currentObjects++;
	}
	
	private GameObject getObjectInPosition (int x, int y) {
		int index = getIndex(x,y);
		if(index == -1)return null;
		return objects[index];
	}
	
	private int getIndex(int x, int y) {
		boolean found = false;
		int index = 0;
		while(!found && index < this.currentObjects) {
			if(objects[index].isOnPosition(x, y)) {
				found = true;
			}
			else {
			index++;
			}
		}
		if(!found) {
			index = -1;
		}
		return index;
	}
	
	 public boolean isOnPositionList(int M, int N) {
		 int i = 0;
		 while (i < this.currentObjects && !objects[i].isOnPosition(M, N)) {
			 i++;
		 }
		 return i < this.currentObjects;
	 }

	private void remove (GameObject object) {
		int i = getIndex(object.getX(), object.getY());
		if(i != -1) {
			object = null;
			for(int j = i; j < this.currentObjects;j++) {
				objects[j] = objects[j + 1];
			}
			this.currentObjects--;
		}
	}
	
	public void update() {
		for (int i = 0; i < this.currentObjects; i++) {
			objects[i].move();
			checkAttacks(objects[i]);
		}
		removeDead();
	}
	
	private void checkAttacks(GameObject object) {
		// Recorre todos los objetos, mira que no es el mismo
		boolean attacked = false;
		for(int i = 0; i < currentObjects;i++) {
			if(object != objects[i]) {
				if(object.performAttack(objects[i])) {
					attacked = true;
				}
			}
			
		}
	}
	
	public void computerAction() {
		for(int i = 0; i < this.currentObjects; i++) {
			objects[i].computerAction();
		}
	}
	
	private void removeDead() {
		for(int i = 0; i < this.currentObjects;i++) {
			if(!objects[i].isAlive()) {
				objects[i].onDelete();
				remove(objects[i]);
			}
		}
	}

	public String toString(int x, int y) {
		if( getObjectInPosition(x,y) != null) {
			return getObjectInPosition(x,y).toString();
		}
		else return "";
	}
	
	public void recieveShockwaveAttack() {
		for(int i = 0; i < this.currentObjects; i++) {
			objects[i].receiveShockWaveAttack(DAMAGE);
		}
		removeDead();
	}
	
	public String stringify() {
		StringBuilder text = new StringBuilder();
		
		for(int i = 0; i < this.currentObjects; i++) {
			text.append(objects[i].stringify());
		}
		return text.toString();
	}
	
	public void swapObjects(GameObject object1, GameObject object2) {
		// Buscamos el primero (el regular en la lista)
		int i = getIndex(object1.getX(), object2.getY());
		// Lo cambiamos por el explosive
		objects[i] = object2;
	}
	
	public void explote(int m, int n, int hurt) {
		for(int i = 0; i < this.currentObjects;i++) {
			if(objects[i].isOnPosition(m, n)) {
				objects[i].getDamage(hurt);
			}
		}
		
	}
}

