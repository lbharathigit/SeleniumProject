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
import com.training.pom.RegistrationTC01POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


@SuppressWarnings("unused")
public class LoginTC02Test {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginTC02POM LoginTC02POM;
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
	public void validRegistrationTestRTTC01() throws InterruptedException {
		
		//Opening Login Page
        WebElement accounticon=driver.findElement(By.xpath("//li[@class='tb_link dropdown tb_menu_system_account_account']"));
        Actions act=new Actions(driver);
        act.moveToElement(accounticon).build().perform();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[text()='LOGIN / REGISTER']")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
        //Filling Login details
        LoginTC02POM.sendEmail("test1@test.com");
		LoginTC02POM.sendPassword("Test!23"); 
		LoginTC02POM.clickLoginBtn();
		
		//Validating Login confirmation
		boolean Email = driver.getPageSource().contains("An email with a confirmation link has been sent your email address.");
		  Assert.assertTrue(Email);
	    {
	    screenShot.captureScreenShot("Loggedin");
	    	    
	    //The below code is for Logout
	    //WebElement accounticon1=driver.findElement(By.xpath("//i[@class='fa fa-user-o']"));
        //Actions act1=new Actions(driver);
		//act1.moveToElement(accounticon1).build().perform();
		//driver.findElement(By.xpath("//span[text()='LOGOUT']")).click();
		
		}
	}
}

