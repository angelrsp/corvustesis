package com.corvustec.apce.files.commons.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtilMail {

	
	private static final Logger log = LoggerFactory
			.getLogger(UtilMail.class);
	
	private final Properties properties = new Properties();
    private Session session;
    
    
    private void init() {
        //properties.put("mail.smtp.host", "smtp.gmail.com");
    	properties.put("mail.smtp.host", "mail.neural.com.ec");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", 587);
//        properties.put("mail.smtp.mail.sender", "silsag.fod@gmail.com");
//        properties.put("mail.smtp.mail.sender.name", "SILSAG");
//        properties.put("mail.smtp.password", "admin.fod2014");
//        properties.put("mail.smtp.user", "silsag.fod@gmail.com");
        
        properties.put("mail.smtp.mail.sender", "vhvela@neural.com.ec");
        properties.put("mail.smtp.mail.sender.name", "Neural");
        properties.put("mail.smtp.password", "vhvela");
        properties.put("mail.smtp.user", "vhvela@neural.com.ec");
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); 
        properties.put("mail.smtp.ssl.trust", "mail.neural.com.ec");

        session = Session.getDefaultInstance(properties);
    }
    
    public void send(String destino,String asunto, String mensaje,File file) {
        init();
        try {
        	log.info("send");
        	log.info("send "+destino);
        	
        	
            MimeMessage message = new MimeMessage(session);
            
            BodyPart part=new MimeBodyPart();
            part.setDataHandler(new DataHandler(new FileDataSource(file.getAbsolutePath())));
            part.setFileName(file.getName());
            
            MimeMultipart mp=new MimeMultipart();
            mp.addBodyPart(part);
            
            message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender"),(String) properties.get("mail.smtp.mail.sender.name")));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            message.setSubject(asunto);
            message.setText(mensaje,"ISO-8859-1","html");
            message.setContent(mp);
            Transport t = session.getTransport("smtp");
            log.info("conectar");
            t.connect((String) properties.get("mail.smtp.user"), (String) properties.get("mail.smtp.password"));
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            log.info("cerrar");
        } catch (MessagingException e) {
        	log.info(e.toString());
            return;
        } catch (UnsupportedEncodingException e) {
        	log.info(e.toString());
		}
    }
	
    
    public static void enviar(String destino,String asunto, String mensaje,File file)
    {
    	new UtilMail().send(destino, asunto, mensaje, file);
    }
}
