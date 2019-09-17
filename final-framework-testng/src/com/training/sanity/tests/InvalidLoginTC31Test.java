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
	import com.training.pom.InvalidLoginTC31POM;
	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;


	@SuppressWarnings("unused")
	public class InvalidLoginTC31Test {
		
		private WebDriver driver;
		private String baseUrl;
		private InvalidLoginTC31POM InvalidLoginTC31POM;
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
		InvalidLoginTC31POM = new InvalidLoginTC31POM(driver); 
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
		public void validInvalidLoginTC31Test() throws InterruptedException {
			
			//Opening Login Page
	        WebElement accounticon=driver.findElement(By.xpath("//li[@class='tb_link dropdown tb_menu_system_account_account']"));
	        Actions act=new Actions(driver);
	        act.moveToElement(accounticon).build().perform();
	        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	        driver.findElement(By.xpath("//span[text()='LOGIN / REGISTER']")).click();
	        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	        
	        //Filling Login details
	        InvalidLoginTC31POM.sendEmail("lbharathi@gmail.com");
	        InvalidLoginTC31POM.sendPassword("Test123"); 
	        InvalidLoginTC31POM.clickLoginBtn();	
						
			//Validating Login failure
			String message = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
			Assert.assertEquals(message, "Warning: No match for E-Mail Address and/or Password.");
			System.out.println(message);
			screenShot.captureScreenShot("InvalidLogin");
		     }
		}

