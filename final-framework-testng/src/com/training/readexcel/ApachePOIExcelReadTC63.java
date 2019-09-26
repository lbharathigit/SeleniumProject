package com.training.readexcel;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @author Bala Murthy
 * @This class will take the records from excel sheet from the START_ROW, START_COL fetch TOTAL_ROWS and TOTAL_COLUMNS 4, and return it as list
 *      of list of object Test it with main method provided, and the path is hard coded,
 *      participants are asked to refractor this path in the property file and
 *      access.
 */
public class ApachePOIExcelReadTC63 {
	public  String [][] getExcelContent(String fileName,String sheetName,int startrow,int startcol,int totalrows,int totalcolumns) {
		int rowCount =0; 
		String [][] list1 = null; 
		
		try {
			System.out.println("File Name Got " + fileName);
			FileInputStream file = new FileInputStream(new File(fileName));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			//XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			//int rowTotal = sheet.getLastRowNum();
			int rowTotal = totalrows;
			
			if ((rowTotal > 0) || (sheet.getPhysicalNumberOfRows() > 0)) {
			    rowTotal++;
			}
			
			
			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			 list1 = new String[rowTotal][startrow];
			 
			 
			 while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if(row.getRowNum() < startrow || row.getRowNum() > (startrow+totalrows)){
					   continue; //just skip the rows if row is within range
					  }
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				//int cellCount = startcol; 
				int cellCount = 0;
				int noOfColumns = totalcolumns;
				//System.out.println("cols : " + noOfColumns);
				String[] tempList1 = new String[noOfColumns];
				DataFormatter df = new DataFormatter();
							
				while (cellIterator.hasNext()) {
					
					//System.out.println("Value"+asItLooksInExcel);

					Cell cell = cellIterator.next();
				
					String asItLooksInExcel = df.formatCellValue(cell);
					
					//if ((cell.getColumnIndex() < startcol) || (cell.getColumnIndex() > (startcol+totalcolumns)))
					if ((cell.getColumnIndex() < startcol) || (cellCount > totalcolumns))
					{
						continue;
					}
						
					//If cell contains date
					if (cell.getCellStyle().getDataFormat() == 14) { //default short date without explicit formatting
					     
					     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					     tempList1[cellCount] = dateFormat.format(cell.getDateCellValue());
					     
					      
					} 
					else 
					{
						
						tempList1[cellCount] =asItLooksInExcel;
						//System.out.println(asItLooksInExcel);
					}   
						cellCount ++; 
				}
				
				
				if(tempList1 != null){
					
					list1[rowCount++] = tempList1;
					
				
			}
		}
		
			
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list1;
	}

	
	
	public static void main(String[] args) {
		String fileName = "C:/Bharathi/Selenium/Retail_Complex.xlsx";
		int START_ROW = 23;
		int START_COL = 2;
		int TOTAL_ROWS = 3;
		int TOTAL_COLUMNS = 12;
			
		for(String [] temp : new ApachePOIExcelReadTC63().getExcelContent(fileName, "Test Data",START_ROW, START_COL, TOTAL_ROWS, TOTAL_COLUMNS)){
			for(String  tt : temp){
				if (tt !=null) {
					
					System.out.print(tt + " ");
				}
							}
			System.out.println();
		}

	}
}