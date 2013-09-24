/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slmo.registration;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class School {
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

    public School(String contactname, String email, String name, String password, String school_addr, String phone, String preferred_centre, int id, int payment, String verification, int verified) {
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

    
    public School(String contactname, String email, String name, String password, String school_addr, String phone, String preferred_centre, String verification) {
        this.contactname = contactname;
        this.email = email;
        this.name = name;
        this.password=password;
        this.school_addr = school_addr;
        this.phone = phone;
        this.preferred_centre = preferred_centre;
        this.verification = verification;
    }
    
    
    public String getName() {
        return contactname;
    }
    public void addStudent(String name, int date, int month, int year, String medium){
        Student student = new Student(name, date, month, year,this.email,this.name,this.school_addr, "private", 0, this.phone, medium,this.preferred_centre,this.verification);
        StudentList.add(student);
    }
    public void setName(String name) {
        this.contactname = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }
    
    public void setSchool(String school) {
        this.name = school;
    }

    public void setSchool_addr(String school_addr) {
        this.school_addr = school_addr;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPreferred_centre(String preferred_centre) {
        this.preferred_centre = preferred_centre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }

    public String getEmail() {
        return email;
    }

    public String getSchool() {
        return name;
    }
    
    public School() {
    }

    public String getPassword() {
        return password;
    }

    public String getContactname() {
        return contactname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStudentList(ArrayList<Student> StudentList) {
        this.StudentList = StudentList;
    }
    
    public String getSchool_addr() {
        return school_addr;
    }

    public String getPhone() {
        return phone;
    }

    public String getPreferred_centre() {
        return preferred_centre;
    }

    public int getId() {
        return id;
    }

    public int getPayment() {
        return payment;
    }

    public String getVerification() {
        return verification;
    }

    public int getVerified() {
        return verified;
    }

    public ArrayList<Student> getStudentList() {
        return StudentList;
    }
    
}