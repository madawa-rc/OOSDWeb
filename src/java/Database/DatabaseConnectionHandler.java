/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author New
 */
public class DatabaseConnectionHandler {
    public Connection getConnection() throws SQLException, ClassNotFoundException{
        try {
            Class.forName("com.mysql.jdbc.Driver");//put the j connector to the lib folde h if not working
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oosd", "root", "123456");
            return con;
        } catch (Exception ex) {
            
        }
        return null;
    }
    
}
