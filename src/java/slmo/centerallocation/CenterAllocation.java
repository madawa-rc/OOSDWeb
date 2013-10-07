/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slmo.centerallocation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        studentList = StudentDA.getAllStudents("pvt");
        schoolList = SchoolDA.getAllSchools();
    }
    
    
    
    public void allocateCenters(){
        int count=0;
        int cmb1max=1000;
        for(int i=0;i<studentList.size();i++)
            if(studentList.get(i).getMedium().equals("TAMIL"))
                count++;
        ArrayList<School> schools = new ArrayList<School>();
        ArrayList<Student> temp;
        for(int i=0;i<schoolList.size();i++){
            boolean found=false;
            temp=schoolList.get(i).getStudentList();
            for(int j=0;j<temp.size();j++)
            {
                if(temp.get(j).getMedium().equals("TAMIL"))
                {
                    found=true;
                    break;
                }
            }
            if(found=true)
                schools.add(schoolList.get(i));
        }
        Comparator<School> comparator = new Comparator<School>(){
        @Override
        public int compare(School s1, School s2) {
            return s1.getStudentList().size()-s2.getStudentList().size();
    
            }

        };
        School temp1;
        Collections.sort(schools,comparator);
        for(int i=0;i<schools.size();i++){
              temp1 = schools.get(i);
              if(temp1.getStudentList().size()<=cmb1max-count){
                  temp1.setAssignedCenter("cmb1");
                  count += temp1.getStudentList().size();
              }
        }
    }

}
