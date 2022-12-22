package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entite.Apprenant;

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
	        st.execute("create table Apprenant (idApprenant INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), nomApprenant varchar(20),prenomApprenant varchar(20), emailApprenant varchar(20))");
	        st.execute("create table Formation (idFormation int, ThemeFormation varchar(20),idFormateur int, TabApprenants integer[])");
	        st.execute("create table Formateur (idFormateur int, nomFormateur varchar(20), prenomFormateur varchar(20))");
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
	    
	public List<Apprenant> selectApprenant() {
        List <Apprenant> listeApprenants = new ArrayList<Apprenant>();
        try {    
            this.cnx = DriverManager.getConnection(URL, LOGIN, PWD);
            System.out.println("Connection à la base de données");
            Statement selectStmt = this.cnx.createStatement();
            String selectSQL = "SELECT * FROM Apprenant";
            ResultSet rs = selectStmt.executeQuery(selectSQL);
            while (rs.next()) {
                String nom = rs.getString("nomApprenant");
                String prenom = rs.getString("prenomApprenant");
                String AdrMail = rs.getString("emailApprenant");
                Apprenant apprenant = new Apprenant(nom, prenom, AdrMail);
                listeApprenants.add(apprenant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeApprenants;
    }
	    
    public void InsertApprenant(String Nom, String Prénom, String AdresseMail) {   
    	 try {
             this.cnx = DriverManager.getConnection(URL, LOGIN, PWD);
    		 Statement insertStmt = this.cnx.createStatement();
    		 String insertSQL = "INSERT INTO Apprenant VALUES ('"+Nom+"', '"+Prénom+"', '"+AdresseMail+"')";
    		 insertStmt.execute(insertSQL);
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
	}

