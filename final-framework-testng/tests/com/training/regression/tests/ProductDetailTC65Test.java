package com.training.regression.tests;

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
import com.training.pom.ProductDetailTC65POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


@SuppressWarnings("unused")

public class ProductDetailTC65Test {
	
	private WebDriver driver;
	private String baseUrl1;
	private String baseUrl;
	private ProductDetailTC65POM ProductDetailTC65POM;
	private static Properties properties;
	private ScreenShot screenShot;
	WebDriverWait wait;
	
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			ProductDetailTC65POM = new ProductDetailTC65POM(driver); 
			baseUrl1 = properties.getProperty("baseURL1");
			baseUrl = properties.getProperty("baseURL");
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
		ProductDetailTC65POM.sendUsername("admin");
		ProductDetailTC65POM.sendPassword("admin@123"); 
		ProductDetailTC65POM.clickLoginBtn();
	}
	
	@Test (priority=1)
	public void validAddingProductTest1() throws InterruptedException {	

		//Navigating to General tab
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement Catalog = driver.findElement(By.xpath("//i[@class='fa fa-tags fw']"));
        Actions act  = new Actions(driver);
        act.moveToElement(Catalog).build().perform();
        driver.findElement(By.xpath("//li[@id='menu-catalog']//ul//li//a[contains(text(),'Products')]")).click();
        ProductDetailTC65POM.clickAddnewBtn();
        ProductDetailTC65POM.sendProdname("SasmitaRing"); 
        JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)");
		ProductDetailTC65POM.sendMetaname("Finger Ring for Ladies"); 
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("window.scrollBy(0,-300)");
		
	}
	
	@Test (priority=2)
	public void validAddingProductTest2() throws InterruptedException {
		
		//Navigating to Data tab
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Data')]")).click();
		ProductDetailTC65POM.sendModname("SKU-012");
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("window.scrollBy(0,400)");
		ProductDetailTC65POM.sendPrice("500");
		ProductDetailTC65POM.sendQuantity("60");
		JavascriptExecutor jse3 = (JavascriptExecutor)driver;
		jse3.executeScript("window.scrollBy(0,-400)");
		}
				
	@Test (priority=3)
	public void validAddingProductTest3() throws InterruptedException {
			
		//Navigating to Link tab
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Links')]")).click();
		ProductDetailTC65POM.sendCategory("EARRINGS");
		ProductDetailTC65POM.clickSaveBtn();
		 	
		 //Validating Success message
		 boolean modified = driver.getPageSource().contains("Success: You have modified products!");
		Assert.assertTrue(modified);
		screenShot.captureScreenShot("ProductAdded");
		//Logout as admin
		ProductDetailTC65POM.clickLogoutBtn();	
		
			}
		
	@Test (priority=4)
	public void DisplayProductTest() throws InterruptedException {
			
		//Verifying added product on the home page
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		boolean product = driver.getPageSource().contains("SasmitaRing");
		Assert.assertTrue(product);
		System.out.println("Product is displayed");
		screenShot.captureScreenShot("ProductDisplay");
		
	}
	
}
			
				     
	














