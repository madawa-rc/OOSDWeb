/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
        Cell[] cells = new Cell[18];
        
        Row row = sheet.createRow(0);
        
        for(int colNum = 0; colNum < cells.length; colNum++){
                cells[colNum] = row.createCell(colNum); 
        }
        cells[0].setCellValue("INDEX");
        cells[1].setCellValue("NAME");
        cells[2].setCellValue("DATE OF BIRTH");
        cells[3].setCellValue("EMAIL");
        cells[4].setCellValue("PRIVATE APLLICANT");
        cells[5].setCellValue("VERIFIED");
        cells[6].setCellValue("PAYMENT VERIFIED");
        cells[7].setCellValue("SCHOOL");
        cells[8].setCellValue("SCHOOL ADDRESS");
        cells[9].setCellValue("HOME ADDRESS");

        cells[10].setCellValue("PHONE");
        cells[11].setCellValue("MEDIUM");
        cells[12].setCellValue("PREFFERED CENTRE");
        cells[13].setCellValue("ASSIGNED CENTRE");
        cells[14].setCellValue("ASSIGNED CLASSROOM");


        cells[15].setCellValue("MARKS");
        cells[16].setCellValue("AWARD");
        cells[17].setCellValue("WITHIN 16");
        
        for(int rowNum = 0; rowNum < studentList.size(); rowNum++){
            row = sheet.createRow(rowNum+1);
            for(int colNum = 0; colNum < cells.length; colNum++){
                cells[colNum] = row.createCell(colNum); 
            }
            
            s = studentList.get(rowNum);
            cells[0].setCellValue(s.getIndex());
            cells[1].setCellValue(s.getName());
            cells[2].setCellValue(s.getDate()+"/"+s.getMonth()+"/"+s.getYear());
            cells[3].setCellValue(s.getEmail());
            cells[4].setCellValue(s.getPvt_applicant());
            cells[5].setCellValue(s.getVerified());
            cells[6].setCellValue(s.getPayment());
            cells[7].setCellValue(s.getSchool());
            cells[8].setCellValue(s.getSchool_addr());
            cells[9].setCellValue(s.getHome_addr());
            
            cells[10].setCellValue(s.getPhone());
            cells[11].setCellValue(s.getMedium());
            cells[12].setCellValue(s.getPreferred_centre());
            cells[13].setCellValue(s.getAssigned_centre());
            cells[14].setCellValue(s.getAssigned_classrm());
            
            
            cells[15].setCellValue(s.getMarks());
            cells[16].setCellValue(s.getAward());
            cells[17].setCellValue(s.getWithin16());
        }
        
        
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\Madawa\\Documents\\GitHub\\OOSDWeb\\sample2.xlsx");
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
