/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slmo.centerallocation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import slmo.centerallocation.dao.CenterDA;
import slmo.registration.School;
import slmo.registration.Student;
import slmo.registration.dao.SchoolDA;
import slmo.registration.dao.StudentDA;

/**
 *
 * @author Danula
 */
public class CenterAllocation {

    public static int[][] getPreferredCenterStats() {
        String[] preferredCenters = {"COLOMBO", "GALLE", "JAFFNA", "KANDY", "KURUNEGALA", "MATARA", "TRINCOMALEE"};
        String queryCheck = "SELECT COUNT(*) FROM student WHERE preferred_centre=? AND medium = ?";
        return getCenterStatistics(preferredCenters, queryCheck);
    }

    public static int[][] getAssignedCenterStats() {
        String[] assignedCenters = {"COLOMBO1", "COLOMBO2", "GALLE", "JAFFNA", "KANDY", "KURUNEGALA", "MATARA", "TRINCOMALEE"};
        String queryCheck = "SELECT COUNT(*) FROM student WHERE assigned_centre=? AND medium = ?";
        return getCenterStatistics(assignedCenters, queryCheck);
    }

    private static int[][] getCenterStatistics(String[] centers, String queryCheck) {
        String[] medium = {"SINHALA", "ENGLISH", "TAMIL"};
        int[][] output = new int[centers.length][3];
        try {
            Connection con = Database.DatabaseConnectionHandler.getConnection();



            PreparedStatement ps = con.prepareStatement(queryCheck);

            for (int i = 0; i < centers.length; i++) {
                for (int j = 0; j < 3; j++) {
                    ps.setString(1, centers[i]);
                    ps.setString(2, medium[j]);
                    ResultSet rs = ps.executeQuery();

                    output[i][j] = rs.getInt(1);

                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return output;
    }

    public static void allocateCenters() {
        ArrayList<Student> studentList = StudentDA.getAllPrivateStudents();
        ArrayList<School> schoolList = SchoolDA.getAllSchools();

        int countCMB1 = 0;
        int countCMB2 = 0;
        int cmb1max = 1000;
        int cmb2max = 1000;
        Student tempStudent;
        for (int i = 0; i < studentList.size(); i++) {
            tempStudent = studentList.get(i);
            if (tempStudent.getPreferred_centre().equals("COLOMBO")) {
                if (tempStudent.getMedium().equals("TAMIL")) {
                    StudentDA.update(tempStudent, "COLOMBO1");       //assign all tamil pvt candidates to colombo1
                    countCMB1++;
                }
            } else {
                StudentDA.update(tempStudent, tempStudent.getPreferred_centre());
            }

        }
        ArrayList<School> schoolsT = new ArrayList<School>();        //array of schools with tamil students
        ArrayList<School> schoolsES = new ArrayList<School>();       //array of schools with only sinhala and english
        ArrayList<Student> students;
        for (int i = 0; i < schoolList.size(); i++) {
            if (schoolList.get(i).getPreferred_centre().equals("COLOMBO")) {
                boolean found = false;                                 //boolean whether there are tamil students
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
            } else {
                students = schoolList.get(i).getStudentList();
                for (int j = 0; j < students.size(); j++) {
                    StudentDA.update(students.get(j), students.get(j).getPreferred_centre());
                }
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
        //Assign all the schools with no tamil students.
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
        //Assign all the private sinhala and english students
        for (int i = 0; i < studentList.size(); i++) {
            if (!studentList.get(i).getMedium().equals("TAMIL") && studentList.get(i).getPreferred_centre().equals("COLOMBO")) {
                if (countCMB2 + 1 < cmb2max) {
                    StudentDA.update(studentList.get(i), "COLOMBO2");
                } else {
                    StudentDA.update(studentList.get(i), "COLOMBO1");
                }
            }
        }
    }

    public static void assignIndex() {
        ArrayList<Student> studentList = StudentDA.getAllStudents();
        ArrayList<ExamCenter> centerList = CenterDA.getAllCenters();

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

        Student student;
        int index = 500;
        ExamCenter center;
        String prevCenter = "new";
        int classRoomNum = 0;
        int count = 0;
        int capacity = 0;

        for (int i = 0; i < studentList.size(); i++) {
            student = studentList.get(i);
            System.out.println("list "+student.getName()+"  "+student.getAssigned_centre());
            if (student.getAssigned_centre().equals(prevCenter)) {
                count++;
                if (count > capacity) {
                    classRoomNum++;
                    count = 1;
                }
                StudentDA.update(student, ++index, classRoomNum);
            } else {
                index = ((index / 500) + 1) * 500;
                classRoomNum = 1;
                count = 1;
                center = get(centerList, student.getAssigned_centre());
                prevCenter = center.getCenterName();
                capacity = center.getCapacity() / center.getClassrooms();
                //System.out.println(student.getAssigned_centre());
                StudentDA.update(student, index, classRoomNum);
            }
        }
    }

    private static ExamCenter get(ArrayList<ExamCenter> list, String center) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCenterName().equals(center)) {
                return list.get(i);
            }
        }
        return null;
    }
}
