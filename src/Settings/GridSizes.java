package Settings;

public enum GridSizes {
	NORMALE(50),
	GRANDE(75),
	TRES_GRANDE(100),
	PETITE(25),
	MINUSCULE(10);
	
	public final int etats;
	
	GridSizes(int etats){
		this.etats = etats;
	}
	
	public int getEtats(){
		return this.etats;
	}
}
