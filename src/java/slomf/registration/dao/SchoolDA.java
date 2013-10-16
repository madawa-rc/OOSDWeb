/*
 * A class that allows to access database with school information
 */
package slomf.registration.dao;

import slomf.api.Database.DatabaseConnectionHandler;
import slomf.api.Mail.sendMail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import slomf.registration.School;
import slomf.registration.Student;

/**
 * @author Fiontar
 */

public class SchoolDA  {
 /**
  * method allows to add schools to the database
  * @param school school
  */
    public static void addSchool(School school) {
        try {
            Connection con = DatabaseConnectionHandler.getConnection();
            
            String queryCheck = "INSERT INTO school ("
                    + "contactname,email,name,password,school_addr,phone,preferred_centre,"
                    + "verification"
                    +") VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, school.getName());
            ps.setString(2, school.getEmail());
            ps.setString(3, school.getSchool());
            ps.setString(4, school.getPassword());
            ps.setString(5, school.getSchool_addr());
            ps.setString(6, school.getPhone());
            ps.setString(7, school.getPreferred_centre());
            ps.setString(8, school.getVerification());
            ps.executeUpdate();
            
            sendVerification(school);
            
            
            System.out.println("done");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    /**
     * method sends an email to verify the email using student's data in the database
     * @param school school
     */
    public static void sendVerification(School school){
         sendMail.sendmail(school.getEmail(),"Email Verification for SLMC 2014", 
                 "Thank you for registering for Sri Lanka Mathematics Competition 2013.\n\n"
                 + "If you did not register, please ignore this email.\n\n"
                 + "Please click the following to verify your email address \n\n\n"+
                 "http://localhost:8080/OOSDWeb/EmailConfirmation?id="
                 + school.getVerification()
                 +"\n\nSri Lanka Mathematics Olympiad Foundation,\n"
                 + "Department of Mathematics,\n"
                 + "University of Colombo.");
        
    }
    /**
     * method allows to add schools to the database
     * @param school school
     */
    public static void addStudents(School school){
        ArrayList<Student> studentList = school.getStudentList();
        
        for(int i=0; i<school.getStudentList().size(); i++){
            StudentDA.addStudent(studentList.get(i));
        }
//        for(int i=0;i<school.StudentList.size();i++){
//            StudentDA.addStudent(school.StudentList.get(i));
//        }
    }
    /**
     * method searches school from its email address
     * @param email school email
     * @return school
     */
    public static School getSchool(String email){
        School s = null;
        try {
            Connection con = DatabaseConnectionHandler.getConnection();
            String queryCheck = "SELECT * from school WHERE email = ?";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            rs.next();
            s = new School(
                    rs.getString("contactname"),
                    rs.getString("email"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("school_addr"),
                    rs.getString("phone"),
                    rs.getString("preferred_centre"),
                    rs.getInt("id"),
                    rs.getInt("payment"),
                    rs.getString("verification"),                    
                    rs.getInt("verified")
                    );
            System.out.print(rs.getString(("name")));
            s.setStudentList(getStudents(s));
            
            // SQL query to get school with the email
           
            System.out.println("School gotten from DB");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return s;
    }
    /**
     * method gives the list students in a particular school 
     * @param school school
     * @return list of students in the school 
     */
    public static ArrayList<Student> getStudents(School school){
        //array to store the students
        ArrayList<Student> studentList = new ArrayList<Student>();
        //school
        
        Student student;
        
        Connection con;
        
        try{
            con = DatabaseConnectionHandler.getConnection();
            
            String queryCheck = "SELECT * FROM student WHERE school = ? AND email =?";
            
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, school.getName());
            ps.setString(2, school.getEmail());
      //      ps.setString(2, "0");
            
            ResultSet rs = ps.executeQuery();
            System.out.println("Finding students "+school.getName());
            while(rs.next()){
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
                        rs.getInt("rank")
                        );
                //adding student to the arrayList
                int id=Integer.parseInt(rs.getString("id"));
                student.setId(id);
                studentList.add(student);
                System.out.println("Student found!  "+student.getId()+"  "+student.getName());
            }
            if(studentList.isEmpty())
                System.out.println("Empty");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return studentList;
    }
   /**
    * method allows to delete students from the school
    * @param school school
    * @param student student
    */
    public static void deleteStudent(School school, Student student){
        school.getStudentList().remove(student);
        StudentDA.deleteStudent(student.getId()+"");
    }
    /**
     * method gives a list of all schools
     * @return list of schools
     */
    public static ArrayList<School> getAllSchools(){
        ArrayList<School> schoolList = new ArrayList<School>();
        try{
            Connection con = DatabaseConnectionHandler.getConnection();
            Statement st = con.createStatement();
            
            String queryCheck = "SELECT * FROM school";
            
            PreparedStatement ps = con.prepareStatement(queryCheck);
            
            ResultSet rs = ps.executeQuery();
            
            School school;
            while(rs.next()){
                //retrieving student from database
                school = new School(
                        
                        rs.getString("contactname"), 
                        rs.getString("email"), 
                        rs.getString("name"), 
                        rs.getString("password"), 
                        rs.getString("school_addr"), 
                        rs.getString("phone"), 
                        rs.getString("preferred_centre"), 
                        rs.getInt("id"), 
                        rs.getInt("payment"), 
                        rs.getString("verification"), 
                        rs.getInt("verified")
                            );
                //adding student to the arrayList
                school.setStudentList(SchoolDA.getStudents(school));
                schoolList.add(school);
                
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return schoolList;
    }
    /**
     * method gives the search results for a particular string
     * @param searchString searching string
     * @return list of schools
     */
    public static ArrayList<School> getAllSchools(String searchString){
        System.out.println(searchString);
        ArrayList<School> schoolList = new ArrayList<School>();
        try{
            Connection con = DatabaseConnectionHandler.getConnection();
            Statement st = con.createStatement();
            
            String queryCheck = "SELECT * FROM school WHERE name LIKE '%"+searchString+"%'";
            
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ResultSet rs = ps.executeQuery();
            
            School school;
            while(rs.next()){
                //retrieving student from database
                school = new School(
                        
                        rs.getString("contactname"), 
                        rs.getString("email"), 
                        rs.getString("name"), 
                        rs.getString("password"), 
                        rs.getString("school_addr"), 
                        rs.getString("phone"), 
                        rs.getString("preferred_centre"), 
                        rs.getInt("id"), 
                        rs.getInt("payment"), 
                        rs.getString("verification"), 
                        rs.getInt("verified")
                            );
                //adding student to the arrayList
                school.setStudentList(SchoolDA.getStudents(school));
                schoolList.add(school);
                
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return schoolList;
    }
}



