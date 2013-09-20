/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author New
 */
public class sendMailTest {
    
    public sendMailTest() {
    }
    @Test
    public void testSendmail() {
        System.out.println("sendmail");
        String email = "isuruf@gmail.com";
        String title = "Email Confirmation for the SLMC 2014";
        String text = "Follow the link to register,"+ "http://localhost:8080/OOSDWeb/EmailConfirmation?id=asdkbvxkcvxjcvs";
        sendMail instance = new sendMail();
        instance.sendmail(email, title, text);
    }
}