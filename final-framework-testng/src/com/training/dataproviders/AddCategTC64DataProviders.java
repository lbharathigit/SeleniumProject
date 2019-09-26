package com.training.dataproviders;

import org.testng.annotations.DataProvider;
import com.training.readexcel.ApachePOIExcelReadTC62;

public class AddCategTC64DataProviders {

	/*@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<RegistrationTC61Bean> list = new RetailDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(RegistrationTC61Bean temp : list){
			Object[]  obj = new Object[12]; 
			obj[0] = temp.getFirstName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}*/
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		int START_ROW = 30;
		int START_COL = 2;
		int TOTAL_ROWS = 3;
		int TOTAL_COLUMNS = 4;
		String fileName ="C:/Bharathi/Selenium/Retail_Complex.xlsx"; 
		return new ApachePOIExcelReadTC62().getExcelContent(fileName, "Test Data",START_ROW, START_COL, TOTAL_ROWS, TOTAL_COLUMNS); 
	}
	
	/*@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Bharathi/Selenium/Retail_Complex.xlsx", "Sheet2"); 
	}*/
}
