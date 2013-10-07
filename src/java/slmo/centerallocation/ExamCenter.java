/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slmo.centerallocation;

import java.util.ArrayList;

public class ExamCenter {
    private String centerName;
    private String location;
    private int capacity;
    private int classrooms;
    private String supervisor;
    private String phone;
    
    private ArrayList<Classroom> classroomList = new ArrayList<Classroom>();

    public ExamCenter(String centerName, String location, int capacity, int classrooms, String supervisor, String phone) {
        this.centerName = centerName;
        this.location = location;
        this.capacity = capacity;
        this.classrooms = classrooms;
        this.supervisor = supervisor;
        this.phone = phone;
    }
    
}
