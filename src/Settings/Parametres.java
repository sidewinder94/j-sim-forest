package Settings;

public class Parametres {
	
	private int gridSize[] = new int[2];
	private int nbPas;
	private float waitTime;
	private Mode mode;
	
	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public int[] getGridSize() {
		return gridSize;
	}

	public void setGridSize(int[] gridSize) {
		this.gridSize = gridSize;
	}

	public int getNbPas() {
		return nbPas;
	}

	public void setNbPas(int nbPas) {
		this.nbPas = nbPas;
	}

	public float getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(float waitTime) {
		this.waitTime = waitTime;
	}

	public static void main(String[] args) {
		
	}

}
