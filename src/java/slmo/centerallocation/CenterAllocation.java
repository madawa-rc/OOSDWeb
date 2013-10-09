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
        studentList = StudentDA.getAllPrivateStudents();
        schoolList = SchoolDA.getAllSchools();
    }

    public void allocateCenters() {
        int countCMB1 = 0;
        int countCMB2 = 0;
        int cmb1max = 1000;
        int cmb2max = 1000;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getMedium().equals("TAMIL")) {
                StudentDA.update(studentList.get(i), "COLOMBO1");       //assign all tamil pvt candidates to colombo1
                countCMB1++;
            }
        }
        ArrayList<School> schoolsT = new ArrayList<School>();        //array of schools with tamil students
        ArrayList<School> schoolsES = new ArrayList<School>();       //array of schools with only sinhala and english
        ArrayList<Student> students;
        for (int i = 0; i < schoolList.size(); i++) {
            boolean found = false;                                  //boolean whether there are tamil students
            students = schoolList.get(i).getStudentList();
            countCMB1 += students.size();
            for (int j = 0; j < students.size(); j++) {
                if (students.get(j).getMedium().equals("TAMIL")) {
                    found = true;
                    break;
                }
            }
            if (found = true) {
                schoolsT.add(schoolList.get(i));                     //filter out schools with tamil students
            } else {
                schoolsES.add(schoolList.get(i));
            }
        }
        //schools is a list of schools with Tamil students
        Comparator<School> comparator = new Comparator<School>() {
            @Override
            public int compare(School s1, School s2) {
                return s1.getStudentList().size() - s2.getStudentList().size();
            }
        };
        School school;
        Collections.sort(schoolsT, comparator);
        for (int i = schoolsT.size() - 1; i >= 0; i--) {
            school = schoolsT.get(i);
            students = school.getStudentList();
            int tempCount = countCMB1;
            for (int j = 0; j < students.size(); j++) {
                if (students.get(j).getMedium().equals("TAMIL")) {
                    StudentDA.update(students.get(j), "COLOMBO1");      //assign all tamil students to colombo1
                } else {
                    if (tempCount > cmb1max) {
                        StudentDA.update(students.get(j), "COLOMBO2");   //assign other students to colombo2 if over capacity
                        countCMB1--;
                        countCMB2++;
                    } else {
                        StudentDA.update(students.get(j), "COLOMBO1");  //else assign to colombo1
                    }
                }
            }
        }
        //Assign all the private sinhala and english students
        Collections.sort(schoolsES, comparator);
        for (int i = schoolsES.size() - 1; i >= 0; i--) {
            students = schoolsES.get(i).getStudentList();
            if (countCMB2 + students.size() <= cmb2max) {
                for (int j = 0; j < students.size(); j++) {
                    StudentDA.update(students.get(j), "COLOMBO2");
                }
            } else {
                for (int j = 0; j < students.size(); j++) {
                    StudentDA.update(students.get(j), "COLOMBO1");
                }
            }
        }
        for (int i = 0; i < studentList.size(); i++) {
            if (!studentList.get(i).getMedium().equals("TAMIL")) {
                if (countCMB2 + 1 < cmb2max) {
                    StudentDA.update(studentList.get(i), "COLOMBO2");
                } else {
                    StudentDA.update(studentList.get(i), "COLOMBO1");
                }
            }
        }


    }
}
