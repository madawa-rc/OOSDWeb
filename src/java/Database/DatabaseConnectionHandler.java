/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author New
 */
public class DatabaseConnectionHandler {
  //  private static Connection con = null;
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        //if(con == null){
            try {

                Class.forName(Constants.DRIVER_NAME);
                Connection con = DriverManager.getConnection(Constants.DB_URL,Constants.USERNAME,Constants.PASSWORD);
                return con;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            return null;
        /*else{
            return con;
        }*/
    }
    
}
