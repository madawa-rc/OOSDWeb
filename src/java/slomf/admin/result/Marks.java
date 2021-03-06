/*
 * A class to process marks of an applicant
 */
package slomf.admin.result;

import slomf.api.Database.DatabaseConnectionHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Fiontar
 */
public class Marks {

    /**
     * method calculate marks of an applicant
     */
    public static void calculate() {
        try {
            Connection con = DatabaseConnectionHandler.createConnection();
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
                }
            }

            rs = ps.executeQuery();
            while (rs.next()) {
                if (!rs.getString("indexNum").startsWith("0")) {
                    list[0] = rs.getString("indexNum");
                    for (int i = 1; i <= 30; i++) {
                        list[i] = rs.getString("q" + i);
                    }
                    updatemarks(list, check,con);
                }
            }
            con.close();
            slomf.admin.Log.addLog("Marks updated");
            Rank.generateRank();
        } catch (SQLException ex) {
            slomf.admin.Log.addLog(ex.getMessage());
        }
    }

    /**
     * method update the marks of the applicant
     *
     * @param list applicant's answers
     * @param check answer sheet
     */
    private static void updatemarks(String[] list, String[] check, Connection con) {
        int score = 0;
        for (int i = 1; i <= 30; i++) {
            if (list[i].equals("")) {
                score += 5;
            } else if (list[i].equals(check[i])) {
                score += 8;
            }
        }
        String queryCheck = "UPDATE student SET marks = ? WHERE indexNum = ?";
        String queryCheck2 = "UPDATE marks SET score = ? WHERE indexNum = ?";
        try {
       //     con = DatabaseConnectionHandler.createConnection();
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setInt(1, score);
            ps.setString(2, list[0]);
            ps.executeUpdate();

            ps = con.prepareStatement(queryCheck2);
            ps.setInt(1, score);
            ps.setString(2, list[0]);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            slomf.admin.Log.addLog(ex.getMessage());
        }
    }

    /**
     * method gives statistics about the performance of applicants for each
     * question
     *
     * @param qNumber question number
     * @return performances list as percentages
     * @throws SQLException database exceptions
     */
    public static double[] getStatistcs(int qNumber) throws SQLException {
        Connection con = DatabaseConnectionHandler.createConnection();
        double allStudents =0.0, attemptedStudents = 0.0, correctStudents = 0.0;
        double[] statistics = new double[11];
        for(int i=0;i<11;i++)
            statistics[i]=0;
        String question = "q" + qNumber;

        String queryCheck = "SELECT " + question + ",indexNum FROM marks";
        PreparedStatement ps = con.prepareStatement(queryCheck);
        ResultSet rs = ps.executeQuery();
        String correctAnswer = null;
        String ans = null;
        int col;
        while (rs.next()) {
            ans = rs.getString(question);
            col=getInt(ans);
            if(col!=-1){
                if (rs.getString("indexNum").startsWith("0")) {
                    correctAnswer = rs.getString(question);
                } else {
                    statistics[col]++;
                }
            }
        }
        con.close();
        correctStudents+=statistics[getInt(correctAnswer)];
        statistics[10]=getInt(correctAnswer);
        for(int i=0;i<7;i++){
            allStudents+=statistics[i];
        }
        attemptedStudents+=allStudents-statistics[5];
        
        statistics[7] = correctStudents;
        statistics[8] = correctStudents * 100 / allStudents;
        statistics[9] = correctStudents * 100 / attemptedStudents;
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
        return statistics;
    }

    private static int getInt(String ans) {
        System.out.println(ans);
        if ("A".equals(ans)) {
            return 0;
        } else if ("B".equals(ans)) {
            return 1;
        } else if ("C".equals(ans)) {
            return 2;
        } else if ("D".equals(ans)) {
            return 3;
        } else if ("E".equals(ans)) {
            return 4;
        } else if ("Unanswered".equals(ans)) {
            return 5;
        } else if ("Multiple".equals(ans)) {
            return 6;
        }
        return -1;
    }
}
