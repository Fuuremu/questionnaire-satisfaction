package application;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entite.Note;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    
    @FXML
    public Button Exporter;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	    initTableau(); 
	};
	
   public void initTableau() {
		Model model = new Model();
		ObservableList<Note> listNote = FXCollections.observableArrayList(model.selectNote());
		IdApprenantColId.setCellValueFactory(new PropertyValueFactory<>("idApprenant"));
		IdFormationColId.setCellValueFactory(new PropertyValueFactory<>("idFormation"));
		Note1ColId.setCellValueFactory(new PropertyValueFactory<>("note1"));
		Note2ColId.setCellValueFactory(new PropertyValueFactory<>("note2"));
		Note3ColId.setCellValueFactory(new PropertyValueFactory<>("note3"));
		Note4ColId.setCellValueFactory(new PropertyValueFactory<>("note4"));
	    tbData.setItems(listNote);   
	    //Je parcour la liste des notes et j'alimente la liste de nom des apprenants
	    ObservableList<Note> listNomApprenant = FXCollections.observableArrayList();
	    for (int i = 0; i < listNote.size(); i++) {
	    	int idApp = listNote.get(i).getIdApprenant();
//	    	listNomApprenant.addAll(model.SelectNomApprenantById(idApp));
	    };
	    System.out.println(listNomApprenant);
//	    NomApprentieColId.getColumns().addAll(listNote.get(i), listNomApprenant);
    }
   public void ClicOnButtonExporter () {
	   //L'entete du fichier
	   final String HEADER = "Notes des apprenties";
	   final String SEPARATOR = "\n";
	   //Export
	   FileWriter file = null;
	   try {
		   file = new FileWriter("C:\\Exportation\\Exporation.csv");
		   // Vérifier s'il n'existe pas
		   //Ajout de l'entete
		   file.append(HEADER);
		   file.append(SEPARATOR);
		   Model model = new Model();
		   ObservableList<Note> listNote = FXCollections.observableArrayList(model.selectNote());
		   for (int i = 0; i < listNote.size(); i++) {
			   String sLigne = String.valueOf(listNote.get(i).getIdApprenant());
			   sLigne += "---";
			   sLigne += model.SelectNomApprenantById(listNote.get(i).getIdApprenant());
			   sLigne += "---";
			   sLigne += listNote.get(i).getIdFormation();
			   sLigne += "---";
			   sLigne += model.SelectThemeFormationById(listNote.get(i).getIdFormation());
			   sLigne += "---";
			   sLigne += listNote.get(i).getNote1();
			   sLigne += "---";
			   sLigne += listNote.get(i).getNote2();
			   sLigne += "---";
			   sLigne += listNote.get(i).getNote3();
			   sLigne += "---";
			   sLigne += listNote.get(i).getNote4();
			   sLigne += SEPARATOR;
			   file.append(sLigne);
		       System.out.println(sLigne);
		    }
		   file.close();
	   } catch (Exception e){
		   e.printStackTrace();
	   }
   }
   public void onClickButtonReturn() throws IOException {
       Parent rootFXML = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
       Scene scene = this.Exporter.getScene();    
       scene.setRoot(rootFXML);       
}
   }
