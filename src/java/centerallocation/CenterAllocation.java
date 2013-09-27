/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package centerallocation;

import java.util.ArrayList;
import slmo.registration.School;
import slmo.registration.Student;
import slmo.registration.dao.SchoolDA;
import slmo.registration.dao.StudentDA;

/**
 *
 * @author Danula
 */
public class CenterAllocation {
    ArrayList<ExamCenter> centerList;
    ArrayList<Student> studentList;
    ArrayList<School> schoolList;
    public CenterAllocation() {
    centerList = new ArrayList<ExamCenter>();
    studentList = StudentDA.getAllStudents();
    schoolList = SchoolDA.getAllSchools();
    }
    
    
}
