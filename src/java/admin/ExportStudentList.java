/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import slmo.registration.Student;
import slmo.registration.dao.StudentDA;
/**
 *
 * @author Madawa
 */
public class ExportStudentList {
    
    public static void exportStudentsToExcel(){
        ArrayList<Student> studentList = StudentDA.getAllStudents();
        
        XSSFWorkbook workbook = new XSSFWorkbook();
        
        XSSFSheet sheet = workbook.createSheet();
        Student s;
        Cell[] cells = new Cell[20];
        for(int rowNum = 0; rowNum < studentList.size(); rowNum++){
            Row row = sheet.createRow(rowNum+1);
            for(int colNum = 0; colNum < 20; colNum++){
                cells[colNum] = row.createCell(colNum); 
            }
            
            s = studentList.get(rowNum);
            cells[0].setCellValue(s.getName());
            cells[1].setCellValue(s.getDate()+"/"+s.getMonth()+"/"+s.getYear());
            cells[2].setCellValue(s.getEmail());
            cells[3].setCellValue(s.getSchool());
            cells[4].setCellValue(s.getSchool_addr());
            cells[5].setCellValue(s.getHome_addr());
            cells[6].setCellValue(s.getPvt_applicant());
            cells[7].setCellValue(s.getPhone());
            cells[8].setCellValue(s.getMedium());
            cells[9].setCellValue(s.getPreferred_centre());
            cells[10].setCellValue(s.getAssigned_centre());
            cells[11].setCellValue(s.getAssigned_classrm());
            cells[5].setCellValue(s.getIndex());
            cells[5].setCellValue(s.getHome_addr());
        }
        
        
        try {
            FileOutputStream fos = new FileOutputStream("sample2.xlsx");
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        }
    }
}
