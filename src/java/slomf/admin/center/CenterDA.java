/*
 * A class that allows to access database with centers' information
 */
package slomf.admin.center;

import slomf.api.Database.DatabaseConnectionHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import slomf.registration.School;
import slomf.registration.Student;
import slomf.registration.dao.StudentDA;

/**
 * @author Fiontar
 */

public class CenterDA {
    /**
     * method gives an array of exam centers
     * @return list of exam centers
     */
    public static ArrayList<ExamCenter> getAllCenters() {
        ArrayList<ExamCenter> examCenterList = new ArrayList<ExamCenter>();
        try {
            Connection con = slomf.api.Database.DatabaseConnectionHandler.createConnection();

            String queryCheck = "SELECT * FROM centers";

            PreparedStatement ps = con.prepareStatement(queryCheck);

            ResultSet rs = ps.executeQuery();

            ExamCenter center;
            while (rs.next()) {
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
            con.close();
        } catch (SQLException ex) {
            slomf.admin.Log.addLog(ex.getMessage());
        }
        Comparator<ExamCenter> comparator = new Comparator<ExamCenter>() {
            @Override
            public int compare(ExamCenter e1, ExamCenter e2) {
                return e1.getCenterName().compareTo(e2.getCenterName());
            }
        };
        Collections.sort(examCenterList, comparator);
        return examCenterList;
    }
    /**
     * method updateStudents details of exam centers
     * @param name exam center name
     * @param location location
     * @param capacity capacity
     * @param classrooms number of classrooms
     * @param supervisor supervisor name
     * @param phone contact number
     */
    public static void updateCenter(String name, String location, int capacity, int classrooms, String supervisor, String phone) {
        try {
            Connection con = DatabaseConnectionHandler.createConnection();

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
             con.close();
        } catch (SQLException ex) {
            slomf.admin.Log.addLog(ex.getMessage());
        }
    }
    /**
     * method searches a center by name and return its details
     * @param name center name
     * @return exam center
     */
    public static ExamCenter getCenter(String name) {
        try {
            Connection con = slomf.api.Database.DatabaseConnectionHandler.createConnection();

            String queryCheck = "SELECT * FROM centers WHERE name=?";

            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            ExamCenter center = null;

            while (rs.next()) {
                //retrieving center from database
                center = new ExamCenter(
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getInt("capacity"),
                        rs.getInt("classrooms"),
                        rs.getString("supervisor"),
                        rs.getString("phone"));
                //adding center to the arrayList

            }
            con.close();
            return center;
        } catch (SQLException ex) {
            slomf.admin.Log.addLog(ex.getMessage());
        }
        return null;
    }
    public static ArrayList<ExamCenter> getAllPopulatedCenters() {
        ArrayList<ExamCenter> centerList = getAllCenters();
        ArrayList<Student> studentList = StudentDA.getAllStudents();
        ExamCenter center;
        for (int i = 0; i < centerList.size(); i++) {
            center = centerList.get(i);
            if (center != null && center.getClassrooms() != 0 && center.getCapacity() != 0) {
                int capacity = center.getCapacity() / center.getClassrooms();

                ArrayList<Classroom> ClassList = new ArrayList<Classroom>();
                for (int j = 0; j < center.getClassrooms(); j++) {
                    ClassList.add(new Classroom(j + 1, capacity));
                }
                center.setClassroomList(ClassList);
            }
        }
        for (int k = 0; k < studentList.size(); k++) {
            Student student = studentList.get(k);
            center = get(centerList,student.getAssigned_centre());
       //     slomf.admin.Log.addLog(center.getClassrooms()+"asd"+center.getCenterName()+"  "+center.getClassroomList().size());
            if (student.getAssigned_classrm() != null&&!student.getAssigned_classrm().startsWith("0")) {
                center.addStudent(student);
            }
        }
        for(int i=0;i<centerList.size();i++){
            
            ArrayList<Classroom> classroomList = centerList.get(i).getClassroomList();
            for(int j=0;j<classroomList.size();j++)
            {
                classroomList.get(j).sort();
            }
        }
        return centerList;
    }
   
    private static ExamCenter get(ArrayList<ExamCenter> list, String center) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCenterName().equals(center)) {
                return list.get(i);
            }
        }
        return null;
    }
    public static void updateStudents(String pref, String assign){
     try {

            Connection con = DatabaseConnectionHandler.getConnection();

            String queryCheck = "UPDATE student "
                    + "SET assigned_centre = ? "
                    + "WHERE preferred_centre = ?";

            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, assign);
            ps.setString(2, pref);
            ps.executeUpdate();
        } catch (SQLException ex) {
            slomf.admin.Log.addLog(ex.getMessage());
        }   
    }
    public static void updateStudents(String pref, String assign, String medium){
     try {

            Connection con = DatabaseConnectionHandler.getConnection();

            String queryCheck = "UPDATE student "
                    + "SET assigned_centre = ? "
                    + "WHERE preferred_centre = ? AND medium = ?";

            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, assign);
            ps.setString(2, pref);
            ps.setString(3, medium);
            ps.executeUpdate();
        } catch (SQLException ex) {
            slomf.admin.Log.addLog(ex.getMessage());
        }   
    }
    public static void updateStudents(String assign, School s){
     try {

            Connection con = DatabaseConnectionHandler.getConnection();

            String queryCheck = "UPDATE student "
                    + "SET assigned_centre = ? "
                    + "WHERE school = ? AND email = ?";

            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, assign);
            ps.setString(2, s.getName());
            ps.setString(3, s.getEmail());
            ps.executeUpdate();
        } catch (SQLException ex) {
            slomf.admin.Log.addLog(ex.getMessage());
        }   
    }
    public static int getNumberOfPrivateStudents(String center){
        try {

            Connection con = DatabaseConnectionHandler.getConnection();

            String queryCheck = "SELECT COUNT(*) from student "
                    + "WHERE preferred_centre = ? AND "
                    + "pvt_applicant = 1";

            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, center);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count;
            }
        } catch (SQLException ex) {
            slomf.admin.Log.addLog(ex.getMessage());
        }  
        return -1;
    }
}
