package model;

public enum Airlines {
	
	AVIANCA("Avianca"), 
	WINGO("Wingo"), 
	COPA("Copa Airlines"), 
	AEROGAL("AEROGAL"), 
	TAME("TAME"), 
	SATENA("Satena"), 
	TAC("TAC"), 
	LATAM("Latam");
	
	private String name;
	
	private Airlines(String n) {
		this.name = n;
	}
	
	public int getValue() {
		return Airlines.values().length;
	}
	
	public String getName() {
		return name;
	}
	
}
