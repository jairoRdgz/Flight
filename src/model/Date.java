package model;

public class Date implements Comparable<Date>{
	private int year;
	private int month;
	private int day;
	
	public Date(int y, int m, int d) {
		this.year = y;
		this.month = m;
		this.day = d;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public String toString() {
		String date;
		
		if(day<10) {
			date = year + "-"+ month +"-"+"0"+day;
			if(month<10) {
				date = year + "-"+ "0"+month +"-"+"0"+day;
			}
		}else if(month<10) {
			date = year + "-"+ "0" +month +"-"+day;
		}else {
			date = year + "-"+ month +"-"+day;
		}
		
		return date;
	}
	
	@Override
	public int compareTo(Date d) {
		int comparator;
		if((day<d.day  && month<d.month && year<d.year)||(month<d.month && year<d.year) || (year < d.year)) {
			comparator = 1;
			
		}else if((day>d.day  && month>d.month && year>d.year)||(month>d.month && year>d.year) || (year>d.year)){
			comparator = -1;
		}else {
			comparator = 0;
		}
		
		return comparator;
	}
}
