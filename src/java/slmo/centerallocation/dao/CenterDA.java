/*
 * A class that allows to access database with centers' information
 */
package slmo.centerallocation.dao;

import Database.DatabaseConnectionHandler;
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
import slmo.centerallocation.Classroom;
import slmo.centerallocation.ExamCenter;
import slmo.registration.Student;
import slmo.registration.dao.StudentDA;

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
            Connection con = Database.DatabaseConnectionHandler.getConnection();

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
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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
     * method update details of exam centers
     * @param name exam center name
     * @param location location
     * @param capacity capacity
     * @param classrooms number of classrooms
     * @param supervisor supervisor name
     * @param phone contact number
     */
    public static void updateCenter(String name, String location, int capacity, int classrooms, String supervisor, String phone) {
        try {
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
    /**
     * method searches a center by name and return its details
     * @param name center name
     * @return exam center
     */
    public static ExamCenter getCenter(String name) {
        try {
            Connection con = Database.DatabaseConnectionHandler.getConnection();

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
            return center;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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
                    ClassList.add(new Classroom(i + 1, capacity));
                }
                center.setClassroomList(ClassList);
            }
        }
        for (int k = 0; k < studentList.size(); k++) {
            Student student = studentList.get(k);
            center = getCenter(student.getAssigned_centre());
            if (student.getAssigned_classrm() != null) {
                center.addStudent(student);
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
    public static void sort(ExamCenter center){
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if( s1.getIndex()>s2.getIndex()){
                    return 1;
                }
                else
                    return -1;
            }
        };
        ArrayList<Classroom> classroomList = center.getClassroomList();
        for(int i=0;i<classroomList.size();i++)
        {
            Collections.sort(classroomList.get(i).getStudentList(), comparator);
        }
    }
}
