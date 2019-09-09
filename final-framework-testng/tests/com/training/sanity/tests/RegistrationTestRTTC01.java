package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RegistrationTC01POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class RegistrationTestRTTC01 {
	
	private WebDriver driver;
	private String baseUrl;
	private RegistrationTC01POM RegistrationTC01POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
		}

	@BeforeMethod
	public void setUp() throws Exception {
	driver = DriverFactory.getDriver(DriverNames.CHROME);
	RegistrationTC01POM = new RegistrationTC01POM(driver); 
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
	
	@Test
	public void validRegistrationTestRTTC01() throws InterruptedException {
		
		//Opening Registration Page
        WebElement accounticon=driver.findElement(By.xpath("//li[@class='tb_link dropdown tb_menu_system_account_account']"));
        Actions act=new Actions(driver);
        act.moveToElement(accounticon).build().perform();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[text()='LOGIN / REGISTER']")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[text()='Register']")).click();    
        
        //Filling Registration Form
        RegistrationTC01POM.sendFirstName("TestFirstName");
		RegistrationTC01POM.sendLastName("TestLastName"); 
		RegistrationTC01POM.sendEmail("test6@test6.com"); 
		RegistrationTC01POM.sendTelephone("9941999419"); 
		RegistrationTC01POM.sendAddress1("TestAddress1"); 
		RegistrationTC01POM.sendAddress2("TestAddress2"); 
		RegistrationTC01POM.sendCity("TestCity"); 
		RegistrationTC01POM.sendPostcode("600084");
		Select drpCountry = new Select (driver.findElement(By.id("input-country")));
		drpCountry.selectByVisibleText("India");
		Select drpRegion = new Select (driver.findElement(By.id("input-zone")));
		drpRegion.selectByVisibleText("Tamil Nadu");
		RegistrationTC01POM.sendPassword("Test!23");
		RegistrationTC01POM.sendConfirm("Test!23");
		WebElement news = driver.findElement(By.name("newsletter"));
		news.click();
		WebElement agree = driver.findElement(By.name("agree"));
		agree.click();	
		RegistrationTC01POM.clickcontinueBtn();
		
		//Validating Registration confirmation
		boolean Register = driver.getPageSource().contains("Congratulations! Your new account has been successfully created!");
		Assert.assertTrue(Register);
		screenShot.captureScreenShot("Registered");
				
		//This script is for Logout
		//WebElement accounticon1=driver.findElement(By.xpath("//li[@class='tb_link dropdown tb_menu_system_account_account']"));
        //Actions act1=new Actions(driver);
		//act1.moveToElement(accounticon1).build().perform();
		//driver.findElement(By.xpath("//span[text()='LOGOUT']")).click();
		
		}
	}


