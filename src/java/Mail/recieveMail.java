/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author DELL
 */
public class recieveMail {
   
    public static boolean sendMail(String password,String message){
        String from="slomfoundation@gmail.com";
        String to="slomfoundation@gmail.com";
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host",host);
        props.put("mail.smtp.user",from);  
        props.put("mail.smtp.password",password);
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth","true");
        Session session = Session.getDefaultInstance(props,null);
        
        MimeMessage mimeMessage = new MimeMessage(session);
        try{
        mimeMessage.setFrom(new InternetAddress(from));
        InternetAddress toAddress = new InternetAddress() ;
       
         toAddress =new InternetAddress(to);   
       
         mimeMessage.addRecipient(Message.RecipientType.TO, toAddress);
        
        mimeMessage.setSubject("Testing email");
        mimeMessage.setText(message);
        Transport transport = session.getTransport("smtp");
        transport.connect(host, from, password);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
        return true;
        }catch(MessagingException me){}
        return false;      
        
    }
    
    
     public static void recieveMail(String name,String address,String email,String message)
   {    
       message = "Name : "+name+"   "+"Home address : "+address+"   "+"Email : "+email+"    "+"Message : "+message;
   try{
       if(sendMail( "mathcat@slomf",message))
           System.out.println("success");
           else System.out.println("Failure");
        }catch(Exception e){}
   }
}
