package slmo.registration;

import Database.DatabaseConnectionHandler;
import Mail.sendMail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import slmo.registration.Student;

public class StudentDA {

    public static void addStudent(Student student) {
        try {
            DatabaseConnectionHandler dbc=null;
            Connection con=null;
            try {
                 dbc = new DatabaseConnectionHandler();
                con = dbc.getConnection();
            } catch (ClassNotFoundException ex) {
               
            }
            Statement st = con.createStatement();
            String queryCheck = "INSERT INTO student ("
                    + "name,date,month,year,email,school,school_addr,home_addr,pvt_applicant,phone,medium,preferred_centre,"
                    + "verification"
                    +") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getDate());
            ps.setInt(3, student.getMonth());
            ps.setInt(4, student.getYear());
            ps.setString(5, student.getEmail());
            ps.setString(6, student.getSchool());
            ps.setString(7, student.getSchool_addr());
            ps.setString(8, student.getHome_addr());
            ps.setInt(9, student.getPvt_applicant());
            ps.setString(10, student.getPhone());
            ps.setString(11, student.getMedium());
            ps.setString(12, student.getPreferred_centre());
            ps.setString(13, student.getVerification());
            ps.executeUpdate();
            
            System.out.println("Database updated");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    public static void sendVerification(Student student){
         sendMail.sendmail(student.getEmail(),"Email Verification for SLMC 2014", 
                 "Thank you for registering for Sri Lanka Mathematics Competition 2013.\n\n"
                 + "If you did not register, please ignore this email.\n\n"
                 + "Please click the following to verify your email address \n\n\n"+
                 "http://localhost:8080/OOSDWeb/EmailConfirmation?id="
                 + student.getVerification()
                 +"\n\nSri Lanka Mathematics Olympiad Foundation,\n"
                 + "Department of Mathematics,\n"
                 + "University of Colombo.");
        
    }
   public static void getStudent(){
       // get a student from database
   }
}
