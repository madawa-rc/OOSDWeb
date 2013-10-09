/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slmo.registration;

/**
 *
 * @author Kasun
 */
public class ResultSheet {

    private int indexNum;
    private String name;
    private String school;
    private String assignedCentre;
    private String[] result;

    public ResultSheet(int indexNum, String name, String school, String assignedCentre) {
        this.indexNum = indexNum;
        this.name = name;
        this.school = school;
        this.assignedCentre = assignedCentre;
        result = new String[30];
    }

    public ResultSheet(int indexNum) {
        this.indexNum = indexNum;
        result = new String[30];
    }


    public void insertRecords(int i, String record) {
        result[i] = record;
    }

    public String[] getRecords() {
        return result;
    }

    public int getIndexNum() {
        return indexNum;
    }

    public String[] getResult() {
        return result;
    }

    public String getSchool() {
        return school;
    }

    public String getName() {
        return name;
    }

    public String getAssignedCentre() {
        return assignedCentre;
    }
}
