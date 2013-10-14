/*
 * A class to process marks of an applicant
 */
package slmo.results_processing;

import Database.DatabaseConnectionHandler;
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
                } 
            }
            
            rs = ps.executeQuery();
            while (rs.next()) {
            if(!rs.getString("indexNum").startsWith("0")){
                    list[0] = rs.getString("indexNum");
                    for (int i = 1; i <= 30; i++) {
                        list[i] = rs.getString("q" + i);
                    }
                    updatemarks(list, check);
                }
            }
            Rank.generateRank();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * method update the marks of the applicant
     * @param list applicant's answers
     * @param check answer sheet
     */
    private static void updatemarks(String[] list, String[] check) {
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
        Connection con = DatabaseConnectionHandler.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setInt(1, score);
            ps.setString(2, list[0]);
            ps.executeUpdate();
            
            ps = con.prepareStatement(queryCheck2);
            ps.setInt(1, score);
            ps.setString(2, list[0]);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * method gives statistics about the performance of applicants for each question
     * @param qNumber question number
     * @return performances list as percentages
     * @throws SQLException database exceptions
     */
    public static double[] getStatistcs(int qNumber) throws SQLException{
        Connection con = DatabaseConnectionHandler.getConnection();
        int A = 0, B = 0, C = 0, D = 0, E = 0, unanswered = 0, multiple = 0;
        int allStudents,attemptedStudents = 0,correctStudents = 0;
        double[] statistics = new double[10];
        String question = "q"+qNumber;
        
        ArrayList<String> answers = new ArrayList<String>();
        
        String queryCheck = "SELECT "+question+",indexNum FROM marks";
        PreparedStatement ps = con.prepareStatement(queryCheck);
        ResultSet rs = ps.executeQuery();
        String correctAnswer=null;
        while(rs.next()){
            answers.add(rs.getString(question));
            if(rs.getString("indexNum").startsWith("0")){
                correctAnswer=rs.getString(question);
            }
        }

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
            if(!ans.equals("Unanswered")){
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
        return statistics;
    }
}
