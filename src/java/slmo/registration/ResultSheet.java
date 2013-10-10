/*
 * A class to implement a resukts sheet 
 */
package slmo.registration;

/**
 * @author Fiontar
 */

public class ResultSheet {

    private int indexNum;
    private String name;
    private String school;
    private String assignedCentre;
    private String[] result;
/**
 * constructor of ResultSheet class
 * @param indexNum applicant's index 
 * @param name name
 * @param school school
 * @param assignedCentre exam center
 */
    public ResultSheet(int indexNum, String name, String school, String assignedCentre) {
        this.indexNum = indexNum;
        this.name = name;
        this.school = school;
        this.assignedCentre = assignedCentre;
        result = new String[30];
    }
/**
 * default constructor of ResultSheet class
 * @param indexNum applicant's index
 */
    public ResultSheet(int indexNum) {
        this.indexNum = indexNum;
        result = new String[30];
    }
/**
 * method to allocate marks of the i th questions
 * @param i question number
 * @param record marks
 */
    public void insertRecords(int i, String record) {
        result[i] = record;
    }
/**
 * method gives an array of marks for each question
 * @return results array
 */
    public String[] getRecords() {
        return result;
    }
/**
 * method gives the index number of the applicant 
 * @return index number
 */
    public int getIndexNum() {
        return indexNum;
    }
/**
 * method gives an array of marks for each question
 * @return results array
 */
    public String[] getResult() {
        return result;
    }
/**
 * method gives the school name
 * @return school name
 */
    public String getSchool() {
        return school;
    }
/**
 * method gives the applicant's name
 * @return name
 */
    public String getName() {
        return name;
    }
/**
 * method gives applicant's assigned exam center
 * @return exam center
 */
    public String getAssignedCentre() {
        return assignedCentre;
    }
}
