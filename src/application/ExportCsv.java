package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import entite.Apprenant;
import entite.Note;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import service.Model;

public class ExportCsv implements Initializable  {
	
	@FXML
	private TableView<Note> tbData;
	
    @FXML
    public TableColumn<Note, String> IdApprenantColId;
    
    @FXML
    public TableColumn<Note, String> NomApprentieColId;
    
    @FXML
    public TableColumn<Note, String> IdFormationColId;
    
    @FXML
    public TableColumn<Note, String> ThemeFormationColId; 
    
    @FXML
    public TableColumn<Note, String> Note1ColId; 
    
    @FXML
    public TableColumn<Note, String> Note2ColId;
    
    @FXML
    public TableColumn<Note, String> Note3ColId;
    
    @FXML
    public TableColumn<Note, String> Note4ColId;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	    initTableau(); 
	};
	
	   public void initTableau() {
			Model model = new Model();
			ObservableList<Note> listNote = FXCollections.observableArrayList(model.selectNote());
			System.out.println(listNote);
			IdApprenantColId.setCellValueFactory(new PropertyValueFactory<>("idApprenant"));
			IdFormationColId.setCellValueFactory(new PropertyValueFactory<>("idFormation"));
			Note1ColId.setCellValueFactory(new PropertyValueFactory<>("note1"));
			Note2ColId.setCellValueFactory(new PropertyValueFactory<>("note2"));
			Note3ColId.setCellValueFactory(new PropertyValueFactory<>("note3"));
			Note4ColId.setCellValueFactory(new PropertyValueFactory<>("note4"));
		    tbData.setItems(listNote);   
	    }
   }
