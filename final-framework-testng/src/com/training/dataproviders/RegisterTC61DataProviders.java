package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.RegistrationTC61Bean;
import com.training.dao.RegistrationTC61DAO;
import com.training.readexcel.ApachePOIExcelReadTC62;
import com.training.readexcel.ApachePOIExcelReadTC64;

public class RegisterTC61DataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<RegistrationTC61Bean> list = new RegistrationTC61DAO().getRegistration(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(RegistrationTC61Bean temp : list){
			Object[]  obj = new Object[12]; 
			obj[0] = temp.getFirstName(); 
			obj[1] = temp.getLastName(); 
			obj[2] = temp.getEmail();
			obj[3] = temp.getTelephone();
			obj[4] = temp.getAddress1();
			obj[5] = temp.getAddress2();
			obj[6] = temp.getCity();
			obj[7] = temp.getPostalCode();
			obj[8] = temp.getCountry();
			obj[9] = temp.getRegion();
			obj[10] = temp.getPassword();
			obj[11] = temp.getConfirmPassword();			
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		int START_ROW = 30;
		int START_COL = 2;
		int TOTAL_ROWS = 3;
		int TOTAL_COLUMNS = 4;
		String fileName ="C:/Bharathi/Selenium/Retail_Complex.xlsx"; 
		return new ApachePOIExcelReadTC64().getExcelContent(fileName, "Test Data",START_ROW, START_COL, TOTAL_ROWS, TOTAL_COLUMNS); 
	}
	
	/*@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Bharathi/Selenium/Retail_Complex.xlsx", "Sheet2"); 
	}*/
}
