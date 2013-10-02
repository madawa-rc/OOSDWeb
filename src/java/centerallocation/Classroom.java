
package centerallocation;

import java.util.ArrayList;
import slmo.registration.Student;


public class Classroom {
    private int classroomNumber;
    private int numberOfStudents;
    ArrayList<Student> studentList;

    public Classroom(int classroomNumber, int numberOfStudents) {
        this.classroomNumber = classroomNumber;
        this.numberOfStudents = numberOfStudents;
        studentList = new ArrayList<Student>();
    }
    
    public void addStudent(Student student){
        studentList.add(student);
    }
    
}
