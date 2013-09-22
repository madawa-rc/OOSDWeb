/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

import Database.DatabaseConnectionHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import registration.Student;

/**
 *
 * @author Madawa
 */
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
         //   st.executeUpdate("INSERT INTO student VALUES ('"+student.getName()+"','2013-01-01','1','1','1','1','1','1','1','1','1','1','1','443','1','1','12','1','1');");
            String queryCheck = "INSERT INTO student ("
                    + "name,dob,email,school,school_addr,home_addr,pvt_applicant,phone,medium,preferred_centre"
                    +") VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, student.getName());
            ps.setDate(2, student.getDob());
      //      ps.setString(2, "2013-01-01");
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getSchool());
            ps.setString(5, student.getSchool_addr());
            ps.setString(6, student.getHome_addr());
            ps.setInt(7, 1);
            ps.setString(8, student.getPhone());
            ps.setString(9, student.getMedium());
            ps.setString(10, student.getPreferred_centre());
            
            ps.executeUpdate();
            
            System.out.println("done");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
}
