/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slmo.results_processing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
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
    public static void main(String[] args){
        try {
            FileInputStream fis = new FileInputStream("sample.xlsx");
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
                
                while(cellIter.hasNext()){
                    Cell cell = cellIter.next();
                    //get cell value
                    switch(cell.getCellType()){
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                    }
                }
                System.out.println("");
            }
            fis.close();
        } catch (FileNotFoundException ex) {
            System.out.println("NO FILE");
        } catch (IOException ex) {
            System.out.println("IOE");
        }
    }
}