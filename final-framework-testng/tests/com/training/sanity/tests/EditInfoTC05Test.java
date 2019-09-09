package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginTC02POM;
import com.training.pom.MyOrdersTC04POM;
import com.training.pom.EditInfoTC05POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import org.testng.asserts.*;



@SuppressWarnings("unused")
public class EditInfoTC05Test {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginTC02POM LoginTC02POM;
	private EditInfoTC05POM EditInfoTC05POM;
	private static Properties properties;
	private ScreenShot screenShot;
	private Hashtable<Object, Object> actualString;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
		}

	@BeforeMethod
	public void setUp() throws Exception {
	driver = DriverFactory.getDriver(DriverNames.CHROME);
	LoginTC02POM = new LoginTC02POM(driver);
	EditInfoTC05POM = new EditInfoTC05POM(driver);
	baseUrl = properties.getProperty("baseURL");
	screenShot = new ScreenShot(driver); 
	// open the browser 
	driver.get(baseUrl);
}

	@AfterMethod
	public void tearDown() throws Exception {
	Thread.sleep(3000);
	driver.quit();

	}
	
	@Test
	public void validEditInfoTC05Test() throws InterruptedException 
	{
		//Opening Login Page
        WebElement accounticon=driver.findElement(By.xpath("//li[@class='tb_link dropdown tb_menu_system_account_account']"));
        Actions act=new Actions(driver);
        act.moveToElement(accounticon).build().perform();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[text()='LOGIN / REGISTER']")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
        //Filling Login details
        LoginTC02POM.sendEmail("test4@test4.com");
		LoginTC02POM.sendPassword("Test12#"); 
		LoginTC02POM.clickLoginBtn();	
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
	    //Clicking Edit Personal Info Link
        driver.findElement(By.xpath("//a[text()='Edit your account information']")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
       //Editing Personal info       
        EditInfoTC05POM.sendFirstName("TestFirstName");
        EditInfoTC05POM.sendLastName("TestLastName"); 
        EditInfoTC05POM.sendEmail1("test5@test5.com"); 
        EditInfoTC05POM.sendTelephone("9941999419");        
        EditInfoTC05POM.clickContBtn();
        boolean Edit = driver.getPageSource().contains("Success: Your account has been successfully updated.");
		Assert.assertTrue(Edit);
	    screenShot.captureScreenShot("EditPersonalInfo");               
     	}
	}






