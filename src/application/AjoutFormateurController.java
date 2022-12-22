package application;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
