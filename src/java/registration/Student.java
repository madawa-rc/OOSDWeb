/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

import java.sql.Date;

/**
 *
 * @author Madawa
 */
public class Student {
    private int phone;
    private int index;
    private int marks;
    private Date dob;
    private String name;
    private String email;
    private String password;
    private String school;
    private String school_addr;
    private String home_addr;
    private String preferred_centre;
    private String assigned_classrm;
    private String assigned_centre;
    private String award;
    private boolean gender;
    private boolean pvt_applicant;
    private boolean medium;
    private boolean payment;
    private boolean within16;

    public Student(int phone, Date dob, String name, String email, String password, String school, String school_addr, String home_addr, String preferred_centre, boolean gender, boolean pvt_applicant, boolean medium) {
        this.phone = phone;
        this.marks = 0;
        this.dob = dob;
        this.name = name;
        this.email = email;
        this.password = password;
        this.school = school;
        this.school_addr = school_addr;
        this.home_addr = home_addr;
        this.preferred_centre = preferred_centre;
        this.assigned_classrm = null;
        this.assigned_centre = null;
        this.award = null;
        this.gender = gender;
        this.pvt_applicant = pvt_applicant;
        this.medium = medium;
        this.payment = false;
        this.within16 = false;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setPaid() {
        this.payment = true;
    }

    public void setWithin16() {
        this.within16 = true;
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

    public Date getDob() {
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

    public String getPassword() {
        return password;
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

    public boolean isMale() {
        return gender;
    }

    public boolean isSinhala() {
        return medium;
    }

    public boolean isPaid() {
        return payment;
    }

    public boolean isPvt_applicant() {
        return pvt_applicant;
    }

    public boolean isWithin16() {
        return within16;
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
 */