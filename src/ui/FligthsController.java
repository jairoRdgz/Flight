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
    private VBox gates;
    
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
    public void generate(ActionEvent event) {
    	clearTable();
    	grid.setVisible(true);
    	fligths = new FlightList(new ArrayList<Flight>());
    	ArrayList<Flight> fls = fligths.getFlight();
    	
    	int num = 0;
    	try {
    		num = Integer.parseInt(numberOfFlights.getText());
    	}catch(NumberFormatException e) {
    		Alert info = new Alert(AlertType.ERROR);
        	info.setTitle("PacMan");
        	info.setHeaderText(null);
        	info.initStyle(StageStyle.UTILITY);
        	info.setContentText("Please introduce a number");
        	info.show();
    	} 
    	
    	for (int i = 0; i < num ; i++) {
    		Flight fl = new Flight(fligths.getRandomDate(),fligths.getRandomTime(), fligths.getRandomAirline(), fligths.getRandomCode(), fligths.getRandomDestiny(), fligths.randomChar());
    		fls.add(fl);
		}
    	//fligths.insertionSort(fls);
    	showTable();
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
    	for (int i = 0; i < fls.size(); i++) {
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
    
    @FXML
    public void sortBySchedule(ActionEvent event) throws InvocationTargetException{
    	//ArrayList<Flight> fls = fligths.getFlight();
    }
    
    @FXML
    void sortByAirline(ActionEvent event)  throws InvocationTargetException{
    	clearTable();
    	fligths.insertionSortAirline(fligths.getFlight());
    	showTable();	
    }

    @FXML
    void sortByDate(ActionEvent event)  throws InvocationTargetException{
    	clearTable();
    	fligths.insertionSortGate(fligths.getFlight());
    	showTable();
    }
    
    @FXML
    void sortByDestiny(ActionEvent event)  throws InvocationTargetException{
    	clearTable();
    	fligths.insertionSortDestiny(fligths.getFlight());
    	showTable();
    }
    

    @FXML
    void sortByFlight(ActionEvent event)  throws InvocationTargetException{
    	clearTable();
    	ArrayList<Flight> fls = fligths.getFlight();
    	fligths.insertionSortFlight(fls);
    	showTable();
    }

    @FXML
    void sortByGate(ActionEvent event)  throws InvocationTargetException{
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

