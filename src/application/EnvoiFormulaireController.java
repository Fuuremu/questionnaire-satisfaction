package application;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import entite.Note;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.cell.PropertyValueFactory;
import service.Model;

public class EnvoiFormulaireController implements Initializable {
	
	@FXML
    private ChoiceBox<String> idChoixFormation;

	@FXML
    private Button SendMail;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 initCombo();
	};
	
	public void initCombo() {
		Model model = new Model();
		ObservableList<String> listeFormation= FXCollections.observableList(model.SelectNamesFormation());
		idChoixFormation.setItems(listeFormation);
	}		
	
	public void onClickButtonReturn() throws IOException {
        Parent rootFXML = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
        Scene scene = this.SendMail.getScene();    
        scene.setRoot(rootFXML);       
	}
	public void onClickButtonSendMail() throws IOException {
		Model model = new Model();
		int idFormation = model.SelectIdFormation(idChoixFormation.getSelectionModel().getSelectedItem());
		//recuperer la liste de tout les mails des apprentie de la formation
		ObservableList<String> listMails = FXCollections.observableArrayList(model.SelectMailsApprentieOfFormation(idFormation));
	    //Je parcour la liste des mails et j'envoie un mail à chaque apprentie de la formation
	    for (int i = 0; i < listMails.size() ; i++) {
	    	System.out.println(listMails.get(i));
	    	send("ciemg.ngis@gmail.com", "abslmhqlhdlxdamr", listMails.get(i), "LE SUJET", "Test");
	    };
		
//		 send("ciemg.ngis@gmail.com", "abslmhqlhdlxdamr", "arbouchilham1@gmail.com", "LE SUJET", "Test");
//		  // Adresse email de l'expéditeur
//	        String from = "arbouchilham1@gmail.com";
//	        // Mot de passe de l'expéditeur
//	        String password = "Ilhamattiarbouch1234?";
//	        // Adresse email du destinataire
//	        String to = "arbouchilham1@gmail.com";
//	        // Sujet du message
//	        String subject = "LE SUJET";
//	        // Corps du message
//	        String body = "LE CORPS";
//
//	        send(from, password, to, subject, body);
	}

    private int SelectIdFormation() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void send(String from, String password, String to, String subject, String body) {
        // Récupération des propriétés de l'environnement
        Properties props = new Properties();
        // Définition de l'hôte SMTP
        props.put("mail.smtp.host", "smtp.gmail.com");
        // Activation de la communication sécurisée (TLS)
        props.put("mail.smtp.starttls.enable", "true");
        // Port SMTP
        props.put("mail.smtp.port", "587");
        // Nom d'utilisateur (adresse email)
        props.put("mail.smtp.auth", "true");
        
        // Création d'une session avec les propriétés de l'environnement
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            // Création du message
            MimeMessage message = new MimeMessage(session);
            // Définition de l'expéditeur
            message.setFrom(new InternetAddress(from));
            // Définition du destinataire
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Définition du sujet
            message.setSubject(subject);
            // Définition du corps du message
            message.setText(body);

//            MimeMultipart multipart = new MimeMultipart();      
//            BodyPart messageBodyPart = new MimeBodyPart();
//            messageBodyPart.setContent(bean.getBody()+"<br>","text/html");
//            multipart.addBodyPart(messageBodyPart);
            
            // Envoi du message
            Transport.send(message);
            System.out.println("Email envoyé avec succès");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
