/**
 * This School class object used to get the data of a school
 */
package slomf.registration;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Fiontar
 */

public class School extends User implements Serializable{
    private String contactname;
    private String email;
    private String name;
    private String password;
    private String school_addr;
    private String phone;
    private String preferred_centre;
    private int id;
    private int payment;
    private String verification;
    private int verified;
    ArrayList<Student> StudentList = new ArrayList<Student>();
    private String assignedCenter;
    /**
     * constructor to enter data of the school
     * @param contactname name of contact
     * @param email email address 
     * @param name school name 
     * @param password password 
     * @param school_addr school address
     * @param phone contact number
     * @param preferred_centre preferred exam centre
     * @param id database index number
     * @param payment amount of payment
     * @param verification verification link 
     * @param verified link verification state
     */
    public School(String contactname, String email, String name, String password, String school_addr, String phone, String preferred_centre, int id, int payment, String verification, int verified) {
        super("schoolDashboard.jsp", name);
        this.contactname = contactname;
        this.email = email;
        this.name = name;
        this.password = password;
        this.school_addr = school_addr;
        this.phone = phone;
        this.preferred_centre = preferred_centre;
        this.id = id;
        this.payment = payment;
        this.verification = verification;
        this.verified = verified;
    }
    /**
     * constructor to enter data of the school 
     * @param contactname name of contact
     * @param email email address
     * @param name school name
     * @param password password
     * @param school_addr school address
     * @param phone contact number
     * @param preferred_centre preferred exam centre
     * @param verification verification link
     */
    public School(String contactname, String email, String name, String password, String school_addr, String phone, String preferred_centre, String verification) {
        super("schoolDashboard.jsp", name);
        this.contactname = contactname;
        this.email = email;
        this.name = name;
        this.password=password;
        this.school_addr = school_addr;
        this.phone = phone;
        this.preferred_centre = preferred_centre;
        this.verification = verification;
    }
    /**
     * method gives the name of the contact person
     * @return name of contact
     */
    @Override
    public String getName() {
        return name;
    }
    /**
     * method that allows to add students in the school
     * @param name student name
     * @param date date of birth
     * @param month birth month
     * @param year birth year
     * @param medium preferred medium
     */
    public Student addStudent(String name, int date, int month, int year, String medium){
        Student student = new Student(name, date, month, year,this.email,this.name,this.school_addr, "private", 0, this.phone, medium,this.preferred_centre,this.verification);
        StudentList.add(student);
        System.out.println(this.name);
        return student;
    }
    /**
     * method sets the name of the contact person
     * @param name name of contact
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * method sets the name of the contact person for the school
     * @param contactname name of contact
     */
    public void setContactname(String contactname) {
        this.contactname = contactname;
    }
    /**
     * method gives the name of the contact person 
     * @return name of contact
     */
    public String getContactname() {
        return contactname;
    }
    /**
     * method gives the school name
     * @return school name
     */
    public String getSchool() {
        return name;
    }
    /**
     * method sets the school name 
     * @param school school name 
     */
    public void setSchool(String school) {
        this.name = school;
    }
    /**
     * method sets the email address of the school
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * method sets the school address
     * @param school_addr school address
     */
    public void setSchool_addr(String school_addr) {
        this.school_addr = school_addr;
    }
    /**
     * method sets contact number of the school
     * @param phone contact number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * method set the preferred exam center of the applicant
     * @param preferred_centre preferred exam centre
     */
    public void setPreferred_centre(String preferred_centre) {
        this.preferred_centre = preferred_centre;
    }
    /**
     * method sets the related database index number 
     * @param id database index number
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * method sets the due amount of payment to the applicant 
     * @param payment amount of payment
     */
    public void setPayment(int payment) {
        this.payment = payment;
    }
    /**
     * method sets the verification link
     * @param verification verification link
     */
    public void setVerification(String verification) {
        this.verification = verification;
    }
    /**
     * method sets whether the email has verified or not
     * @param verified link verification state
     */
    public void setVerified(int verified) {
        this.verified = verified;
    }
    /**
     * method gives the email address of the school
     * @return email address
     */
    public String getEmail() {
        return email;
    }
    /**
     * method gives the password of the school
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * method sets a unique password to the school
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * method sets the list of students in the school
     * @param StudentList list of student
     */
    public void setStudentList(ArrayList<Student> StudentList) {
        this.StudentList = StudentList;
    }
    /**
     * method gives the school address 
     * @return school address
     */
    public String getSchool_addr() {
        return school_addr;
    }
    /**
     * method gives contact number of the school
     * @return contact number
     */
    public String getPhone() {
        return phone;
    }
    /**
     * method gives the preferred exam centre of the applicant 
     * @return preferred exam centre
     */
    public String getPreferred_centre() {
        return preferred_centre;
    }
    /**
     * method gives the index number in database
     * @return database index number
     */
    public int getId() {
        return id;
    }
    /**
     * method gives the due amount of payment of the applicant
     * @return amount of payment
     */
    public int getPayment() {
        return payment;
    }
    /**
     * method gives the email verification link 
     * @return verification link
     */
    public String getVerification() {
        return verification;
    }
    /**
     * method gives state of verified parameter
     * @return link verification state
     */
    public int getVerified() {
        return verified;
    }
    /**
     * method gives the list of students in the school
     * @return list of student
     */
    public ArrayList<Student> getStudentList() {
        return StudentList;
    }   
/**
 * method assigns a center for the applicant
 * @param center center name
 */
    public void setAssignedCenter(String center) {
        this.assignedCenter = center;
    }
    
}
