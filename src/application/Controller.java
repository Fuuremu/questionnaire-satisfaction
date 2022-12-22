package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import service.Model;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.*;


public class Controller implements Initializable{

	
	@FXML
	
	private Pane paneAccueil;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Se connecter à la BD
		Model model = new Model();
		//model.ConnectBDD();	
	}
	
	
	public void onClickFenetreAjouterApprenant() throws IOException {
		//FXMLLoader loader = new FXMLLoader();
		//loader.setLocation(getClass().getResource("AjoutApprenant.fxml"));
		
	        Parent rootFXML = FXMLLoader.load(getClass().getResource("AjoutApprenant.fxml"));
	        Scene scene = this.paneAccueil.getScene();    
	        scene.setRoot(rootFXML);
	    
	        
	}
	
}
