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

public class AjoutAprenantController {
	
	@FXML
	private Pane AjoutApprenant;
	
	@FXML 
	private TextField Nom;
	
	@FXML 
	private TextField sPrenom;
	
	@FXML 
	private TextField AdresseMail;
	
	@FXML 
	private Button AjouterApprenant;
	
	
	public void ClicOnButtonAjoutApprenant (MouseEvent event) {
		Model model = new Model();
		String nomApprenant = Nom.getText();
//		System.out.println(nomApprenant);
		String prenomApprenant = sPrenom.getText();
//		System.out.println(prenomApprenant);
		String emailApprenant = AdresseMail.getText();
//		System.out.println(emailApprenant);
		//INSERT
		model.InsertApprenant(nomApprenant, prenomApprenant, emailApprenant);
	}
	
	public void onClickButtonReturn() throws IOException {
        Parent rootFXML = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
        Scene scene = this.AjoutApprenant.getScene();    
        scene.setRoot(rootFXML);       
	}
}
