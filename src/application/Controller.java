package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import entite.Formateur;
import javafx.fxml.Initializable;
import service.Model;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Controller implements Initializable{
	
	@FXML
	private Pane paneAccueil;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Se connecter à la BD
		Model model = new Model();
		model.ConnectBDD();	
		ObservableList <Formateur> liste= model.SelectFormateur();
	}
	
	public void onClickFenetreAjouterApprenant() throws IOException {
	        Parent rootFXML = FXMLLoader.load(getClass().getResource("AjoutApprenant.fxml"));
	        Scene scene = this.paneAccueil.getScene();    
	        scene.setRoot(rootFXML);       
	}
	public void onClickFenetreAjouterFormateur() throws IOException {
	        Parent rootFXML = FXMLLoader.load(getClass().getResource("AjoutFormateur.fxml"));
	        Scene scene = this.paneAccueil.getScene();    
	        scene.setRoot(rootFXML);       
	}
	public void onClickFenetreAjouterFormation() throws IOException {
	        Parent rootFXML = FXMLLoader.load(getClass().getResource("AjoutFormation.fxml"));
	        Scene scene = this.paneAccueil.getScene();    
	        scene.setRoot(rootFXML);       
	}
	public void onClickFenetreEnvoiFormulaire() throws IOException {
        Parent rootFXML = FXMLLoader.load(getClass().getResource("EnvoiFormulaire.fxml"));
        Scene scene = this.paneAccueil.getScene();    
        scene.setRoot(rootFXML);       
}
	
	public void onClickFenetreTest() throws IOException {
        Parent rootFXML = FXMLLoader.load(getClass().getResource("Formulaire.fxml"));
        Scene scene = this.paneAccueil.getScene();    
        scene.setRoot(rootFXML);       
	}
	
}
