package model;

public enum Destinies {
	SAN_ANDRES("San Andres"),
	BOGOTA("Bogota"),
	MEDELLIN("Medellin"),
	ARUBA("Aruba"),
	CARTAGENA("Cartagena"), 
	LETICIA("Leticia"),
	TUMACO("Tumacocao"),
	PRADERA("Pradera"),
	PARIS("Paris");
	
	private String name;
	
	private Destinies(String n) {
		this.name = n;
	}
	
	public int getValue() {
		return Destinies.values().length;
	}
	
	public String getName() {
		return name;
	}
}
