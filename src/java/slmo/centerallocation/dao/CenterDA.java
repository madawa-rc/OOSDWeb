/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slmo.centerallocation.dao;

import Database.DatabaseConnectionHandler;
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
    
    public static void updateCenter(String name, String location, int capacity, int classrooms, String supervisor, String phone){
        try{        
            Connection con = DatabaseConnectionHandler.getConnection();
            
            String queryCheck = "UPDATE centers "
                    + "SET location= ? , capacity = ? , classrooms = ? , supervisor = ? , phone = ?"
                    + "WHERE name = ?";
            
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, location);
            ps.setInt(2, capacity);
            ps.setInt(3, classrooms);
            ps.setString(4, supervisor);
            ps.setString(5, phone);
            ps.setString(6, name);
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
