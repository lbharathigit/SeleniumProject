package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.RegisterTC61DataProviders;
import com.training.dataproviders.MultiRegisterTC63DataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.InvalidRegisterTC63POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class InvalidRegisterTC63Test {
	
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private InvalidRegisterTC63POM InvalidRegisterTC63POM;

	@BeforeMethod
	public void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			InvalidRegisterTC63POM = new InvalidRegisterTC63POM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		}

	@AfterMethod
	public void tearDown() throws InterruptedException {
	Thread.sleep(3000);
	driver.quit();

	}
	
	@Test(dataProvider = "excel-inputs", dataProviderClass = MultiRegisterTC63DataProviders.class)
	public void validMutiRegisterTC62Test(String FirstName, String LastName, String Email, String Telephone, String Address1, String Address2, String City, String PostalCode, String Country, String Region, String Password, String ConfirmPassword) throws InterruptedException {
		
		//System.out.println("FirstName:"+ FirstName + "LastName:"+ LastName + "Email:" + Email + "Telephone:" + Telephone + "Address1:" + Address1 + "Address2:" + Address2 + "City:" + City + "PostalCode:" + PostalCode +  "Country:" + Country + "Region:" + Region + "Password:" + Password + "ConfirmPassword:" + ConfirmPassword);
		WebElement accounticon=driver.findElement(By.xpath("//li[@class='tb_link dropdown tb_menu_system_account_account']"));
        Actions act=new Actions(driver);
        act.moveToElement(accounticon).build().perform();
        driver.findElement(By.xpath("//span[text()='LOGIN / REGISTER']")).click();
        driver.findElement(By.xpath("//a[text()='Register']")).click(); 
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);  
		InvalidRegisterTC63POM.sendFirstName(FirstName);
		InvalidRegisterTC63POM.sendLastName(LastName);
		InvalidRegisterTC63POM.sendEmail(Email);
		InvalidRegisterTC63POM.sendTelephone(Telephone);
		InvalidRegisterTC63POM.sendAddress1(Address1);
		InvalidRegisterTC63POM.sendAddress2(Address2);
		InvalidRegisterTC63POM.sendCity(City);
		InvalidRegisterTC63POM.sendPostalCode(PostalCode);
		Select drpCountry = new Select (driver.findElement(By.id("input-country")));
		drpCountry.selectByVisibleText(Country);
		Select drpRegion = new Select (driver.findElement(By.id("input-zone")));
		drpRegion.selectByVisibleText(Region);
		InvalidRegisterTC63POM.sendPassword(Password);
		InvalidRegisterTC63POM.sendConfirmPassword(ConfirmPassword);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement agree = driver.findElement(By.name("agree"));
		agree.click();
		InvalidRegisterTC63POM.clickcontinueBtn();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//Validating error message during registration
		boolean Register = driver.getPageSource().contains("must be");
		Assert.assertTrue(Register);
				
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String filename="RTTC63_"+df.format(new Date()).toString();
		System.out.println(filename);
        screenShot.captureScreenShot(filename);
				
		}
}
	


	


