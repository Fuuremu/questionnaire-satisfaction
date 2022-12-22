package application;

import java.awt.Button;
import java.awt.TextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import entite.Apprenant;
import entite.Formateur;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import service.Model;

public class AjoutFormationController implements Initializable {
	
	@FXML 
	private TextField Thème;
	
	@FXML 
	private ComboBox ComboFormateur = new ComboBox();;
	
	@FXML 
	private Button AjoutFormation;
	
	@FXML
	TableView<Apprenant> tableView = new TableView();
	
	@FXML
	TableColumn<Apprenant, String> Nom = new TableColumn<>("Nom");
	
	@FXML
	TableColumn<Apprenant, String> Prénom = new TableColumn<>("Prénom");
	
	@FXML
	TableColumn<Apprenant, Boolean> CheckAjoutFormation = new TableColumn<>("?");
	        
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Model model = new Model();
		List <Formateur> liste= model.SelectFormateur();	
    	String sLigne = "";
    	Formateur Formateur;
        for(int i=0; i < liste.size(); i++) {
        	Formateur = liste.get(i);
        	sLigne += Formateur.getIdFormateur() + " ; " + Formateur.getNomFormateur() + " ; " + Formateur.getPrenomFormateur() + "\n";
            ComboFormateur.getItems().add(Formateur.getNomFormateur()+" "+Formateur.getPrenomFormateur());
        }
	}
	public void ClicOnButtonAjoutFormation (MouseEvent event) {
		Model model = new Model();
		String themeFormation = Thème.getText();
	}
}

