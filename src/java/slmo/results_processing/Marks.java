/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slmo.results_processing;

import Database.DatabaseConnectionHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author New
 */
public class Marks {

    public void calculate() {
        try {
            Connection con = DatabaseConnectionHandler.getConnection();
            String queryCheck = "SELECT * FROM marks";

            PreparedStatement ps = con.prepareStatement(queryCheck);

            ResultSet rs = ps.executeQuery();
            String[] check = new String[31];
            String[] list = new String[31];
            while (rs.next()) {
                if (rs.getString("indexNum").startsWith("0")) {
                    for (int i = 1; i <= 30; i++) {
                        check[i] = rs.getString("q" + i);
                    }
                } else {
                    list[0] = rs.getString("indexNum");
                    for (int i = 1; i <= 30; i++) {
                        list[i] = rs.getString("q" + i);
                    }
                    updatemarks(list, check);
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void updatemarks(String[] list, String[] check) {
        int score = 0;
        for (int i = 1; i <= 30; i++) {
            if (list[i].equals("")) {
                score += 5;
            } else if (list[i].equals(check[i])) {
                score += 8;
            }
        }
        String queryCheck = "UPDATE student SET marks = ? WHERE indexNum = ?";
        Connection con = DatabaseConnectionHandler.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setInt(1, score);
            ps.setString(2, list[0]);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
