package Settings;

public enum Etats {
	ARBRES("1"),
	ARBUSTE("2"), 
	CENDRE("3"),
	FEU("4"),
	INFECTE("5"),
	JEUNE_POUSSE("6"),
	VIDE("7");
	
	public final String etats;
	
	Etats(String etats){
		this.etats = etats;
	}
	
	public String getEtats(){
		return this.etats;
	}
}
