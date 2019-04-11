package ui;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;
import model.Flight;
import model.FlightList;

public class FligthsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private GridPane grid;

    @FXML
    private TextField numberOfFlights;
    
    @FXML
    private TextField searcher;

    @FXML
    private VBox dates;
    
    @FXML
    private VBox schedule;

    @FXML
    private VBox airlines;

    @FXML
    private VBox flies;

    @FXML
    private VBox destinies;
    
    @FXML
    private Label pag;

    @FXML
    private VBox gates;
    
    @FXML
    private Label time;
    
    @FXML
    private ComboBox<String> parameter;
    
    private FlightList fligths;
    
    @FXML
    public void search(ActionEvent evetn) {
    	clearTable();
    	String parama = parameter.getValue();
    	String value = searcher.getText();
    	try {
    		fligths.binarySort(parama, value);
    	}catch(NullPointerException e) {
    		Alert info = new Alert(AlertType.ERROR);
        	info.setTitle("PacMan");
        	info.setHeaderText(null);
        	info.initStyle(StageStyle.UTILITY);
        	info.setContentText("Please introduce a value to search first");
        	info.show();
    	}
    	
    	showTable();
    	
    }
    
    @FXML
    public void next(ActionEvent event) {
    	int este = Integer.parseInt(pag.getText())+1;
    	if(este<fligths.getFlight().size()/16 +2) {
    		pag.setText(este+"");
        	clearTable();
        	showTable();
    	}
    	
    }
    
    @FXML
    public void prev(ActionEvent event) {
    	int este = Integer.parseInt(pag.getText())-1;
    	if(este>0) {
    		pag.setText(este+"");
        	clearTable();
        	showTable();
    	}
    }

    @FXML
    public void generate(ActionEvent event) {
    	long  ti = System.currentTimeMillis();
    	clearTable();
    	grid.setVisible(true);
    	fligths = new FlightList(new ArrayList<Flight>());
    	ArrayList<Flight> fls = fligths.getFlight();
    	
    	int num = 0;
    	try {
    		num = Integer.parseInt(numberOfFlights.getText());
    	}catch(NumberFormatException e) {
    		Alert info = new Alert(AlertType.ERROR);
        	info.setTitle("Vojabes International Airport");
        	info.setHeaderText(null);
        	info.initStyle(StageStyle.UTILITY);
        	info.setContentText("Please introduce a number");
        	info.show();
    	} 
    	
    	for (int i = 0; i < num ; i++) {
    		Flight fl = new Flight(fligths.getRandomDate(),fligths.getRandomTime(), fligths.getRandomAirline(), fligths.getRandomCode(), fligths.getRandomDestiny(), fligths.randomChar());
    		fls.add(fl);
		}
    	fligths.insertionSortAirline(fls);
    	showTable();
    	time.setText((System.currentTimeMillis()-ti) +" Mili Seconds");
    }
    
    public void clearTable() {
    	dates.getChildren().clear();
    	schedule.getChildren().clear();
		airlines.getChildren().clear();
		flies.getChildren().clear();
		destinies.getChildren().clear();
		gates.getChildren().clear();
    }
    
    public void showTable() {
    	ArrayList<Flight> fls = fligths.getFlight();
    	int pages = fls.size()/16;
    	
    	for(int j=0; j<=pages; j++) {
    		if(j+1 == Integer.parseInt(pag.getText())) {	
    			for (int i = 16*j; i < 16+(16*j) && i<fls.size(); i++) {
    					Label d = new Label("\t"+fls.get(i).getDate().toString());
    					Label s = new Label("\t"+fls.get(i).getTime().toString());
    					Label a = new Label("\t"+fls.get(i).getAirline());
    					Label f = new Label("\t"+fls.get(i).getNumFlight());
    					Label de = new Label("\t"+fls.get(i).getDestiny());
    					Label g = new Label("\t"+fls.get(i).getGate());			
    					dates.getChildren().add(s);
    					schedule.getChildren().add(d);
    					airlines.getChildren().add(a);
    					flies.getChildren().add(f);
    					destinies.getChildren().add(de);
    					gates.getChildren().add(g);
    			}
    		}
    	}
    }
    
    @FXML
    public void sortBySchedule(ActionEvent event) throws InvocationTargetException{
    	clearTable();
    	
    	showTable();
    }
    
    @FXML
    void sortByAirline(ActionEvent event)  throws InvocationTargetException{
    	long ti = System.currentTimeMillis();
    	clearTable();
    	fligths.insertionSortAirline(fligths.getFlight());
    	showTable();	
    	time.setText((System.currentTimeMillis()-ti) +" Mili Seconds");
    }

    @FXML
    void sortByDate(ActionEvent event)  throws InvocationTargetException{
    	long ti = System.currentTimeMillis();
    	clearTable();
    	
    	
    	showTable();
    	time.setText((System.currentTimeMillis()-ti) +" Mili Seconds");
    }
    
    @FXML
    void sortByDestiny(ActionEvent event)  throws InvocationTargetException{
    	long ti = System.currentTimeMillis();
    	clearTable();
    	fligths.insertionSortDestiny(fligths.getFlight());
    	showTable();
    	time.setText((System.currentTimeMillis()-ti) +" Mili Seconds");
    }
    

    @FXML
    void sortByFlight(ActionEvent event)  throws InvocationTargetException{
    	long ti = System.currentTimeMillis();
    	clearTable();
    	ArrayList<Flight> fls = fligths.getFlight();
    	fligths.insertionSortFlight(fls);
    	showTable();
    	time.setText((System.currentTimeMillis()-ti) +" Mili Seconds");
    }

    @FXML
    void sortByGate(ActionEvent event)  throws InvocationTargetException{
    	long ti =System.currentTimeMillis();
    	clearTable();
    	ArrayList<Flight> fls = fligths.getFlight();
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
    	showTable();
    	time.setText((System.currentTimeMillis()-ti) +" Mili Seconds");
    }
    
    @FXML
    void initialize() {
    	parameter.getItems().add("Time");
    	parameter.getItems().add("Schedule");
    	parameter.getItems().add("Airline");
    	parameter.getItems().add("Flight");
    	parameter.getItems().add("Destiny");
    	parameter.getItems().add("Gate");
    }
}

