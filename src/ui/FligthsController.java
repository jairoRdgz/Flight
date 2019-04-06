package ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;
import model.Flight;
import model.FlightList;


public class FligthsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button date;
    
    @FXML
    private Button airline;
    
    @FXML
    private Button Flight;
    
    @FXML
    private Button destiny;
    
    @FXML
    private Button gate;

    @FXML
    private TextField numberOfFlights;
    
    @FXML
    private VBox dates;
    
    @FXML
    private VBox airlines;
    
    @FXML
    private VBox flies;
    
    @FXML
    private VBox destinies;
    
    @FXML
    private VBox gates;
    
    
    private FlightList fligths;

    @FXML
    void generate(ActionEvent event) {
    	dates.getChildren().clear();;
		airlines.getChildren().clear();;
		flies.getChildren().clear();;
		destinies.getChildren().clear();;
		gates.getChildren().clear();;
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
    	
    	fligths = new FlightList(new ArrayList<Flight>());
    	ArrayList<Flight> fls = fligths.getFlight();
    	for (int i = 0; i < num ; i++) {
    		Flight fl = new Flight(fligths.getRandomDate(), fligths.getRandomAirline(), fligths.getRandomCode(), fligths.getRandomDestiny(), fligths.randomChar());
    		fls.add(fl);
		}
    	fligths.insertionSort(fls);
    	
    	showTable();
    }
    
    public void addFligths() {
    	
    }

    @FXML
    void initialize() {
    	
    }
    
    public void showTable() {
    	ArrayList<Flight> fls = fligths.getFlight();
    	for (int i = 0; i < fls.size(); i++) {
    		String date =fls.get(i).getDate().toString();
    		Label d = new Label("\t"+date.substring(0, 20));
			Label a = new Label("\t"+fls.get(i).getAirline());
			Label f = new Label("\t"+fls.get(i).getNumFlight());
			Label de = new Label("\t"+fls.get(i).getDestiny());
			Label g = new Label("\t"+fls.get(i).getGate());			
			dates.getChildren().add(d);
			airlines.getChildren().add(a);
			flies.getChildren().add(f);
			destinies.getChildren().add(de);
			gates.getChildren().add(g);
			
		}
    }
}
