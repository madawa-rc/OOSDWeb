
package slomf.admin.center;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import slomf.registration.Student;


public class Classroom {
    private int classroomNumber;
    private int numberOfStudents;
    private int maxIndex=0;
    private int minIndex=0;
    ArrayList<Student> studentList;

    public Classroom(int classroomNumber, int numberOfStudents) {
        this.classroomNumber = classroomNumber;
        this.numberOfStudents = numberOfStudents;
        studentList = new ArrayList<Student>();
    }
    
    public void addStudent(Student student){
        studentList.add(student);
    }

    public int getClassroomNumber() {
        return classroomNumber;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }
    public void sort(){
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if( s1.getIndex()>s2.getIndex()){
                    return 1;
                }
                else
                    return -1;
            }
        };
        Collections.sort(studentList,comparator);
        if(studentList.size()>=1){
            minIndex=studentList.get(0).getIndex();
            maxIndex=studentList.get(studentList.size()-1).getIndex();
        }
        
    }

    public int getMaxIndex() {
        return maxIndex;
    }

    public int getMinIndex() {
        return minIndex;
    }
    
}
