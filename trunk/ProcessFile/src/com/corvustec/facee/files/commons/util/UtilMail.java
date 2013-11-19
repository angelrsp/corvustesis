package com.corvustec.facee.files.commons.util;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class UtilMail {

	
	public static void enviar(File file)
	{
		try
        {
          // se obtiene el objeto Session. La configuración es para
          // una cuenta de gmail.
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "fensefernando@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props, null);
            // session.setDebug(true);

            // Se compone la parte del texto
            BodyPart texto = new MimeBodyPart();
            texto.setText("Estimado(a) cliente reciba un cordial saludo. Su factura electrónica esta adjunto");

            // Se compone el adjunto con la imagen
            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(
                new DataHandler(new FileDataSource(file.getAbsolutePath())));
            adjunto.setFileName(file.getName());

            // Una MultiParte para agrupar texto e imagen.
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);

            // Se compone el correo, dando to, from, subject y el
            // contenido.
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("washofernando@hotmail.com"));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress("fensefernando@gmail.com"));
            message.setSubject("Factura Electronica Corvustec");
            message.setContent(multiParte);

            // Se envia el correo.
            Transport t = session.getTransport("smtp");
            t.connect("fensefernando@gmail.com", "corvus;tec,.");
            t.sendMessage(message, message.getAllRecipients());
            t.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}
	
}
