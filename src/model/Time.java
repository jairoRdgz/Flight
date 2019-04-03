package model;

public class Time {
	private int hour;
	private int minutes;
	private int milis;
	
	public Time(int h, int m, int mil) {
		this.hour = h;
		this.minutes = m;
		this.milis = mil;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getMilis() {
		return milis;
	}

	public void setMilis(int milis) {
		this.milis = milis;
	}
	
	
}
