package Settings;

public enum Mode {
	FORESTIER("Forestier"),
	INCENDIE("Incendie"),
	INSECTES("Insecte");
	
	private final String mode;
	
	Mode(String mode){
		this.mode = mode;
	}
	
	public String getMode(){
		return this.mode;
	}
}
