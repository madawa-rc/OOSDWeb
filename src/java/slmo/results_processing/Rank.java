/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slmo.results_processing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import slmo.registration.Student;
import slmo.registration.dao.StudentDA;

/**
 *
 * @author Danula
 */
public class Rank {
    
    
    public static void generateRank(){
        ArrayList<Student> studentList =  StudentDA.getAllStudents();
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s2.getMarks() - s1.getMarks();
            }
        };
       Collections.sort(studentList,comparator);
       int prev=200;
       int rank = 1;
       
       for(int i = 0;i<studentList.size();i++){
           int currentMark = studentList.get(i).getMarks();
           if(prev==currentMark){               
           }else{
               rank=i+1;
               prev=currentMark;
           }
           StudentDA.update(studentList.get(i), rank);
       }
    }
}
