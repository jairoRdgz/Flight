package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FligthsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField numberOfFlights;
    
    @FXML
    private TableView<String> table;

    @FXML
    void generate(ActionEvent event) {
    	
    }

    @FXML
    void initialize() {
        assert numberOfFlights != null : "fx:id=\"numberOfFlights\" was not injected: check your FXML file 'Flights.fxml'.";
        assert table != null : "fx:id=\"table\"was not injected: check your FXML file 'Flights.fxml'.";
    }
}
