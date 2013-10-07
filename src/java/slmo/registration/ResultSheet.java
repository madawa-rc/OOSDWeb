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

    private String indexNum;
    private String[] result;

    public ResultSheet(String indexNum) {
        this.indexNum = indexNum;
        result = new String[30];
    }

    public void insertRecords(int i, String record) {
        result[i] = record;
    }

    public String[] getRecords() {
        return result;
    }
}
