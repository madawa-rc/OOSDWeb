package registration;

import java.sql.Date;


public class Student{
    private String name;
    private Date dob;
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

    public String getDob() {
        return dob;
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


    public int getPhone() {
        return phone;
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

    public boolean isPvt_applicant() {
        return pvt_applicant;
    }

    public boolean isWithin16() {
        return within16;
    }

    public int getId() {
        return id;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setDob(String dob) {
        this.dob = dob;
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

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setPvt_applicant(boolean pvt_applicant) {
        this.pvt_applicant = pvt_applicant;
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

    public void setWithin16(boolean within16) {
        this.within16 = within16;
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