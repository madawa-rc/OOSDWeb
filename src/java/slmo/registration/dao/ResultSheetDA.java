/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slmo.registration.dao;

import Database.DatabaseConnectionHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import slmo.registration.ResultSheet;

/**
 *
 * @author Kasun
 */
public class ResultSheetDA {

    public static ResultSheet getResultSheet(String indexNum) {
        ResultSheet resultSheet = null;
        try {
            Connection con = DatabaseConnectionHandler.getConnection();
            String queryCheck = "SELECT * from marks WHERE indexNum = ?";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, indexNum);
            ResultSet rs = ps.executeQuery();
            rs.next();
            resultSheet = new ResultSheet(indexNum);
            for (int i = 0; i < 30; ++i) {
                resultSheet.insertRecords(i, rs.getString(i + 2));
            }

            // SQL query to get result set with the index

            System.out.println("Index gotten from DB");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resultSheet;
    }
}
