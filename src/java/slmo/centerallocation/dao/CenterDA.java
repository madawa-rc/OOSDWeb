/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slmo.centerallocation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import slmo.centerallocation.ExamCenter;

/**
 *
 * @author Madawa
 */
public class CenterDA {
    
    public static ArrayList<ExamCenter> getAllCenters(){
        ArrayList<ExamCenter> examCenterList = new ArrayList<ExamCenter>();
        try{
            Connection con = Database.DatabaseConnectionHandler.getConnection();
            Statement st = con.createStatement();
            
            String queryCheck = "SELECT * FROM centers";
            
            PreparedStatement ps = con.prepareStatement(queryCheck);
            
            ResultSet rs = ps.executeQuery();
            
            ExamCenter center;
            while(rs.next()){
                //retrieving center from database
                center = new ExamCenter(
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getInt("capacity"),
                        rs.getInt("classrooms"),
                        rs.getString("supervisor"),
                        rs.getString("phone"));
                //adding center to the arrayList
                examCenterList.add(center);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return examCenterList;
    }
}
