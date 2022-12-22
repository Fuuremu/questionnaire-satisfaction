package application;

import javax.mail.Message;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;


import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {
    public static void main(String[] args) {
        // Adresse email de l'expéditeur
        String from = "emelinemsanchez@gmail.com";
        // Mot de passe de l'expéditeur
        String password = "@6D1/wOd8v42";
        // Adresse email du destinataire
        String to = "ilhamarbouch1@gmail.com";
        // Sujet du message
        String subject = "LE SUJET";
        // Corps du message
        String body = "LE CORPS";

        send(from, password, to, subject, body);
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

            // Envoi du message
            Transport.send(message);
            System.out.println("Email envoyé avec succès");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

