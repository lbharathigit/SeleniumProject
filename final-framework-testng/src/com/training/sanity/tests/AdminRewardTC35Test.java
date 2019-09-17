package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminRewardTC35POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


@SuppressWarnings("unused")
public class AdminRewardTC35Test {
	
	private WebDriver driver;
	private String baseUrl1;
	private AdminRewardTC35POM AdminRewardTC35POM;
	private static Properties properties;
	private ScreenShot screenShot;
	WebDriverWait wait;
	private By tagText = By.id("tags");
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			AdminRewardTC35POM = new AdminRewardTC35POM(driver); 
			baseUrl1 = properties.getProperty("baseURL1");
			screenShot = new ScreenShot(driver); 
			driver.get(baseUrl1);
			wait = new WebDriverWait(driver, 5);
}

	@AfterClass
	public void tearDown() throws Exception {
	Thread.sleep(3000);
	driver.quit();

	}
	
	@Test (priority=0)
	public void validAdminLoginTest() throws InterruptedException {
					
		 //Filling Login details
		AdminRewardTC35POM.sendUsername("admin");
		AdminRewardTC35POM.sendPassword("admin@123"); 
		AdminRewardTC35POM.clickLoginBtn();
	}
	
	@Test (priority=1)
	public void validAddingProductTest1() throws InterruptedException {	

		//Navigating to General tab
        WebElement Catalog = driver.findElement(By.xpath("//i[@class='fa fa-tags fw']"));
        Actions act  = new Actions(driver);
        act.moveToElement(Catalog).build().perform();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[@id='menu-catalog']//ul//li//a[contains(text(),'Products')]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        AdminRewardTC35POM.clickAddnewBtn();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        AdminRewardTC35POM.sendProdname("NewProduct2"); 
        JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		AdminRewardTC35POM.sendMetaname("NewProdMetaname2"); 
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("window.scrollBy(0,-300)");
		
	}
	
	@Test (priority=2)
	public void validAddingProductTest2() throws InterruptedException {
		
		//Navigating to Data tab
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Data')]")).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		AdminRewardTC35POM.sendModname("NPRD2");
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("window.scrollBy(0,400)");
		AdminRewardTC35POM.sendPrice("500");
		AdminRewardTC35POM.sendQuantity("50");
		JavascriptExecutor jse3 = (JavascriptExecutor)driver;
		jse3.executeScript("window.scrollBy(0,-400)");
		}
				
	@Test (priority=3)
	public void validAddingProductTest3() throws InterruptedException {
			
		//Navigating to Link tab
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Links')]")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;        
        js.executeScript("document.querySelector(\"input[placeholder='Categories']\").value='EARRINGS'");
		//AdminRewardTC35POM.sendCategory("EARRINGS");
		}
		
	@Test (priority=4)
	public void validAddingProductTest4() throws InterruptedException {
		
			//Navigating to Discount tab
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[contains(text(),'Discount')]")).click();	
			AdminRewardTC35POM.clickDiscBtn();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			AdminRewardTC35POM.sendQuantity1("1");
			AdminRewardTC35POM.sendPrice1("50");
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	        Date date = new Date();
            String today = dateFormat.format(date); 
            WebElement startDate = driver.findElement(By.xpath("//input[@placeholder='Date Start']"));
            startDate.sendKeys(today);
            Calendar c = Calendar.getInstance(); 
            c.setTime(date); 
            c.add(Calendar.DATE, 1);
            Date datePlusOne = c.getTime();
            WebElement endDate = driver.findElement(By.xpath("//input[@placeholder='Date End']"));
            endDate.sendKeys(dateFormat.format(datePlusOne));             
            }
	           
	 @Test (priority=5)
	 public void validAddingProductTest5() throws InterruptedException {   
		 
		 	//Navigating to Reward Points tab
		 	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/ul[1]/li[10]/a[1]")).click(); //only absolute path works here as locator.
		 	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 	AdminRewardTC35POM.sendPoints("50");
		 	AdminRewardTC35POM.clickSaveBtn();
		 	
		 	//Validating Success message
		 	boolean modified = driver.getPageSource().contains("Success: You have modified products!");
			Assert.assertTrue(modified);
			screenShot.captureScreenShot("ModifyProducts");
			}
				
}
		  
        
        	        			
				     
	










