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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import org.testng.asserts.*;



@SuppressWarnings("unused")
public class MyOrdersTC04Test {
	
	private WebDriver driver;
	private String baseUrl;
	private MyOrdersTC04POM MyOrdersTC04POM;
	private LoginTC02POM LoginTC02POM;
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
	MyOrdersTC04POM = new MyOrdersTC04POM(driver); 
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
	public void validMyOdersTC04Test() throws InterruptedException 
	{
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
		driver.findElement(By.xpath("//input[@type='submit']")).click();	
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
	    // Navigating to My Orders page
	    WebElement accounticon1=driver.findElement(By.xpath("//i[@class='fa fa-user-o']"));
        Actions act1=new Actions(driver);
        act1.moveToElement(accounticon1).build().perform();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[text()='MY ORDERS']")).click();
        
		//Verifying the order details
        WebElement table = driver.findElement(By.xpath("//table[@class='table table-hover']")); 
     	List<WebElement> allRows = table.findElements(By.tagName("tr")); 
     	//System.out.println(allRows.size());
      	for (WebElement row : allRows) 
      	{ 
      		List<WebElement> cells = row.findElements(By.tagName("td")); 
      		
     		// Print the contents Order Table
	     	for (WebElement cell : cells) 
	     	{ 
	     		System.out.print(cell.getText()+"\t");
	        }
	        System.out.println();
      	}  
      	System.out.println("\n");
      	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      	
	     //Verifying the order details
        driver.findElement(By.xpath("//i[@class='fa fa-eye']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement table1 = driver.findElement(By.xpath("//td[text()='Order Details']/parent::tr/parent::thead/parent::table")); 
     	List<WebElement> allRows1 = table1.findElements(By.tagName("tr")); 
     	for (WebElement row1: allRows1) { 
     	List<WebElement> cells1 = row1.findElements(By.tagName("td")); 
     	
		// Print the contents of Order Details
     	for (WebElement cell1 : cells1) { 
     	System.out.print(cell1.getText()+"\t");
        }
        System.out.println();
     	}
     	System.out.println("\n");
     	
        // Assert Expected Result
        String str = driver.findElement(By.xpath("//td[text()='Order Details']")).getText();
        Assert.assertEquals(str, "Order Details");
        System.out.println("Test Passed");
        screenShot.captureScreenShot("OrderDetails");    
     	}
	}






