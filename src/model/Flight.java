package model;

public class Flight implements Comparable<Flight>{
	private Date date;
	private Time time;
	private String airline;
	private String numFlight;
	private String destiny;
	private String gate;

	public Flight(Date d, Time t, String a, String n, String des, String g) {
		this.date = d;
		this.time = t;
		this.airline = a;
		this.numFlight = n;
		this.destiny = des;
		this.gate = g;
		
	}

	public Date getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getAirline() {
		return this.airline;
	}

	/**
	 * 
	 * @param airline
	 */
	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getNumFlight() {
		return this.numFlight;
	}

	/**
	 * 
	 * @param numFlight
	 */
	public void setNumFlight(String numFlight) {
		this.numFlight = numFlight;
	}

	public String getDestiny() {
		return this.destiny;
	}

	/**
	 * 
	 * @param destiny
	 */
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	public String getGate() {
		return this.gate;
	}

	/**
	 * 
	 * @param gate
	 */
	public void setGate(String gate) {
		this.gate = gate;
	}

	@Override
	public int compareTo(Flight flights) {
		int compare;
		if(airline.compareTo(airline)<0) {
			compare = -1;
		}else if(airline.compareTo(airline)>0) {
			compare = 1;
		}else {
			compare = 0;
		}
		return compare;
	}
	
}
