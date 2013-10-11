/*
 * A class that allows to access database with student information
 */
package slmo.registration.dao;

import Database.DatabaseConnectionHandler;
import Mail.sendMail;
import java.sql.*;
import java.util.ArrayList;
import slmo.registration.Student;

/**
 * @author Fiontar
 */

public class StudentDA {
/**
 * method allows to add new students into database
 * @param student student
 */
    public static void addStudent(Student student) {
        try {
            Connection con = DatabaseConnectionHandler.getConnection();

            Statement st = con.createStatement();
            String queryCheck = "INSERT INTO student ("
                    + "name,date,month,year,email,school,school_addr,home_addr,pvt_applicant,phone,medium,preferred_centre,"
                    + "verification"
                    + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getDate());
            ps.setInt(3, student.getMonth());
            ps.setInt(4, student.getYear());
            ps.setString(5, student.getEmail());
            ps.setString(6, student.getSchool());
            ps.setString(7, student.getSchool_addr());
            ps.setString(8, student.getHome_addr());
            ps.setInt(9, student.getPvt_applicant());
            ps.setString(10, student.getPhone());
            ps.setString(11, student.getMedium());
            ps.setString(12, student.getPreferred_centre());
            ps.setString(13, student.getVerification());
            ps.executeUpdate();

            System.out.println("Database updated");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
/**
 * method sends an email to verify the email using student's data in the database
 * @param student student 
 */
    public static void sendVerification(Student student) {
        sendMail.sendmail(student.getEmail(), "Email Verification for SLMC 2014",
                "Thank you for registering for Sri Lanka Mathematics Competition 2013.\n\n"
                + "If you did not register, please ignore this email.\n\n"
                + "Please click the following to verify your email address \n\n\n"
                + "http://localhost:8080/OOSDWeb/EmailConfirmation?id="
                + student.getVerification()
                + "\n\nSri Lanka Mathematics Olympiad Foundation,\n"
                + "Department of Mathematics,\n"
                + "University of Colombo.");

    }
/**
 * method gives the list of students
 * @param pvt is "true" for private applicant "false" for school applicant
 * @return the list of applicants
 */
    private static ArrayList<Student> getStudents(boolean pvt) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        try {
            Connection con = DatabaseConnectionHandler.getConnection();
            Statement st = con.createStatement();

            String queryCheck = "SELECT * FROM student";
            if (pvt == true) {
                queryCheck = "SELECT * FROM student where pvt_applicant=1";
            }

            PreparedStatement ps = con.prepareStatement(queryCheck);

            ResultSet rs = ps.executeQuery();

            Student student;
            while (rs.next()) {
                //retrieving student from database
                student = new Student(
                        rs.getString("name"),
                        rs.getInt("date"),
                        rs.getInt("month"),
                        rs.getInt("year"),
                        rs.getString("email"),
                        rs.getString("school"),
                        rs.getString("school_addr"),
                        rs.getString("home_addr"),
                        rs.getInt("pvt_applicant"),
                        rs.getString("phone"),
                        rs.getString("medium"),
                        rs.getString("preferred_centre"),
                        rs.getString("assigned_classrm"),
                        rs.getInt("indexNum"),
                        rs.getInt("id"),
                        rs.getString("assigned_centre"),
                        rs.getInt("payment"),
                        rs.getInt("marks"),
                        rs.getString("verification"),
                        rs.getInt("verified"),
                        rs.getInt("rank"));
                //adding student to the arrayList
                studentList.add(student);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return studentList;
    }
/**
 * method gives the list of all school applicants
 * @return list of students
 */
    public static ArrayList<Student> getAllStudents() {
        return getStudents(false);
    }
/**
 * method gives the list of all private applicants 
 * @return list of private applicants
 */
    public static ArrayList<Student> getAllPrivateStudents() {
        return getStudents(true);
    }
/**
 * method allows to delete students from database 
 * @param id index of the student to be removed
 */
    public static void deleteStudent(String id) {
        Connection con;

        try {
            con = DatabaseConnectionHandler.getConnection();

            Statement st = con.createStatement();
            String queryCheck = "DELETE FROM student WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, id);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
/**
 * method allows to updates student information in the database
 * @param s student
 * @param name student name
 * @param date date of birth
 * @param month month of birth
 * @param year year of birth
 * @param medium medium
 */
    public static void update(Student s, String name, String date, String month, String year, String medium) {
        try {
            s.setName(name);
            s.setDate(Integer.parseInt(date));
            s.setMonth(Integer.parseInt(month));
            s.setYear(Integer.parseInt(year));
            s.setMedium(medium);

            Connection con = DatabaseConnectionHandler.getConnection();

            String queryCheck = "UPDATE student "
                    + "SET name= ? , date = ? , month = ? , year = ? , medium = ?"
                    + "WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, name);
            ps.setString(2, date);
            ps.setString(3, month);
            ps.setString(4, year);
            ps.setString(5, medium);
            ps.setString(6, s.getId() + "");

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
/**
 * method updates details of the student to assign centers 
 * @param s student
 * @param centre exam center name
 */
    public static void update(Student s, String centre) {
        try {

            Connection con = DatabaseConnectionHandler.getConnection();

            String queryCheck = "UPDATE student "
                    + "SET assigned_centre = ?"
                    + "WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, centre);
            ps.setString(2, s.getId() + "");

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
/**
 * updates details of the student to assign unique index numbers depending on the allocated classroom
 * @param s student 
 * @param index index number
 * @param classroom class room number
 */
    public static void update(Student s, int index, int classroom) {
        try {

            Connection con = DatabaseConnectionHandler.getConnection();

            String queryCheck = "UPDATE student "
                    + "SET assigned_classrm = ? , indexNum = ? "
                    + "WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setInt(1, classroom);
            ps.setInt(2, index);
            ps.setString(3, s.getId() + "");

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void update(Student s,int rank){
        try {
            int id= s.getId();
            Connection con = DatabaseConnectionHandler.getConnection();

            String queryCheck = "UPDATE student "
                    + "SET rank = ? "
                    + "WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setInt(1, rank);
            ps.setInt(2, id);

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    
    }
}