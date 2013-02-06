package Settings;

public enum Etats {
	JEUNE_POUSSE("1"),
	ARBUSTE("2"), 
	ARBRES("3"),
	FEU("4"),
	CENDRE("5"),
	INFECTE("6"),
	VIDE("7");
	
	public final String etats;
	
	Etats(String etats){
		this.etats = etats;
	}
	
	public String getEtats(){
		return this.etats;
	}
}
