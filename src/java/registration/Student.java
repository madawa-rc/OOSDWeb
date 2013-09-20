/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

/**
 *
 * @author Madawa
 */
public class Student {
    private String name;
    private int age;
    private int grade;
    private int index;

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }
    
    

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
