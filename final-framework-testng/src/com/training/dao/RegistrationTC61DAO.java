package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.LoginBean;
import com.training.bean.RegistrationTC61Bean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class RegistrationTC61DAO {
	
	Properties properties; 
	
	public RegistrationTC61DAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<RegistrationTC61Bean> getRegistration(){
		String sql = properties.getProperty("get.Registration"); 
		
		GetConnection gc  = new GetConnection(); 
		List<RegistrationTC61Bean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<RegistrationTC61Bean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				RegistrationTC61Bean temp = new RegistrationTC61Bean(); 
				temp.setFirstName(gc.rs1.getString(1));
				temp.setLastName(gc.rs1.getString(2));
				temp.setEmail(gc.rs1.getString(3));
				temp.setTelephone(gc.rs1.getString(4));
				temp.setAddress1(gc.rs1.getString(5));
				temp.setAddress2(gc.rs1.getString(6));
				temp.setCity(gc.rs1.getString(7));
				temp.setPostalCode(gc.rs1.getString(8));
				temp.setCountry(gc.rs1.getString(9));
				temp.setRegion(gc.rs1.getString(10));
				temp.setPassword(gc.rs1.getString(11));
				temp.setConfirmPassword(gc.rs1.getString(12));
				
				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new RegistrationTC61DAO().getRegistration().forEach(System.out :: println);
	}
	
	
}
