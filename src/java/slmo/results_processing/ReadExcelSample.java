/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slmo.results_processing;

import Database.DatabaseConnectionHandler;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author Madawa
 */

/*
 * done in main method to run this file locally.
 * download apache poi 3.9 from http://www.apache.org/dyn/closer.cgi/poi/release/bin/poi-bin-3.9-20121203.zip
 * include these libraries
 * poi-3.9-20121203.jar
 * poi-ooxml-3.9-20121203.jar
 * poi-ooxml-schemas-3.9-2-121203.jar
 * AND
 * all jars included in ooxml-lib folder
 * 
 */
public class ReadExcelSample {
    
    public static void readResults(String filePath){
        try {
            FileInputStream fis = new FileInputStream(filePath);
            //getting the workbook
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            //getting the sheet
            XSSFSheet sheet = workbook.getSheetAt(0);
            
            //iterate throgh rows
            Iterator<Row> rowIter = sheet.iterator();
            while(rowIter.hasNext()){
                Row row = rowIter.next();
                //iterate through cells for each row
                Iterator<Cell> cellIter = row.cellIterator();
                Cell cell = cellIter.next();
                int index = 000000;
                String[] answers = new String[30];
                switch(cell.getCellType()){
                        case Cell.CELL_TYPE_NUMERIC:
                            index=(int)cell.getNumericCellValue();
                            break;
                        case Cell.CELL_TYPE_STRING:
                            index = Integer.parseInt(cell.getStringCellValue());
                            break;
                }
                int i = 0;
                while(cellIter.hasNext()){
                    cell = cellIter.next();
                    //get cell value
                    answers[i] = cell.getStringCellValue();
                    i++;
                }
                try {
                    writeToDatabase(index, answers);
                } catch (SQLException ex) {
                    Logger.getLogger(ReadExcelSample.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            fis.close();
        } catch (FileNotFoundException ex) {
            System.out.println("NO FILE");
        } catch (IOException ex) {
            System.out.println("IOE");
        }
    }
    
    private static void writeToDatabase(int index,String[] answers) throws SQLException{
        Connection con = DatabaseConnectionHandler.getConnection();
        String queryCheck = "DELETE FROM marks WHERE indexNum = ?";;
        PreparedStatement ps = con.prepareStatement(queryCheck);
        ps.setString(1, ""+index);
        ps.execute();
        
        queryCheck = "INSERT INTO marks (indexNum";
        for(int i = 1; i <= 30; i++)
            queryCheck+=",q"+i;
        queryCheck+=") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        ps = con.prepareStatement(queryCheck);
        ps.setInt(1, index);
        for(int i = 2; i <= 31; i++){
            ps.setString(i, answers[i-2]);
        }
        
        ps.executeUpdate();
        
    }
}