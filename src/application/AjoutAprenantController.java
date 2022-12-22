package application;

import java.awt.Button;
import java.awt.TextField;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import service.Model;

public class AjoutAprenantController {

	
	@FXML 
	private TextField Nom;
	
	@FXML 
	private TextField Prénom;
	
	@FXML 
	private TextField AdresseMail;
	
	@FXML 
	private Button AjouterApprenant;
	
	
	public void ClicOnButtonAjoutApprenant (MouseEvent event) {
		Model model = new Model();
		String nomApprenant = Nom.getText();
		String prenomApprenant = Prénom.getText();
		String emailApprenant = AdresseMail.getText();
		//INSERT
		model.InsertApprenant(nomApprenant, prenomApprenant, emailApprenant);
	}
}
