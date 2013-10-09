/*
 * A class to assign index numbers to the students
 */
package slmo.centerallocation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import slmo.registration.Student;
import slmo.registration.dao.StudentDA;

/**
 * @author Fiontar
 */

public class AssignIndex {
    
    /**
     * method sorts and assign a unique index to the applicant according to the allocated center
     */
    public void assignIndex(){
        ArrayList<Student> studentList = StudentDA.getAllStudents();
        
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                int center = student1.getAssigned_centre().compareTo(student2.getAssigned_centre());
                if (center != 0) {
                    return center;
                } else {//if the assigned centers are same
                    int CompMed = student1.getMedium().compareTo(student2.getMedium());
                    if (center != 0) {
                        return CompMed;
                    } else {
                        return student1.getName().compareTo(student2.getName());
                    }
                }
            }
        };
        
        Collections.sort(studentList, comparator);
        
        Student student = studentList.get(0);
        int index = 1000;
        StudentDA.update(student, "index", index+"");
        String prevCenter = student.getAssigned_centre();
        
        for(int i=1;i<studentList.size();i++){
            student = studentList.get(i);
            if(student.getAssigned_centre().equals(prevCenter)){
                StudentDA.update(student, "index", ++index+"");
            }
            else{
                index= ((index/500)+1)*500; 
                StudentDA.update(student, "index", ++index+"");
            }
        }
    }
}
