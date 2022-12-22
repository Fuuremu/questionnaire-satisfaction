package application;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entite.Apprenant;
import entite.Formateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import service.Model;

public class AjoutFormationController implements Initializable {
	
	@FXML 
	private TextField Thème;
	
	@FXML 
	public ChoiceBox<String> ComboFormateur;
	
	@FXML 
	private Button AjoutFormation;
	
	@FXML
	private TableView<Apprenant> tableView;
	
    @FXML
    public TableColumn<Apprenant, String> nomColId;
    
    @FXML
    public TableColumn<Apprenant, String> prenomColId;
    
    @FXML
    public TableColumn<Apprenant, String> colEdit;
	        
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	initCombo();
    	System.out.println(ComboFormateur.getItems());
    	initTableau();
	}
   
	public void initCombo() {
		Model model = new Model();
		this.ComboFormateur = new ChoiceBox<String>();
		ObservableList<Formateur> liste= model.SelectFormateur();	
    	Formateur Formateur;
    	ObservableList<String> FormateurList = FXCollections.observableArrayList();
        for(int i=0; i < liste.size(); i++) {
        	Formateur = liste.get(i);
        	FormateurList.add(Formateur.getNomFormateur());
//        	System.out.println(FormateurList);
        }      
    	this.ComboFormateur.setItems(FormateurList);
    }
	
	public void initTableau() {
//		Model model = new Model();
//		this.ComboFormateur = new ChoiceBox<String>();
//		ObservableList<Apprenant> listApprenant = model.selectApprenant();
//		nomColId.setCellValueFactory(new PropertyValueFactory<>("Nom"));
//		prenomColId.setCellValueFactory(new PropertyValueFactory<>("Prénom"));
//		tableView.setItems(listApprenant);
//		
//		Callback<TableColumn<Apprenant, String>, TableCell<Apprenant, String>> cellFactory=(param) -> {
//			final TableCell<Apprenant, String> cell = new TableCell<Apprenant, String>() {
//        		@Override
//        		public void updateItem(String item, boolean empty) {
//        			super.updateItem(item, empty);
//        			if(empty) {
//        				setGraphic(null);
//        				setText(null);
//        			}
//        			else {
//        				final CheckBox CheckB = new CheckBox();
//        				CheckB.setOnAction(event -> {
//        					
//        					Apprenant animal = tableView.getItems().get(getIndex());
//        					System.out.println(animal);
//							
//            			});
//            			
//            			setGraphic(CheckB);
//            			setText(null);
//        			}
//        		};
//        	};
//			return cell;
//        };
//        colEdit.setCellFactory(cellFactory);
	};
	
	
	public void ClicOnButtonAjoutFormation (MouseEvent event) {
		Model model = new Model();
		String themeFormation = Thème.getText();
	}
}

