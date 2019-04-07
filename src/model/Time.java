package model;

public class Time {
	public final static int AM = 1;
	public final static int PM = 2;
	
	private int hour;
	private int minutes;
	private int am_pm;
	
	public Time(int h, int m, int t) {
		this.hour = h;
		this.minutes = m;
		this.am_pm = t;
	}

	public int getHour() {
		return hour;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getAm_pm() {
		return am_pm;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public void setAm_pm(int am_pm) {
		this.am_pm = am_pm;
	}
	
	public String toString() {
		String time;
		if(am_pm == AM) {
			if(hour <10) {
				time = "0"+hour + ":"+ minutes + " AM";
				if(minutes<10) {
					time = "0"+hour + ":"+ "0"+minutes + " AM";
				}
			}else if(minutes <10) {
				time = hour + ":"+ "0"+minutes + " AM";
			}else {
				time = hour + ":"+ minutes + " AM";
			}
			
		}else {
			if(hour <10) {
				time = "0"+hour + ":"+ minutes + " PM";
				if(minutes<10) {
					time = "0"+hour + ":"+ "0"+minutes + " PM";
				}
			}else if(minutes <10) {
				time = hour + ":"+ "0"+minutes + " PM";
			}else {
				time = hour + ":"+ minutes + " PM";
			}
		}
		
		return time;
	}
}
