package slmo.registration;

import slmo.registration.dao.StudentDA;
import java.sql.Date;


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

    
    
    public void execute(){ 
        String empty = "";
        System.out.println(getName());
        System.out.println(getPreferred_centre());
        System.out.println(getMedium());
        StudentDA.addStudent(this);
    }
    public void validate(){
       // if(getName().length()==0)
        
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMedium() {
        return medium;
    }
    
    public void setPreferred_centre(String preferred_centre) {
        this.preferred_centre = preferred_centre;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }

    public Date getDob() {
        return dob;
    }

    public int getDate() {
        return date;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPhone() {
        return phone;
    }

    public int getPvt_applicant() {
        return pvt_applicant;
    }

    public String getVerification() {
        return verification;
    }

    public int getWithin16() {
        return within16;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPvt_applicant(int pvt_applicant) {
        this.pvt_applicant = pvt_applicant;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public void setWithin16(int within16) {
        this.within16 = within16;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public void setAssigned_classrm(String assigned_classrm) {
        this.assigned_classrm = assigned_classrm;
    }

    public void setAssigned_centre(String assigned_centre) {
        this.assigned_centre = assigned_centre;
    }
    
    public void setMarks(int marks) {
        this.marks = marks;
    }
    
    public String getAssigned_centre() {
        return assigned_centre;
    }

    public String getAssigned_classrm() {
        return assigned_classrm;
    }

    public String getAward() {
        return award;
    }


    public String getEmail() {
        return email;
    }

    public String getHome_addr() {
        return home_addr;
    }

    public int getIndex() {
        return index;
    }

    public int getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }



    public String getPreferred_centre() {
        return preferred_centre;
    }

    public String getSchool() {
        return school;
    }

    public String getSchool_addr() {
        return school_addr;
    }




    public int getId() {
        return id;
    }

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