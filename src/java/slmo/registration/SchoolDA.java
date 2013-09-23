/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slmo.registration;

import static slmo.registration.StudentDA.sendVerification;

 

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

/**
 *
 * @author Dell
 */
public class SchoolDA  {
    
    public static void addSchool(School school) {
        try {
            DatabaseConnectionHandler dbc=null;
            Connection con=null;
            try {
                 dbc = new DatabaseConnectionHandler();
                con = dbc.getConnection();
            } catch (ClassNotFoundException ex) {
               
            }
            String queryCheck = "INSERT INTO school ("
                    + "contactname,email,name,school_addr,phone,preferred_centre,"
                    + "verification"
                    +") VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, school.getName());
            ps.setString(2, school.getEmail());
            ps.setString(3, school.getSchool());
            ps.setString(4, school.getSchool_addr());
            ps.setString(5, school.getPhone());
            ps.setString(6, school.getPreferred_centre());
            ps.setString(7, school.getVerification());
            ps.executeUpdate();
            
            sendVerification(school);
            
            
            System.out.println("done");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    public static void sendVerification(School school){
         sendMail.sendmail(school.getEmail(),"Email Verification for SLMC 2014", 
                 "Thank you for registering for Sri Lanka Mathematics Competition 2013.\n\n"
                 + "If you did not register, please ignore this email.\n\n"
                 + "Please click the following to verify your email address \n\n\n"+
                 "http://localhost:8080/OOSDWeb/EmailConfirmation?id="
                 + school.getVerification()
                 +"\n\nSri Lanka Mathematics Olympiad Foundation,\n"
                 + "Department of Mathematics,\n"
                 + "University of Colombo.");
        
    }
    public static void addStudents(School school){
        for(int i=0;i<school.StudentList.size();i++){
            StudentDA.addStudent(school.StudentList.get(i));
        }
    }
    public static School getSchool(String email){
        School s = null;
        try {
            DatabaseConnectionHandler dbc=null;
            Connection con=null;
            try {
                    dbc = new DatabaseConnectionHandler();
                    con = dbc.getConnection();
            String queryCheck = "SELECT * from school WHERE email = ?";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            s = new School(
                    rs.getString("contactname"),
                    rs.getString("email"),
                    rs.getString("name"),
                    rs.getString("school_addr"),
                    rs.getString("phone"),
                    rs.getString("preferred_cantre"),
                    rs.getInt("id"),
                    rs.getInt("payment"),
                    rs.getString("verification"),                    
                    rs.getInt("verified")
                    );
            } catch (ClassNotFoundException ex) {
               
            }
            // SQL query to get school with the email
           
            
            System.out.println("done");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return s;
    }
}


