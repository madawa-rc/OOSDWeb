/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slmo.results_processing;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import slmo.registration.Student;

/**
 *
 * @author Madawa
 */
public class WriteExcelExample {
    public static void main(String[] args){
        //ArrayList<Student> stuList = StudentDA.getAllStudents(); my database is courrupted. please check with the database
        //refer to StudentDA -> getAllStudents()
        
        ArrayList<Student> stuList = new ArrayList<Student>();
        stuList.add(new Student("ID"));
        stuList.add(new Student("Kassa"));
        stuList.add(new Student("Wenula"));
        stuList.add(new Student("bushi"));
        XSSFWorkbook workbook = new XSSFWorkbook();
        
        XSSFSheet sheet = workbook.createSheet();
        Student s;
        for(int rowNum = 0; rowNum < stuList.size(); rowNum++){
            Row row = sheet.createRow(rowNum+1);
            //for(int colNum = 1; colNum < 20; colNum++){
                s = stuList.get(rowNum);
                Cell cell = row.createCell(1);
                cell.setCellValue(s.getName());
                
           // }
        }
        try {
            FileOutputStream fos = new FileOutputStream("sample2.xlsx");
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteExcelExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WriteExcelExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
