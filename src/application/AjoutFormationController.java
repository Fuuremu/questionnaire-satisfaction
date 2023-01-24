package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entite.Apprenant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.*;
import service.Model;

public class AjoutFormationController implements Initializable {
     
	@FXML
	private Pane paneAjoutFormation;
	
    @FXML
    private Button AjoutFormation;
    
    @FXML
    private TextField Thème;
	
	@FXML
    private ChoiceBox<String> idSaisieFormateur;
    
    @FXML
    private TableView<Apprenant> tbData;
    
    @FXML
    public TableColumn<Apprenant, String> nomColId;
    
    @FXML
    public TableColumn<Apprenant, String> prenomColId;
    
    @FXML
    public TableColumn<Apprenant, String> colEdit; 
   
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	    initCombo();
	    initTableau(); 
	};
	
    public void initTableau() {
		Model model = new Model();
		ObservableList<Apprenant> listApprenant = FXCollections.observableArrayList(model.selectApprenant());
//		System.out.println(model.selectApprenant());
    	nomColId.setCellValueFactory(new PropertyValueFactory<>("nomApprenant"));
	    prenomColId.setCellValueFactory(new PropertyValueFactory<>("prenomApprenant"));
	    tbData.setItems(listApprenant);
        Callback<TableColumn<Apprenant, String>, TableCell<Apprenant, String>> cellFactory=(param) -> {
        	final TableCell<Apprenant, String> cell = new TableCell<Apprenant, String>() {
        		@Override
        		public void updateItem(String item, boolean empty) {
        			super.updateItem(item, empty);
        			if(empty) {
        				setGraphic(null);
        				setText(null);
        			}
        			else {
        				final CheckBox editCheck = new CheckBox();
        				editCheck.setOnAction(event -> {	
        					//Il faux tester si la valeur est vrai ou pas ************************************************************************?
        					//Si vrai on enregistre **********************************************************************************************
        					if (editCheck.isSelected()) {
	        					Apprenant apprenant = tbData.getItems().get(getIndex());
//	        					System.out.println(apprenant);
	        					System.out.println(apprenant.getNomApprenant());
//	        					System.out.println(apprenant.getIdApprenant());
	        					final String SEPARATEUR = " ";
	    				        String Chaine = idSaisieFormateur.getSelectionModel().getSelectedItem();
	    				        String mots[] = Chaine.split(SEPARATEUR);
	    				        int idFormateur = 0;
	    				        for (int i = 0; i < mots.length; i++) {
	    				            idFormateur = model.SelectIdFormateur(mots[0], mots[1]);
	    				        }
								//INSERT Formation Apprenant
//	    				        int idApprenant = apprenant.getIdApprenant();
	    				        int idApprenant = model.SelectIdApprenant(apprenant.getNomApprenant());
//	    				        System.out.println("L'id apprenant est : "+apprenant.getIdApprenant());
	        					model.InsertFormationApprenant(idApprenant, idFormateur);
//	        					System.out.println(idApprenant+"*************"+idFormateur+"*************"+"INSERT DONE");
        					}
        					//Sinon on Delete*****************************************************************************************************?
            			});
            			setGraphic(editCheck);
            			setText(null);
        			}
        		};
        	};
        	return cell;
        };
        colEdit.setCellFactory(cellFactory);
        Thème.setText("");
//        initCombo();
    }
	public void initCombo() {
		Model model = new Model();
		ObservableList<String> listeFormateur= FXCollections.observableList(model.SelectNamesFormateur());	
//      System.out.println(liste);
	    idSaisieFormateur.setItems(listeFormateur);
//		System.out.println(idSaisieFormateur.getItems());
	}	
	
	public void ClicOnButtonAjoutFormation () {
		Model model = new Model();
        String Chaine = idSaisieFormateur.getSelectionModel().getSelectedItem();
        String mots[] = Chaine.split(" ");
		int idFormateur = 0;
        for (int i = 0; i < mots.length; i++) {
            idFormateur = model.SelectIdFormateur(mots[0], mots[1]);
        }
		//INSERT Formation
		model.InsertFormation(Thème.getText(), idFormateur);
		System.out.println(Thème.getText()+"****************************"+ idFormateur);
	}
	public void onClickButtonReturn() throws IOException {
        Parent rootFXML = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
        Scene scene = this.AjoutFormation.getScene();    
        scene.setRoot(rootFXML);       
    }
}