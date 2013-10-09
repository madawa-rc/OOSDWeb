/*
 * A class to generate the email varification link
 */
package slmo.registration;

import Database.DatabaseConnectionHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

/**
 * @author Fiontar
 */

public class UniqueID {
    /**
     * static method generate and gives a unique id
     * @return id number
     */
    public static String generate() {
        UUID uuid = UUID.randomUUID();
        String id = (uuid + "").replace("-", "");
        while (searchAndAdd(id)) {
            uuid = UUID.randomUUID();
            id = (uuid + "").replace("-", "");
        }
        return id;
    }
    /**
     * method search for a particular id and if it doesn't exists add that id to the database  
     * @param id unique id
     * @return "true" if that particular id exists, if not returns "false"
     */
    private static boolean searchAndAdd(String id) {
        DatabaseConnectionHandler db = new DatabaseConnectionHandler();
        try {
            Connection con = db.getConnection();
            String queryCheck = "SELECT COUNT(*) from id WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, id); 
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                final int count = resultSet.getInt(1);
                if (count > 0) {
                    return true;
                } else {
                    Statement st = con.createStatement();
                    int rs = st.executeUpdate("INSERT INTO id VALUES ('" + id + "')");
                    return false;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }
    /**
     * method indicates whether a particular school email exists or not
     * @param email school email address 
     * @return "true" if email exist "false" if email doesn't exist
     */
    public static boolean searchSchoolEmail(String email) {
        DatabaseConnectionHandler db = new DatabaseConnectionHandler();
        try {
            Connection con = db.getConnection();
            String queryCheck = "SELECT COUNT(*) from school WHERE email = ?";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                final int count = resultSet.getInt(1);
                if (count > 0) {
                    return true;
            }}
        } catch (Exception e) {
        }
        return false;
    }
    /**
     * method indicates whether a particular student email exists or not
     * @param email student email address
     * @return "true" if email exist "false" if email doesn't exist
     */
    public static boolean searchStudentEmail(String email) {
        DatabaseConnectionHandler db = new DatabaseConnectionHandler();
        try {
            Connection con = db.getConnection();
            String queryCheck = "SELECT COUNT(*) from student WHERE email = ?";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                final int count = resultSet.getInt(1);
                if (count > 0) {
                    return true;
            }}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
