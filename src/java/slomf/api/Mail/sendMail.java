/*
 * A class to implement the process of sending an email
 */
package slomf.api.Mail;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * @author Fiontar
 */

public class sendMail {
/**
 * method sets up the message contents
 * @return message format
 */
    private static Message setUp() {
        final String username = "slomfoundation@gmail.com";

        final String password = "mathcat@slomf";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("slomfoundation@gmail.com"));

            return message;

        } catch (MessagingException e) {
            System.out.println("Email setup failed");
            System.out.println("Error "+e.getLocalizedMessage());
            return null;
        }
    }
/**
 * methods used for contact page. This allows applicant to send email to SLMO 
 * @param email email address
 * @param title message title
 * @param text message content
 */
    public static void sendmail(String email, String title, String text) {
        Message message = setUp();
        try {
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject(title);
            message.setText(text);
            Transport.send(message);
        } catch (MessagingException ex) {
            System.out.println("Email sending failed to "+email);
            System.out.println("Error "+ex.getLocalizedMessage());
        }
    }
/**
 * method implements email sending process
 * @param emailTo receiver email address 
 * @param emailReplyTo replying email address
 * @param title message title
 * @param text message content
 */
    public static void sendmail(String emailTo, String emailReplyTo, String title, String text) {
        Message message = setUp();
        try {
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailTo));
            message.setSubject(title);
            message.setText(text);
            message.setReplyTo(InternetAddress.parse(emailReplyTo));
            Transport.send(message);
        } catch (MessagingException ex) {
            System.out.println("Email sending failed to us from "+emailReplyTo+" "+text);
        }
    }
/**
 * method implements the process of sending email including attachments
 * @param email receiver email
 * @param title message title
 * @param text message content
 * @param fileSource source
 * @param fileName file name
 */
    public static void sendMailWithAttachment(String email, String title, String text, String fileSource, String fileName) {
        try {
            Message message = setUp();
            
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject(title);
            Multipart multipart = new MimeMultipart();
            
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(text);
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(fileSource);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

            // Send message
            Transport.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
}