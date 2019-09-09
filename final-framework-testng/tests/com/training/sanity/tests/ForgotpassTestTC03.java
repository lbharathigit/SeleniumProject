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
	import com.training.pom.LoginTC02POM;
	import com.training.pom.ForgotpassTC03POM;
	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;


	@SuppressWarnings("unused")
	public class ForgotpassTestTC03 {
		
		private WebDriver driver;
		private String baseUrl;
		private LoginTC02POM LoginTC02POM;
		private ForgotpassTC03POM ForgotpassTC03POM;
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
		ForgotpassTC03POM = new ForgotpassTC03POM(driver); 
		LoginTC02POM = new LoginTC02POM(driver); 
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
		public void validForgotpassTestTC03() throws InterruptedException {
			
			//Opening Login Page
	        WebElement accounticon=driver.findElement(By.xpath("//li[@class='tb_link dropdown tb_menu_system_account_account']"));
	        Actions act=new Actions(driver);
	        act.moveToElement(accounticon).build().perform();
	        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	        driver.findElement(By.xpath("//span[text()='LOGIN / REGISTER']")).click();
	        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	        
	        //Filling Login details
	        LoginTC02POM.sendEmail("test1@test1.com");
			LoginTC02POM.sendPassword("Test123"); 
			LoginTC02POM.clickLoginBtn();	
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			
			//Validating Login failure
			String str = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
			System.out.println(str);
		    screenShot.captureScreenShot("Loginfail");
		    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		    
		    //Entering email to retrieve the password
		    driver.findElement(By.xpath("//a[text()='Forgotten Password']")).click();
		    ForgotpassTC03POM.sendEmail("test1@test.com");
		    driver.findElement(By.xpath("//input[@type='submit']")).click();
		    
		    //Validating the Email sent message
		    String str1 = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
			System.out.println(str1);
			  boolean Reset = driver.getPageSource().contains("An email with a confirmation link has been sent your email address.");
			  Assert.assertTrue(Reset);
				 screenShot.captureScreenShot("EmailSent");	    
			 			}
		}
	



