package Settings;

public enum Etats {
	ARBRES("Arbres"),
	ARBUSTE("Arbuste"), 
	CENDRE("Cendre"),
	FEU("Feu"),
	INFECTE("Infecté"),
	JEUNE_POUSSE("Jeune Pousse"),
	VIDE("Vide");
	
	public final String etats;
	
	Etats(String etats){
		this.etats = etats;
	}
	
	public String getEtats(){
		return this.etats;
	}
}
