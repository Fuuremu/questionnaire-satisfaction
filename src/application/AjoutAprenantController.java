package application;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import service.Model;

public class AjoutAprenantController {
	
	@FXML 
	private TextField Nom;
	
	@FXML 
	private TextField Prenom;
	
	@FXML 
	private TextField AdresseMail;
	
	@FXML 
	private Button AjouterApprenant;
	
	
	public void ClicOnButtonAjoutApprenant (MouseEvent event) {
		Model model = new Model();
		String nomApprenant = Nom.getText();
		String prenomApprenant = Prenom.getText();
		String emailApprenant = AdresseMail.getText();
		//INSERT
		model.InsertApprenant(nomApprenant, prenomApprenant, emailApprenant);
	}
}
