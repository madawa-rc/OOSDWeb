/*
 * A class to get a connection to the database  
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Fiontar
 */

public class DatabaseConnectionHandler {
    private static Connection con = null;
    /**
     * method returns a connection to the database if exists
     * @return database connection
     */
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
    /**
     * method gives the connection to the database if exists else get a connection
     * @return database connection 
     */
    public static Connection getConnection(){
        if(con == null)
            con = createConnection();
        return con;
    }  
}
