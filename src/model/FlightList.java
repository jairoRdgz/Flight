package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlightList {
	
	List<Flight> flights;
	
	public FlightList(List<Flight> flg) {
		flights = new ArrayList<Flight>();
	}
	
	public ArrayList<Flight> getFlight() {
		return (ArrayList<Flight>) flights;
	}
	
	public String getRandomAirline() {
		String este = "";
		Random rnd = new Random();
		int value = rnd.nextInt(8);
		for (int i = 0; i < Airlines.values().length; i++) {
			if(value == i) {
				este = Airlines.values()[i].name();
			}
		}
		return este;
	}
	
	public String getRandomDestiny() {
		String este = "";
		Random rnd = new Random();
		int value = rnd.nextInt(8);
		for (int i = 0; i < Destinies.values().length; i++) {
			if(value == i) {
				este = Destinies.values()[i].getName();
			}
		}
		return este;
	}
	
	public String randomChar() {
		char este = 'a';
		String todo =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		este = todo.charAt(rnd.nextInt(26));
		todo = ""+este;
		return todo;
	}
	
	public String getRandomCode() {
		String este = "";
		Random rnd = new Random();
		este = randomChar();
		int num = rnd.nextInt(999);
		if(num<99) {
			este += "0"+ num;
		}else if(num<9) {
			este += "00"+num;		
		}else {
			este += num;
		}
		
		return este;
	}
	
	public Date getRandomDate() {

		Random rnd = new Random();
		int days = rnd.nextInt(31);
		int month = rnd.nextInt(12);
		int year = rnd.nextInt(20);
		year += 2000;
		if(month==2) {
			days = rnd.nextInt(28);
		}
		if(days ==0) {
			++days ;
		}
		
		if(month ==0) {
			++month;
		}
		
		Date date = new Date(year, month, days);
	
		return date;
	}
	
	public Time getRandomTime() {
		Random rnd = new Random();
		int h = rnd.nextInt(12);
		int m = rnd.nextInt(59);
		int t = rnd.nextInt(2);
		Time time = new Time(h, m, t);
		
		return time;
	}

	public void insertionSortGate(ArrayList<Flight> fls) {
    	for (int i = 0; i < fls.size()-1; i++) {
			String minGate = fls.get(i).getGate();
			int minpos = i;
			for (int j = i+1; j < fls.size(); j++) {
				String currentGate = fls.get(j).getGate();
				if(currentGate.compareTo(minGate)<0) {
					minGate = currentGate;
					minpos = j;
				}
			}
			Flight temp = fls.get(minpos);
			fls.set(minpos, fls.get(i));
			fls.set(i, temp);
		}
    }
	
	public void insertionSortDestiny(ArrayList<Flight> fls) {
    	for (int i = 0; i < fls.size()-1; i++) {
			String minDestiny = fls.get(i).getDestiny();
			int minpos = i;
			for (int j = i+1; j < fls.size(); j++) {
				String currentDestiny = fls.get(j).getDestiny();
				if(currentDestiny.compareTo(minDestiny)<0) {
					minDestiny = currentDestiny;
					minpos = j;
				}
			}
			Flight temp = fls.get(minpos);
			fls.set(minpos, fls.get(i));
			fls.set(i, temp);
		}
    }
	
	public void insertionSortFlight(ArrayList<Flight> fls) {
    	for (int i = 0; i < fls.size()-1; i++) {
			String minFlight = fls.get(i).getNumFlight();
			int minpos = i;
			for (int j = i+1; j < fls.size(); j++) {
				String currentFlight = fls.get(j).getNumFlight();
				if(currentFlight.compareTo(minFlight)<0) {
					minFlight = currentFlight;
					minpos = j;
				}
			}
			Flight temp = fls.get(minpos);
			fls.set(minpos, fls.get(i));
			fls.set(i, temp);
		}
    }
	
	public void insertionSortAirline(ArrayList<Flight> fls) {
		for (int i = 0; i < fls.size()-1; i++) {
			String minAirline = fls.get(i).getAirline();
			int minpos = i;
			for (int j = i+1; j < fls.size(); j++) {
				String currentAirline = fls.get(j).getAirline();
				if(currentAirline.compareTo(minAirline)<0) {
					minAirline = currentAirline;
					minpos = j;
				}
			}
			Flight temp = fls.get(minpos);
			fls.set(minpos, fls.get(i));
			fls.set(i, temp);
		}
	}

	public Flight binarySort(String parameter, String value){
		int high = flights.size()-1;
		int low = 0;
		int mid = -1;
		boolean out = false;
		switch (parameter) {
		case "Time":
			
			for (int i = 0; i < flights.size() && out == false ; i++) {
				mid = (low+high)/2;
				if(flights.get(mid).getTime().toString().equalsIgnoreCase(value)) {
					out = true;
				}else if(flights.get(mid).getTime().toString().compareTo(value)<0) {
					high = mid-1;
				}else if(flights.get(mid).getTime().toString().compareTo(value)>0) {
					low = mid+1;
				}
			}
			break;
			
		case "Schedule":
			
			for (int i = 0; i < flights.size() && out == false ; i++) {
				mid = (low+high)/2;
				if(flights.get(mid).getDate().toString().equalsIgnoreCase(value)) {
					out = true;
				}else if(flights.get(mid).getDate().toString().compareTo(value)<0) {
					high = mid-1;
				}else if(flights.get(mid).getDate().toString().compareTo(value)>0) {
					low = mid+1;
				}
			}
			break;
			
		case "Airline":
			
			for (int i = 0; i < flights.size() && out == false ; i++) {
				mid = (low+high)/2;
				if(flights.get(mid).getAirline().equalsIgnoreCase(value)) {
					out = true;
				}else if(flights.get(mid).getAirline().compareTo(value)<0) {
					high = mid-1;
				}else if(flights.get(mid).getAirline().compareTo(value)>0) {
					low = mid+1;
				}
			}
			break;
			
		case "Flight":
			
			for (int i = 0; i < flights.size() && out == false ; i++) {
				mid = (low+high)/2;
				if(flights.get(mid).getNumFlight().equalsIgnoreCase(value)) {
					out = true;
				}else if(flights.get(mid).getNumFlight().compareTo(value)<0) {
					high = mid-1;
				}else if(flights.get(mid).getNumFlight().compareTo(value)>0) {
					low = mid+1;
				}
			}
			break;
			
		case "Destiny":
			
			for (int i = 0; i < flights.size() && out == false ; i++) {
				mid = (low+high)/2;
				if(flights.get(mid).getDestiny().equalsIgnoreCase(value)) {
					out = true;
				}else if(flights.get(mid).getDestiny().compareTo(value)<0) {
					high = mid-1;
				}else if(flights.get(mid).getDestiny().compareTo(value)>0) {
					low = mid+1;
				}
			}
			break;
			
		case "Gate":
			
			for (int i = 0; i < flights.size() && out == false ; i++) {
				mid = (low+high)/2;
				if(flights.get(mid).getGate().equalsIgnoreCase(value)) {
					out = true;
				}else if(flights.get(mid).getGate().compareTo(value)<0) {
					high = mid-1;
				}else if(flights.get(mid).getGate().compareTo(value)>0) {
					low = mid+1;
				}
			}
			break;
			
		default:
			mid = -1; 
			break;
		}
		Flight f =  flights.get(mid);
		flights.clear();
		flights.add(f);
		return f;
	}
}
