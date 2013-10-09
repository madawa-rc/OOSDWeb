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

    public static ResultSheet getResultSheet(int indexNum) {
        ResultSheet resultSheet = null;
        try {
            Connection con = DatabaseConnectionHandler.getConnection();
            String queryCheck = "SELECT * from marks WHERE indexNum = ?";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setInt(1, indexNum);
            ResultSet rs1 = ps.executeQuery();
            
            queryCheck = "SELECT * from student WHERE indexNum = ?";
            ps = con.prepareStatement(queryCheck);
            ps.setInt(1, indexNum);
            ResultSet rs2 = ps.executeQuery();
            if (rs1.next() && rs2.next()) {
                resultSheet = new ResultSheet(indexNum, rs2.getString("name"), rs2.getString("school"), rs2.getString("assigned_centre"));
                for (int i = 0; i < 30; ++i) {
                    resultSheet.insertRecords(i, rs1.getString(i + 2));
                }
            }

            // SQL query to get result set with the index

            System.out.println("Index gotten from DB");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resultSheet;
    }
}
