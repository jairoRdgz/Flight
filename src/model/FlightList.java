package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
		int days = rnd.nextInt();
		Calendar date = Calendar.getInstance();
		date.add(Calendar.YEAR, days);
	
		return date.getTime();
	}

	public void insertionSort(ArrayList<Flight> fls) {
    	
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
			
			/*Student temp = students[minpos];
			students[minpos] = students[i];
			students[i] = temp;
			*/
		}
	
    }
	
	public void bubbleSort(ArrayList<Flight> fls) {
		for (int i = 0; i < fls.size()-1; i++) {
			for (int j = i-1; j < fls.size(); j++) {
				String este = fls.get(i).getNumFlight();
				String siguiente = fls.get(i+1).getNumFlight();
				if(este.compareTo(siguiente)<0) {
					Flight temp = fls.get(i);
					fls.set(i, fls.get(i+1));
					fls.set(i+1, temp);
				}
				
			}
			
		}
	}
}
