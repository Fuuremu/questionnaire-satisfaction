package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import service.Model;

public class Controller implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Se connecter à la BD
		Model model = new Model();
		model.ConnectBDD();	
	}
}
