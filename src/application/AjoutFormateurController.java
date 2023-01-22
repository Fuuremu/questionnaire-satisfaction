package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import service.Model;

public class AjoutFormateurController {

	@FXML
	private Pane AjoutFormateur;
	
	@FXML 
	private TextField Nom;
	
	@FXML 
	private TextField Prénom;
	
	@FXML 
	private Button AjouterFormateur;
	
	
	public void ClicOnButtonAjoutFormateur (MouseEvent event) {
		Model model = new Model();
		String nomFormateur = Nom.getText();
		String prenomFormateur = Prénom.getText();
		//INSERT
		model.InsertFormateur(nomFormateur, prenomFormateur);
	}
	
	public void onClickButtonReturn() throws IOException {
        Parent rootFXML = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
        Scene scene = this.AjoutFormateur.getScene();    
        scene.setRoot(rootFXML);       
	}
}
