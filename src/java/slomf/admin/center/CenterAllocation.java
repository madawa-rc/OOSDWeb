/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slomf.admin.center;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import slomf.registration.School;
import slomf.registration.Student;
import slomf.registration.dao.SchoolDA;
import slomf.registration.dao.StudentDA;

/**
 *
 * @author Danula
 */
public class CenterAllocation {

    public static String[] preferredCenters = {"COLOMBO", "GALLE", "JAFFNA", "KANDY", "KURUNEGALA", "MATARA", "TRINCOMALEE"};
    public static String[] assignedCenters = {"COLOMBO1", "COLOMBO2", "GALLE", "JAFFNA", "KANDY", "KURUNEGALA", "MATARA", "TRINCOMALEE"};

    public static int[][] getPreferredCenterStats() {

        String queryCheck = "SELECT COUNT(*) FROM student WHERE preferred_centre=? AND medium = ?";
        return getCenterStatistics(preferredCenters, queryCheck);
    }

    public static int[][] getAssignedCenterStats() {
        String queryCheck = "SELECT COUNT(*) FROM student WHERE assigned_centre=? AND medium = ?";
        return getCenterStatistics(assignedCenters, queryCheck);
    }

    private static int[][] getCenterStatistics(String[] centers, String queryCheck) {
        String[] medium = {"SINHALA", "ENGLISH", "TAMIL"};
        int[][] output = new int[centers.length + 1][4];
        try {
            Connection con = slomf.api.Database.DatabaseConnectionHandler.createConnection();
            PreparedStatement ps = con.prepareStatement(queryCheck);
            for (int i = 0; i < centers.length; i++) {
                for (int j = 0; j < 3; j++) {
                    ps.setString(1, centers[i]);
                    ps.setString(2, medium[j]);
                    ResultSet rs = ps.executeQuery();
                    rs.next();
                    output[i][j] = rs.getInt(1);

                }
                output[i][3] = output[i][0] + output[i][1] + output[i][2];
                // output[centers.length][0]+= output[i][0];
                for (int j = 0; j < 4; j++) {
                    output[centers.length][j] += output[i][j];
                }
            }
            con.close();
        } catch (SQLException ex) {
            slomf.admin.Log.addLog(ex.getMessage());
        }
        return output;
    }

    public static void allocateCenters() {

        slomf.admin.Log.addLog("Allocating Centers");
        ArrayList<ExamCenter> centers = CenterDA.getAllCenters();
        String CMB1Location = "";
        String CMB2Location = "";
        int CMB1Max = 1000;
        int CMB2Max = 1000;
        for (int i = 0; i < centers.size(); i++) {
            if (centers.get(i).getCenterName().equals("COLOMBO2")) {
                CMB2Location = centers.get(i).getLocation();
                CMB2Max = centers.get(i).getCapacity();
            } else if (centers.get(i).getCenterName().equals("COLOMBO1")) {
                CMB1Location = centers.get(i).getLocation();
                CMB1Max = centers.get(i).getCapacity();
            } else {
                CenterDA.updateStudents(centers.get(i).getCenterName(), centers.get(i).getLocation());
            }
        }
        CenterDA.updateStudents("COLOMBO", CMB1Location, "TAMIL");
        CenterDA.updateStudents("COLOMBO", CMB2Location, "ENGLISH");
        CenterDA.updateStudents("COLOMBO", CMB2Location, "SINHALA");

        ArrayList<Student> studentList = StudentDA.getAllPrivateStudents();
        ArrayList<School> schoolList = SchoolDA.getAllSchools();

        int countCMB1 = 0;
        int countCMB2 = 0;

        Student tempStudent;
        for (int i = 0; i < studentList.size(); i++) {
            tempStudent = studentList.get(i);
            if (tempStudent.getPreferred_centre().equals("COLOMBO")) {
                if (tempStudent.getMedium().equals("TAMIL")) {
                    //         StudentDA.update(tempStudent, "COLOMBO1");       //assign all tamil pvt candidates to colombo1
                    countCMB1++;
                }
            } else {
                // StudentDA.updateStudents(tempStudent, tempStudent.getPreferred_centre());
            }
        }
        slomf.admin.Log.addLog("All Private Students except Colombo Centres Assigned");
        slomf.admin.Log.addLog("Tamil private applicants in Colombo assigned");
        ArrayList<School> schoolsT = new ArrayList<School>();        //array of schools with tamil students
        ArrayList<School> schoolsES = new ArrayList<School>();       //array of schools with only sinhala and english
        ArrayList<Student> students;
        for (int i = 0; i < schoolList.size(); i++) {
            if (schoolList.get(i).getPreferred_centre().equals("COLOMBO")) {
                boolean found = false;                                 //boolean whether there are tamil students
                students = schoolList.get(i).getStudentList();
                for (int j = 0; j < students.size(); j++) {
                    if (students.get(j).getMedium().equals("TAMIL")) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    schoolsT.add(schoolList.get(i));                     //filter out schools with tamil students
                    countCMB1 += students.size();
                } else {
                    schoolsES.add(schoolList.get(i));
                }
            } 
            //else {
            //            students = schoolList.get(i).getStudentList();
            //            for (int j = 0; j < students.size(); j++) {
            //                 StudentDA.update(students.get(j), students.get(j).getPreferred_centre());
            //}
        }
        slomf.admin.Log.addLog("Applicants except Colombo assigned");
        //schoolsT is a list of schools with Tamil students
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
            boolean divided = false;
            for (int j = 0; j < students.size(); j++) {
                if (students.get(j).getMedium().equals("TAMIL")) {
                    //        StudentDA.update(students.get(j), "COLOMBO1");      //assign all tamil students to colombo1
                } else {
                    if (tempCount > CMB1Max) {
                        //     StudentDA.updateStudents(students.get(j), "COLOMBO2");   //assign other students to colombo2 if over capacity
                        countCMB1--;
                        countCMB2++;
                        divided = true;

                    } else {
                        //     StudentDA.update(students.get(j), CMB1Location);  //else assign to colombo1
                    }
                }
            }
            if (divided) {
                slomf.admin.Log.addLog("School divided into 2 " + school.getName() + "  " + school.getStudentList().size());
            } else {
                CenterDA.updateStudents(CMB1Location, school);
            }
        }
        slomf.admin.Log.addLog("Applicants in Colombo with Tamil Students assigned");

        //Assign all the schools with no tamil students.
        Collections.sort(schoolsES, comparator);
        for (int i = schoolsES.size() - 1; i >= 0; i--) {
            students = schoolsES.get(i).getStudentList();
            if (countCMB2 + students.size() <= CMB2Max) {
                for (int j = 0; j < students.size(); j++) {
                    //        StudentDA.update(students.get(j), "COLOMBO2");
                }
                countCMB2 += students.size();
            } else {
                CenterDA.updateStudents(CMB1Location, schoolsES.get(i));

                //      for (int j = 0; j < students.size(); j++) {
                //        StudentDA.update(students.get(j), CMB1Location);
                //  }
                countCMB1 += students.size();
            }
        }
        slomf.admin.Log.addLog("School applicants in Colombo assigned");
        //Assign all the private sinhala and english students
        for (int i = 0; i < studentList.size(); i++) {
            if (!studentList.get(i).getMedium().equals("TAMIL") && studentList.get(i).getPreferred_centre().equals("COLOMBO")) {
                if (countCMB2 + 1 <= CMB2Max) {
                    //    StudentDA.update(studentList.get(i), "COLOMBO2");
                    countCMB2++;
                } else {
                    StudentDA.update(studentList.get(i), CMB1Location);
                    countCMB1++;
                }
            }
        }
        slomf.admin.Log.addLog("Private applicants in Colombo assigned");

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
                //slomf.admin.Log.addLog(student.getAssigned_centre());
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
