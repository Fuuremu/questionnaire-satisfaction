package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.Rating;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
	
	@FXML
	public Rating Note1;
	
	@FXML
	public Rating Note2;
	
	@FXML
	public Rating Note3;
	
	@FXML
	public Rating Note4;
	
	@FXML
	public ChoiceBox<String> idSaisieApprentie;
	
	@FXML
	public ChoiceBox<String> idChoixFormation;
	
	@FXML
	public Button Valider;
	
	public int N1 = 0; 
	public int N2 = 0; 
	public int N3 = 0; 
	public int N4 = 0; 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	    initCombo();
	    Note1.ratingProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number old, Number newT1) {
				// TODO Auto-generated method stub
				N1 = newT1.intValue();
//				System.out.println(N1);
			}
		});
	    Note2.ratingProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number old, Number newT2) {
				// TODO Auto-generated method stub
				N2 = newT2.intValue();
//				System.out.println(N2);
			}
		});
	    Note3.ratingProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number old, Number newT3) {
				// TODO Auto-generated method stub
				N3 = newT3.intValue();
//				System.out.println(N3);
			}
		});
	    Note4.ratingProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number old, Number newT4) {
				// TODO Auto-generated method stub
				N4 = newT4.intValue();
//				System.out.println(N4);
			}
		});
	};
	
	public void ClicOnButtonValiderNotation () {
		Model model = new Model();
		String Chaine = idSaisieApprentie.getSelectionModel().getSelectedItem();
        String mots[] = Chaine.split(" ");
		int idApprentie = 0;
        for (int i = 0; i < mots.length; i++) {
        	idApprentie = model.SelectIdApprenant(mots[0]);
        }
        int idFormation = model.SelectIdFormation(idChoixFormation.getSelectionModel().getSelectedItem());
		//INSERT
		model.InsertNote(idApprentie, idFormation, N1, N2, N3, N4);
		System.out.println(idApprentie+"--"+ idFormation+"--"+ N1+"--"+ N2+"--"+ N3+"--"+ N4);
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
