/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mail;

import slomf.api.Mail.sendMail;
import org.junit.Test;

/**
 *
 * @author New
 */
public class sendMailTest {
    
    public sendMailTest() {
    }
    @Test
    public void testSendmail() {
        slomf.admin.Log.addLog("sendmail");
        String email = "isuruf@gmail.com";
        String title = "Email Confirmation for the SLMC 2014";
        String text = "Follow the link to register,"+ "http://webapp.slmathsolympiad.org/webapp/EmailConfirmation?id=asdkbvxkcvxjcvs";
        sendMail instance = new sendMail();
        instance.sendmail(email, title, text);
    }
}