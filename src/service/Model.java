package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entite.Apprenant;
import entite.Formateur;
import entite.Formation;
import entite.Note;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {

	private String URL = "jdbc:derby:cciDB;create=true";
	private String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private String LOGIN = "";
	private String PWD = "";
	    
	public Connection cnx;
	    
	public void ConnectBDD() {
		try {
            Class.forName(DRIVER);
            this.cnx = DriverManager.getConnection(URL, LOGIN, PWD);
	        System.out.println("Connection à la base de données");
            Statement st = this.cnx.createStatement();
            //Création des tables
//            st.execute("Drop table Apprenant");
//            st.execute("Drop table Formation");
//            st.execute("Drop table FormationApprenant");
//            st.execute("Drop table Formateur");
//            st.execute("Drop table Note");
//	        st.execute("create table Apprenant (idApprenant INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1 )"+"PRIMARY KEY, nomApprenant varchar(20),prenomApprenant varchar(20), emailApprenant varchar(30))");
//	        st.execute("create table Formation (idFormation INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1 )"+"PRIMARY KEY, ThemeFormation varchar(20),idFormateur int)");
//	        st.execute("create table FormationApprenant (idFormation int, idApprenant int)");
//	        st.execute("create table Formateur (idFormateur INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1 )"+"PRIMARY KEY, nomFormateur varchar(20), prenomFormateur varchar(20))");
//	        st.execute("create table Note (idNote INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1 )"+"PRIMARY KEY, idApprenant int, idFormation int, note1 integer, note2 integer, note3 integer,note4 integer)");
	        //Remplir les donées
//	        st.executeUpdate("INSERT INTO Post VALUES (3, 'ilham','arbouch')");
//	        st.executeUpdate("INSERT INTO Post VALUES (60, 'TOMA','TOMAi')");
	            
            st.close();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }
	//Apprenant***********************************************************************************************************************************************************   
	public ObservableList<Apprenant> selectApprenant() {
		ObservableList <Apprenant> listeApprenants = FXCollections.observableArrayList();
        try {    
            this.cnx = DriverManager.getConnection(URL, LOGIN, PWD);
            System.out.println("Connection à la base de données");
            Statement selectStmt = this.cnx.createStatement();
            String selectSQL = "SELECT * FROM Apprenant";
            ResultSet rs = selectStmt.executeQuery(selectSQL);
            while (rs.next()) {
                String nom = rs.getString("nomApprenant");
                System.out.println(nom);
                String prenom = rs.getString("prenomApprenant");
                System.out.println(prenom);
//                String AdrMail = rs.getString("emailApprenant");
                Apprenant apprenant = new Apprenant(nom, prenom);
                listeApprenants.add(apprenant);
//                System.out.println(listeApprenants);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeApprenants;
    }
//A SUPPRIMER	    
//    public void InsertApprenant(String Nom, String Prénom, String AdresseMail) {   
//    	 try {
//             this.cnx = DriverManager.getConnection(URL, LOGIN, PWD);
//    		 Statement insertStmt = this.cnx.createStatement();
//    		 String insertSQL = "INSERT INTO Apprenant VALUES ('"+Nom+"', '"+Prénom+"', '"+AdresseMail+"')";
//    		 insertStmt.execute(insertSQL);
//    		 insertStmt.close();
//    	 } catch (SQLException e) {
//    		 e.printStackTrace();
//    	 }		
//    }
	public void InsertApprenant(String Nom, String Prénom, String AdresseMail) {   
		try {
			 this.cnx = DriverManager.getConnection(URL, LOGIN, PWD);
             System.out.println("Connection à la base de données");
			 String insertSQL = "INSERT INTO Apprenant (nomApprenant, prenomApprenant, emailApprenant) VALUES (?, ?, ?)";
		     PreparedStatement insertStmt = this.cnx.prepareStatement(insertSQL);
		     System.out.println("INSERT DONE" + Nom + Prénom+ AdresseMail);
		     String selectSQL = "SELECT MAX(idApprenant) FROM Apprenant";
		     Statement selectStmt = this.cnx.createStatement();
		     ResultSet rs = selectStmt.executeQuery(selectSQL);
		     int lastId = 0;
		     if (rs.next()) {
		       lastId = rs.getInt(1);
		     }
		
		     insertStmt.setString(1, Nom);
		     insertStmt.setString(2, Prénom);
		     insertStmt.setString(3, AdresseMail);
//		     System.out.println(Nom+" " +Prénom+" "+AdresseMail);
		     insertStmt.executeUpdate();
		
		     insertStmt.close();
       } catch (SQLException e) {
         e.printStackTrace();
       }
	}
	public void UpdateApprenant(int idToUpdate , String AdrMail) {   
	   	 try {
	         this.cnx = DriverManager.getConnection(URL, LOGIN, PWD);
	   		 PreparedStatement UpdateStmt = this.cnx.prepareStatement("UPDATE Apprenant SET emailApprenant=? WHERE idPost="+idToUpdate);
	   		 UpdateStmt.setString(1, AdrMail);
	   		 UpdateStmt.executeUpdate();
	   		 
	   		 UpdateStmt.close();
	   	 } catch (SQLException e) {
	   		 e.printStackTrace();
	   	 }	
	   }
	
	//Formateur*************************************************************************************************************************************************************
	public ObservableList<Formateur> SelectFormateur() {
		ObservableList<Formateur> listeFormateurs = FXCollections.observableArrayList();
        try {    
            this.cnx = DriverManager.getConnection(URL, LOGIN, PWD);
            System.out.println("Connection à la base de données");
            Statement selectStmt = this.cnx.createStatement();
            String selectSQL = "SELECT * FROM Formateur";
            ResultSet rs = selectStmt.executeQuery(selectSQL);
            while (rs.next()) {
                String nom = rs.getString("nomFormateur");
                String prenom = rs.getString("prenomFormateur");
                Formateur formateur = new Formateur(nom, prenom);
//                System.out.println(nom+" "+prenom);
                listeFormateurs.add(formateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeFormateurs;
    }
	//Pour récupérer l'id à partir du nom et prénom du formateur
	public int SelectIdFormateur (String Nom, String Prenom) {
		int id = 0;
        try {    
            this.cnx = DriverManager.getConnection(URL, LOGIN, PWD);
            System.out.println("Connection à la base de données");
            Statement selectStmt = this.cnx.createStatement();
            String selectSQL = "SELECT idFormateur FROM Formateur WHERE nomFormateur='"+Nom+"' AND prenomFormateur='"+Prenom+"'";
            ResultSet rs = selectStmt.executeQuery(selectSQL);
            while (rs.next()) {
            	id = rs.getInt("idFormateur");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(id);
		return id;
	}
	
	public ObservableList<String> SelectNamesFormateur() {
		ObservableList<String> listeNomsFormateurs = FXCollections.observableArrayList();
		 try {    
	            this.cnx = DriverManager.getConnection(URL, LOGIN, PWD);
	            System.out.println("Connection à la base de données");
	            Statement selectStmt = this.cnx.createStatement();
	            String selectSQL = "SELECT * FROM Formateur";
	            ResultSet rs = selectStmt.executeQuery(selectSQL);
	            while (rs.next()) {
	                String nom = rs.getString("nomFormateur");
	                String prenom = rs.getString("prenomFormateur");
//	                System.out.println(nom+" "+prenom);
	                listeNomsFormateurs.add(nom+" "+prenom);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	     return listeNomsFormateurs; 
	}
	
	public void InsertFormateur(String Nom, String Prénom) {   
		try {
			 this.cnx = DriverManager.getConnection(URL, LOGIN, PWD);
             System.out.println("Connection à la base de données");
			 String insertSQL = "INSERT INTO Formateur (NomFormateur, PrenomFormateur) VALUES (?, ?)";
		     PreparedStatement insertStmt = this.cnx.prepareStatement(insertSQL);
		     System.out.println("INSERT DONE");
		     String selectSQL = "SELECT MAX(idFormateur) FROM Formateur";
		     Statement selectStmt = this.cnx.createStatement();
		     ResultSet rs = selectStmt.executeQuery(selectSQL);
		     int lastId = 0;
		     if (rs.next()) {
		       lastId = rs.getInt(1);
		     }
		
//		     insertStmt.setInt(1, lastId+1);
		     insertStmt.setString(1, Nom);
		     insertStmt.setString(2, Prénom);
//		     System.out.println(Nom+" " +Prénom);
		     insertStmt.executeUpdate();
		
		     insertStmt.close();
       } catch (SQLException e) {
         e.printStackTrace();
       }
	}
	//Formation*************************************************************************************************************************************************************
	public ObservableList<Formation> selectFormation() {
		ObservableList <Formation> listeFormations = FXCollections.observableArrayList();
        try {    
            this.cnx = DriverManager.getConnection(URL, LOGIN, PWD);
            System.out.println("Connection à la base de données");
            Statement selectStmt = this.cnx.createStatement();
            String selectSQL = "SELECT * FROM Formation";
            ResultSet rs = selectStmt.executeQuery(selectSQL);
            while (rs.next()) { 
                String ThemeFormation = rs.getString("themeFormation");
                int idFormateur = rs.getInt("idFormateur");
                Formation formation = new Formation(ThemeFormation, idFormateur);
                listeFormations.add(formation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeFormations;
    }

	public void InsertFormation(String themeFormation, int idFormation) {   
		try {
			 this.cnx = DriverManager.getConnection(URL, LOGIN, PWD);
			 String insertSQL = "INSERT INTO Formation (themeFormation, idFormation) VALUES (?, ?)";
		     PreparedStatement insertStmt = this.cnx.prepareStatement(insertSQL);
		     System.out.println("INSERT FORMATION DONE");
		     String selectSQL = "SELECT MAX(idFormation) FROM Formation";
		     Statement selectStmt = this.cnx.createStatement();
		     ResultSet rs = selectStmt.executeQuery(selectSQL);
		     int lastId = 0;
		     if (rs.next()) {
		       lastId = rs.getInt(1);
		     }
		     insertStmt.setString(1, themeFormation);
		     insertStmt.setInt(2, idFormation);
//		     System.out.println(themeFormation+" " +idFormation);
		     insertStmt.executeUpdate();
		     insertStmt.close();
       } catch (SQLException e) {
         e.printStackTrace();
       }
	}
//	FormationApprenant (idFormation int, idApprenant int)***********************************************************************************************************
	public void InsertFormationApprenant(int idFormation, int idApprenant) {   
		 try {
             this.cnx = DriverManager.getConnection(URL, LOGIN, PWD);
    		 Statement insertStmt = this.cnx.createStatement();
    		 String insertSQL = "INSERT INTO FormationApprenant VALUES ('"+idFormation+"', '"+idApprenant+"')";
    		 insertStmt.execute(insertSQL);
    		 
    		 insertStmt.close();
    	 } catch (SQLException e) {
    		 e.printStackTrace();
    	 }
	}
	//	Note*********************************************************************************************************************************************************
	public ObservableList<Note> selectNote() {
		ObservableList <Note> listeNotes = FXCollections.observableArrayList();
        try {    
            this.cnx = DriverManager.getConnection(URL, LOGIN, PWD);
            System.out.println("Connection à la base de données");
            Statement selectStmt = this.cnx.createStatement();
            String selectSQL = "SELECT * FROM Note";
            ResultSet rs = selectStmt.executeQuery(selectSQL);
            while (rs.next()) { 
                int idApprenant = rs.getInt("idApprenant");
                int idFormation = rs.getInt("idFormation");
                int note1 = rs.getInt("note1");
                int note2 = rs.getInt("note2");
                int note3 = rs.getInt("note3");
                int note4 = rs.getInt("note4");
                Note Note = new Note(idApprenant, idFormation, note1, note2, note3, note4);
                listeNotes.add(Note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeNotes;
    }
}
