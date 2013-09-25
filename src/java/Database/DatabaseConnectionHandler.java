/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author New
 */
public class DatabaseConnectionHandler {
    private static Connection con = null;
    
    private static Connection createConnection(){
            try {
                Class.forName(Constants.DRIVER_NAME);
                con = DriverManager.getConnection(Constants.DB_URL,Constants.USERNAME,Constants.PASSWORD);
                return con;
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return null;
        
    }
    
    public static Connection getConnection(){
        if(con == null)
            con = createConnection();
        return con;
    }  
}
