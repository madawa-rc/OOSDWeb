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
                    + "name,dob,email,school,school_addr,home_addr,pvt_applicant,phone,medium,preferred_centre,"
                    + "assigned_classrm) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, student.getName());
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, 1988);
            cal.set(Calendar.MONTH, 1);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            Date t = cal.getTime();
            ps.setDate(2, new java.sql.Date(t.getTime()));
      //      ps.setString(2, "2013-01-01");
            ps.setString(3, student.getEmail());
            ps.setString(4, "asda");
            ps.setString(5, "asda");
            ps.setString(6, "asda");
            ps.setInt(7, 1);
            ps.setInt(8, 23);
            ps.setString(9, "asda");
            ps.setString(10, "a");
            ps.setString(11, "a");
            
            ps.executeUpdate();
            
            System.out.println("done");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
}
