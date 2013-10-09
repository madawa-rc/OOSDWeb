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
    private String[] result;

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
    
    
}
