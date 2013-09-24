/**
 * This Student class object used to get the data of an applicant
 */
package slmo.registration;

import slmo.registration.dao.StudentDA;
import java.sql.Date;

/**
 * @author Fiontar
 */

public class Student{
    private String name;
    private Date dob;
    private int date;
    private int month;
    private int year;
    private String email;
    private String school;
    private String school_addr;
    private String home_addr;
    private int pvt_applicant;
    private String phone;
    private String medium;
    private String preferred_centre;
    private String assigned_classrm;
    private int index;
    private int id;
    private String assigned_centre;
    private int payment;
    private int marks;
    private String award;    
    private int within16; 
    private String verification;
    private int schoolId;
    private int verified;
    /**
     * constructor to enter data of the student
     * @param name name of the student
     * @param date date of birth
     * @param month month of birth
     * @param year year of birth
     * @param email email address 
     * @param school school name
     * @param school_addr address of school
     * @param home_addr home address
     * @param pvt_applicant whether a private applicant or a school applicant
     * @param phone contact number
     * @param medium preferred examination medium
     * @param preferred_centre preferred exam centre
     * @param verification verification link 
     */
    public Student(String name, int date, int month, int year, String email, String school, String school_addr, String home_addr, int pvt_applicant, String phone, String medium, String preferred_centre, String verification) {
        this.name = name;
     //   this.dob = dob;
        this.date = date;
        this.month = month;
        this.year = year;
        this.email = email;
        this.school = school;
        this.school_addr = school_addr;
        this.home_addr = home_addr;
        this.pvt_applicant = pvt_applicant;
        this.phone = phone;
        this.medium = medium;
        this.preferred_centre = preferred_centre;
        this.verification=verification;
    }
    /**
     * Default constructor 
     */
    public Student(){
        
    }
    public void validate(){
       // if(getName().length()==0)    
    }
    /**
     * method sets the input email address of the applicant
     * @param email email address 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * method gives the medium of the applicant 
     * @return preferred examination medium
     */
    public String getMedium() {
        return medium;
    }
    /**
     * method set the preferred exam center of the applicant
     * @param preferred_centre preferred exam centre
     */
    public void setPreferred_centre(String preferred_centre) {
        this.preferred_centre = preferred_centre;
    }
    /**
     * method sets the index number of the applicant
     * @param index index number
     */
    public void setIndex(int index) {
        this.index = index;
    }
    /**
     * method gives state of verified parameter
     * @return link verification state
     */
    public int getVerified() {
        return verified;
    }
    /**
     * method sets whether the email has verified or not
     * @param verified link verification state
     */
    public void setVerified(int verified) {
        this.verified = verified;
    }
    /**
     * method gives the birthday of the applicant
     * @return date of birth
     */
    public Date getDob() {
        return dob;
    }
    /**
     * method gives the date of birth
     * @return date of birth
     */
    public int getDate() {
        return date;
    }
    /**
     * method gives the birth month
     * @return month of birth 
     */
    public int getMonth() {
        return month;
    }
    /**
     * method gives the birth year
     * @return year of birth
     */
    public int getYear() {
        return year;
    }
    /**
     * method sets the date of birth
     * @param date date of birth
     */
    public void setDate(int date) {
        this.date = date;
    }
    /**
     * method sets the birth month
     * @param month month of birth
     */
    public void setMonth(int month) {
        this.month = month;
    }
    /**
     * method sets the birth year
     * @param year year of birth
     */
    public void setYear(int year) {
        this.year = year;
    }
    /**
     * method gives the contact number of the applicant
     * @return contact number
     */
    public String getPhone() {
        return phone;
    }
    /**
     * method gives 1 for a private applicant and 0 for a school applicant
     * @return whether a private applicant or a school applicant
     */
    public int getPvt_applicant() {
        return pvt_applicant;
    }
    /**
     * method gives the email verification link 
     * @return verification link
     */
    public String getVerification() {
        return verification;
    }
    /**
     * method gives 1 if the applicant is within 16 years, else return 0  
     * @return where the applicant is within the 16 years range
     */
    public int getWithin16() {
        return within16;
    }
    /**
     * method sets the birthday of the applicant
     * @param dob birthday
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }
    /**
     * method sets the contact number of the applicant
     * @param phone contact number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * method sets whether the applicant is a whether a private applicant or a school applicant 
     * @param pvt_applicant whether a private applicant or a school applicant
     */
    public void setPvt_applicant(int pvt_applicant) {
        this.pvt_applicant = pvt_applicant;
    }
    /**
     * method sets the verification link
     * @param verification verification link
     */
    public void setVerification(String verification) {
        this.verification = verification;
    }
    /**
     * method sets the examination medium of the applicant
     * @param medium preferred examination medium
     */
    public void setMedium(String medium) {
        this.medium = medium;
    }
    /**
     * method sets the name of the applicant
     * @param name name of the applicant
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * method sets 1 if the applicant is within 16 years range, else set 0 
     * @param within16 whether the applicant is within 16 years range
     */
    public void setWithin16(int within16) {
        this.within16 = within16;
    }
    /**
     * method sets awards to applicants if he/she is reworded with any 
     * @param award awards won by the applicant
     */
    public void setAward(String award) {
        this.award = award;
    }
    /**
     * method sets the allocated class room name
     * @param assigned_classrm assigned class room name
     */
    public void setAssigned_classrm(String assigned_classrm) {
        this.assigned_classrm = assigned_classrm;
    }
    /**
     * method sets allocated exam centre to the applicant
     * @param assigned_centre assigned exam centre 
     */
    public void setAssigned_centre(String assigned_centre) {
        this.assigned_centre = assigned_centre;
    }
    /**
     * method sets final exam marks to the applicant 
     * @param marks final exam marks
     */
    public void setMarks(int marks) {
        this.marks = marks;
    }
    /**
     * method gives the assigned centre of the applicant
     * @return assigned centre 
     */
    public String getAssigned_centre() {
        return assigned_centre;
    }
    /**
     * method gives the assigned class room to the applicant
     * @return assigned class room
     */
    public String getAssigned_classrm() {
        return assigned_classrm;
    }
    /**
     * method gives the awards won by the applicant
     * @return awards won by the applicant
     */
    public String getAward() {
        return award;
    }
    /**
     * method gives the email address of the applicant
     * @return email address
     */
    public String getEmail() {
        return email;
    }
    /**
     * method gives the home address of the applicant
     * @return home address
     */
    public String getHome_addr() {
        return home_addr;
    }
    /**
     * method gives the index number of the applicant
     * @return index number
     */
    public int getIndex() {
        return index;
    }
    /**
     * method gives the final results marks of the applicant
     * @return final exam marks
     */
    public int getMarks() {
        return marks;
    }
    /**
     * method gives the name of the applicant
     * @return applicant's name
     */
    public String getName() {
        return name;
    }
    /**
     * method gives the preferred exam centre of the applicant 
     * @return preferred exam centre
     */
    public String getPreferred_centre() {
        return preferred_centre;
    }
    /**
     * method gives the school name of the student
     * @return school name
     */
    public String getSchool() {
        return school;
    }
    /**
     * method gives the school address 
     * @return school address
     */
    public String getSchool_addr() {
        return school_addr;
    }
    /**
     * method gives the index number in database
     * @return database index number
     */
    public int getId() {
        return id;
    }
    /**
     * method gives the school i
     * @return 
     */
    public int getSchoolId() {
        return schoolId;
    }

    public void setHome_addr(String home_addr) {
        this.home_addr = home_addr;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public void setSchool_addr(String school_addr) {
        this.school_addr = school_addr;
    }

    public int getPayment() {
        return payment;
    }
    
}

/*
 *
Field	Type	Collation	Attributes	Null	Default	Extra	Action
	name	text	utf8_general_ci		No			 Browse distinct values	 Change	 Drop	Primary	Unique	Index	 Fulltext
	dob	date			No			 Browse distinct values	 Change	 Drop	 Primary	 Unique	 Index	Fulltext
	email	text	utf8_general_ci		No			 Browse distinct values	 Change	 Drop	Primary	Unique	Index	 Fulltext
	password	text	utf8_general_ci		No			 Browse distinct values	 Change	 Drop	Primary	Unique	Index	 Fulltext
	gender	tinyint(1)			No			 Browse distinct values	 Change	 Drop	 Primary	 Unique	 Index	Fulltext
	school	text	utf8_general_ci		No			 Browse distinct values	 Change	 Drop	Primary	Unique	Index	 Fulltext
	school_addr	text	utf8_general_ci		No			 Browse distinct values	 Change	 Drop	Primary	Unique	Index	 Fulltext
	home_addr	text	utf8_general_ci		No			 Browse distinct values	 Change	 Drop	Primary	Unique	Index	 Fulltext
	pvt_applicant	tinyint(1)			No			 Browse distinct values	 Change	 Drop	 Primary	 Unique	 Index	Fulltext
	phone	int(11)			No			 Browse distinct values	 Change	 Drop	 Primary	 Unique	 Index	Fulltext
	medium	text	utf8_general_ci		No			 Browse distinct values	 Change	 Drop	Primary	Unique	Index	 Fulltext
	preferred_centre	text	utf8_general_ci		No			 Browse distinct values	 Change	 Drop	Primary	Unique	Index	 Fulltext
	assigned_classrm	text	utf8_general_ci		No			 Browse distinct values	 Change	 Drop	Primary	Unique	Index	 Fulltext
	index	int(11)			No			 Browse distinct values	 Change	 Drop	 Primary	 Unique	 Index	Fulltext
	assigned_centre	text	utf8_general_ci		No			 Browse distinct values	 Change	 Drop	Primary	Unique	Index	 Fulltext
	payment	tinyint(1)			No			 Browse distinct values	 Change	 Drop	 Primary	 Unique	 Index	Fulltext
	marks	int(11)			No			 Browse distinct values	 Change	 Drop	 Primary	 Unique	 Index	Fulltext
	award	text	utf8_general_ci		No			 Browse distinct values	 Change	 Drop	Primary	Unique	Index	 Fulltext
	within16
>>>>>>> updated fields:src/java/registration/Student.java
 */