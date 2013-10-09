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
import java.util.ArrayList;

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
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public double[] getStatistcs(int qNumber) throws SQLException{
        Connection con = DatabaseConnectionHandler.getConnection();
        int A = 0, B = 0, C = 0, D = 0, E = 0, unanswered = 0, multiple = 0;
        int allStudents,attemptedStudents = 0,correctStudents = 0;
        double[] statistics = new double[10];
        String question = "q"+qNumber;
        
        ArrayList<String> answers = new ArrayList<String>();
        
        String queryCheck = "SELECT "+question+" FROM marks";
        PreparedStatement ps = con.prepareStatement(queryCheck);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            answers.add(rs.getString(question));
        }
        
        String correctAnswer = answers.get(0);
        allStudents = answers.size()-1;
        
        for(int i = 1; i < answers.size(); i++){
            String ans = answers.get(i);
            if(ans.equals("A")){
                ++A;
            }else if(ans.equals("B")){
                ++B;
            }else if(ans.equals("C")){
                ++C;
            }else if(ans.equals("D")){
                ++D;
            }else if(ans.equals("E")){
                ++E;
            }else if(ans.equals("Unanswered")){
                ++unanswered;
            }else if(ans.equals("Multiple")){
                ++multiple;
            }
            if(!(ans.equals("Unanswered")&&ans.equals("Multiple"))){
                ++attemptedStudents;
                if(ans.equals(correctAnswer)){
                    ++correctStudents;
                }
            }
        }
        statistics[0] = A; statistics[1] = B; statistics[2] = C; statistics[3] = D;
        statistics[4] = E; statistics[5] = unanswered; statistics[6] = multiple;
        statistics[7] = correctStudents; statistics[8] = correctStudents*100/allStudents;
        statistics[9] = correctStudents*100/attemptedStudents;
        /*
         * double statistic;
         * 
         * [0] = A's
         * [1] = B's
         * [2] = C's
         * [3] = D's
         * [4] = E's
         * [5] = Unanswered's
         * [6] = Multiple's
         * [7] = Correct Students
         * [8] = Correct Perecentage (correctStudents*100/allStudents)
         * [9] = Correct Perecentage from attempted (correctStudents*100/attemptedStudents)
         */
        for(int i = 0; i < statistics.length; i++){
            System.out.println(statistics[i]);
        }
        return statistics;
    }
}
