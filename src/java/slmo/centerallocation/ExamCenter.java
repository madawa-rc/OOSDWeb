package slmo.centerallocation;

import java.util.ArrayList;
import slmo.registration.Student;

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

    public String getCenterName() {
        return centerName;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addStudent(Student student) {
        int classroom = Integer.parseInt(student.getAssigned_classrm());
        System.out.println(student.getAssigned_classrm());
        System.out.println(student.getName()+"  "+student.getAssigned_centre()+"  ");
        classroomList.get(classroom-1).addStudent(student);
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setClassrooms(int classrooms) {
        this.classrooms = classrooms;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setClassroomList(ArrayList<Classroom> classroomList) {
        this.classroomList = classroomList;
    }

    public int getClassrooms() {
        return classrooms;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<Classroom> getClassroomList() {
        return classroomList;
    }
    
}
