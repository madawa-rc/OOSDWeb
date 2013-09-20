//asdkjahsdkjashdk

package Mail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendMail {
    

    public void sendmail(){

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
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("isuruf@gmail.com"));
			message.setSubject("Confirm email address");
			message.setText("Follow the link to register,"+
                                "http://localhost:8080/OOSDWeb/EmailConfirmation?id=asdkbvxkcvxjcvs"
				+ "\n\n");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
    }
}