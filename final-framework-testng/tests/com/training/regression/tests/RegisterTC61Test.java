package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import com.training.generics.ScreenShot;
import com.training.pom.RegisterTC61POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.dataproviders.RegisterTC61DataProviders;


public class RegisterTC61Test {
	
	private WebDriver driver;
	private String baseUrl;
	private RegisterTC61POM RegisterTC61POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeMethod
	public void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			RegisterTC61POM = new RegisterTC61POM(driver); 
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
	
	@Test(dataProvider = "db-inputs", dataProviderClass = RegisterTC61DataProviders.class)
	public void DBRegistrationTest(String FirstName, String LastName, String Email, String Telephone, String Address1, String Address2, String City, String PostalCode, String Country, String Region, String Password, String ConfirmPassword) throws InterruptedException {
		
		System.out.println("FirstName:"+ FirstName + "LastName:"+ LastName + "Email:" + Email + "Telephone:" + Telephone + "Address1:" + Address1 + "Address2:" + Address2 + "City:" + City + "PostalCode:" + PostalCode +  "Country:" + Country + "Region:" + Region + "Password:" + Password + "ConfirmPassword:" + ConfirmPassword);
		
		WebElement accounticon=driver.findElement(By.xpath("//li[@class='tb_link dropdown tb_menu_system_account_account']"));
        Actions act=new Actions(driver);
        act.moveToElement(accounticon).build().perform();
        driver.findElement(By.xpath("//span[text()='LOGIN / REGISTER']")).click();
        driver.findElement(By.xpath("//a[text()='Register']")).click(); 
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);  
		RegisterTC61POM.sendFirstName(FirstName);
		RegisterTC61POM.sendLastName(LastName);
		RegisterTC61POM.sendEmail(Email);
		RegisterTC61POM.sendTelephone(Telephone);
		RegisterTC61POM.sendAddress1(Address1);
		RegisterTC61POM.sendAddress2(Address2);
		RegisterTC61POM.sendCity(City);
		RegisterTC61POM.sendPostalCode(PostalCode);
		Select drpCountry = new Select (driver.findElement(By.id("input-country")));
		drpCountry.selectByVisibleText(Country);
		Select drpRegion = new Select (driver.findElement(By.id("input-zone")));
		drpRegion.selectByVisibleText(Region);
		RegisterTC61POM.sendPassword(Password);
		RegisterTC61POM.sendConfirmPassword(ConfirmPassword);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement agree = driver.findElement(By.name("agree"));
		agree.click();
		RegisterTC61POM.clickcontinueBtn();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//Validating Registration confirmation
		boolean Register = driver.getPageSource().contains("Congratulations! Your new account has been successfully created!");
		Assert.assertTrue(Register);
		screenShot.captureScreenShot("Registercomplex");
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String filename="RTTC61_"+df.format(new Date()).toString();
		System.out.println(filename);
        screenShot.captureScreenShot(filename);
					
		//Logging out
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement accounticon1=driver.findElement(By.xpath("//i[@class='fa fa-user-o']"));
        Actions act1=new Actions(driver);
        act1.moveToElement(accounticon1).build().perform();
        driver.findElement(By.xpath("//span[contains(text(),'LOGOUT')]")).click();
		
		//Re-login with registered user to valid the login
        WebElement accounticon2=driver.findElement(By.xpath("//li[@class='tb_link dropdown tb_menu_system_account_account']"));
        Actions act2=new Actions(driver);
        act2.moveToElement(accounticon2).build().perform();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[text()='LOGIN / REGISTER']")).click();
	    RegisterTC61POM.sendEmail(Email);
	    RegisterTC61POM.sendPassword(Password);
	    RegisterTC61POM.clickLoginBtn();
	    boolean Login = driver.getPageSource().contains("My Account");
			  Assert.assertTrue(Login);
						
		} 
	}


