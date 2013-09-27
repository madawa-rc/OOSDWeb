/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package centerallocation;

import java.util.ArrayList;

public class ExamCenter {
    private String centerName;
    private int numberOfStudents;
    private int maxNumberOfStudents;
    ArrayList<Classroom> classroomList = new ArrayList<Classroom>();
    
    public ExamCenter(String centerName,int maxNumberOfStudents) {
        this.centerName = centerName;
        this.maxNumberOfStudents = maxNumberOfStudents;
        numberOfStudents = 0;
    }

    
    public String getCenterName() {
        return centerName;
    }

    public void addClassroom(Classroom classroom){
        classroomList.add(classroom);
    }
}
