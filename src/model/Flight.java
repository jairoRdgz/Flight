package model;

public class Flight {
	private Date date;
	private Time schedule;
	private String airline;
	private String numFlight;
	private String destiny;
	private String gate;

	public Flight() {
		// TODO - implement Flight.Flight
		throw new UnsupportedOperationException();
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

	public Time getSchedule() {
		return this.schedule;
	}

	/**
	 * 
	 * @param schedule
	 */
	public void setSchedule(Time schedule) {
		this.schedule = schedule;
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
}
