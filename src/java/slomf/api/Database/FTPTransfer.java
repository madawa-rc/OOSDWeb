/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slomf.api.Database;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author New
 */
public class FTPTransfer {

    public static FTPClient setup (boolean pvt) {
        try{
            System.out.println("asdads");
            FTPClient ftp = new FTPClient();
            int reply;
            ftp.connect(Constants.FTP_HOST);
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                throw new Exception("Exception in connecting to FTP Server");
            }
            System.out.println("asdad");
            if(pvt==false)
                ftp.login(Constants.FTP_PUBLIC_USERNAME, Constants.FTP_PASSWORD);
            else
                ftp.login(Constants.FTP_PRIVATE_USERNAME, Constants.FTP_PASSWORD);
            ftp.enterLocalPassiveMode();
            System.out.println("asda");
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            System.out.println("asd");
            return ftp;
        }catch(Exception e){
            slomf.admin.Log.addLog("Exception in connecting to FTP Server");
            return null;
        }
        
    }
    public static void main(String[] args){
        FTPClient ftp = setup(true);
        try {
            System.out.println("as");
            ftp.retrieveFile("AttendanceSheet.docx", new FileOutputStream("AttendanceSheet.docx"));
            System.out.println("a");
        } catch (IOException ex) {
           
        }
    }
    public static void disconnect(FTPClient ftp) {
        if (ftp.isConnected()) {
            try {
                ftp.logout();
                ftp.disconnect();
            } catch (IOException e) {
                slomf.admin.Log.addLog("Logout and disconnection of FTP server failed");
            }
        }
    }
}
