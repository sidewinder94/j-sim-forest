package Settings;

public enum Mode {
	FORESTIER("1"),
	INCENDIE("2"),
	INSECTES("3");
	
	private final String mode;
	
	Mode(String mode){
		this.mode = mode;
	}
	
	public String getMode(){
		return this.mode;
	}
}
