package application;

import java.awt.Button;
import java.awt.TextField;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import service.Model;

public class AjoutFormateurController {

	
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
}
