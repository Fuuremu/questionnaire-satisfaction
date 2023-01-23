package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.Rating;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import service.Model;

public class FormulaireController implements Initializable  {

//	@FXML
//    private Rating rat;
	
	@FXML
	private TextField Note1;
	
	@FXML
	private TextField Note2;
	
	@FXML
	private TextField Note3;
	
	@FXML
	private TextField Note4;
	
	@FXML
    private ChoiceBox<String> idSaisieApprentie;
	
	@FXML
    private ChoiceBox<String> idChoixFormation;
	
	@FXML
	private Button Valider;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	    initCombo();
	};
	
	public void ClicOnButtonValiderNotation () {
		Model model = new Model();
		int N1 = 0; 
		int N2 = 0; 
		int N3 = 0; 
		int N4 = 0; 
//		Verifier si toutes les valeurs sont remplies
		if (Note1.equals("") == true) {
			throw new NumberFormatException("Veuillez Ne laisser aucun champ vide, "+Note1+"est vide");
		} else {
			N1 = Integer.parseInt(Note1.getText());
		}
		if (Note2.equals("") == true) {
			throw new NumberFormatException("Veuillez Ne laisser aucun champ vide, "+Note2+"est vide");
		} else {
			N2 = Integer.parseInt(Note2.getText());
		}
		if (Note3.equals("") == true) {
			throw new NumberFormatException("Veuillez Ne laisser aucun champ vide, "+Note3+"est vide");
		} else {
			N3 = Integer.parseInt(Note3.getText());
		}
		if (Note4.equals("") == true) {
			throw new NumberFormatException("Veuillez Ne laisser aucun champ vide, "+Note4+"est vide");
		} else {
			N4 = Integer.parseInt(Note4.getText());
		}
		String Chaine = idSaisieApprentie.getSelectionModel().getSelectedItem();
        String mots[] = Chaine.split(" ");
		int idApprentie = 0;
        for (int i = 0; i < mots.length; i++) {
        	idApprentie = model.SelectIdApprenant(mots[0]);
        }
        int idFormation = model.SelectIdFormation(idChoixFormation.getSelectionModel().getSelectedItem());
		//INSERT
		model.InsertNote(idApprentie, idFormation, N1, N2, N3, N4);
//		System.out.println(idApprentie+"--"+ idFormation+"--"+ N1+"--"+ N2+"--"+ N3+"--"+ N4);
	}
//	Note (idNote idApprenant idFormation note1 note2 note3 note4)
	public void initCombo() {
		Model model = new Model();
		ObservableList<String> listeApprentie= FXCollections.observableList(model.SelectNamesApprentie());	
//		System.out.println(listeApprentie);
		idSaisieApprentie.setItems(listeApprentie);
		ObservableList<String> listeFormation= FXCollections.observableList(model.SelectNamesFormation());
		idChoixFormation.setItems(listeFormation);
//		System.out.println(idSaisieFormateur.getItems());
	}	
	public void onClickButtonReturn() throws IOException {
        Parent rootFXML = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
        Scene scene = this.Valider.getScene();    
        scene.setRoot(rootFXML);       
    }
}
