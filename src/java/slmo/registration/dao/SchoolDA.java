/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slmo.registration.dao;


import Database.DatabaseConnectionHandler;
import Mail.sendMail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import slmo.registration.School;
import slmo.registration.Student;

/**
 *
 * @author Fiontar
 */
public class SchoolDA  {
    
    public static void addSchool(School school) {
        try {
            DatabaseConnectionHandler dbc;
            Connection con=null;
            try {
                dbc = new DatabaseConnectionHandler();
                con = dbc.getConnection();
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            String queryCheck = "INSERT INTO school ("
                    + "contactname,email,name,password,school_addr,phone,preferred_centre,"
                    + "verification"
                    +") VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, school.getName());
            ps.setString(2, school.getEmail());
            ps.setString(3, school.getSchool());
            ps.setString(4, school.getPassword());
            ps.setString(5, school.getSchool_addr());
            ps.setString(6, school.getPhone());
            ps.setString(7, school.getPreferred_centre());
            ps.setString(8, school.getVerification());
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
        ArrayList<Student> studentList = school.getStudentList();
        
        for(int i=0; i<school.getStudentList().size(); i++){
            StudentDA.addStudent(studentList.get(i));
        }
//        for(int i=0;i<school.StudentList.size();i++){
//            StudentDA.addStudent(school.StudentList.get(i));
//        }
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
            rs.next();
            s = new School(
                    rs.getString("contactname"),
                    rs.getString("email"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("school_addr"),
                    rs.getString("phone"),
                    rs.getString("preferred_centre"),
                    rs.getInt("id"),
                    rs.getInt("payment"),
                    rs.getString("verification"),                    
                    rs.getInt("verified")
                    );
            } catch (ClassNotFoundException ex) {
               ex.printStackTrace();
            }
            // SQL query to get school with the email
           
            
            System.out.println("School gotten from DB");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return s;
    }
}


