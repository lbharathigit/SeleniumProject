package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
import com.training.pom.GuestOrderTC34POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


@SuppressWarnings("unused")
public class GuestOrderTC34Test {
	
	private WebDriver driver;
	private String baseUrl;
	private GuestOrderTC34POM GuestOrderTC34POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			GuestOrderTC34POM = new GuestOrderTC34POM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			driver.get(baseUrl);
}

	@AfterClass
	public void tearDown() throws Exception {
	Thread.sleep(3000);
	driver.quit();

	}
	
	@Test
	public void validGuestOrderTC34Test() throws InterruptedException {
					
		//Selecting the Product
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1500)");
        driver.findElement(By.xpath("//a[contains(text(),'lacinia congue')]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
        //Adding to Cart
        GuestOrderTC34POM.clickCartBtn();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
        //Checking out from cart
        WebElement Carticon=driver.findElement(By.xpath("//i[@class='tb_icon ico-linea-ecommerce-bag']"));
        Actions act=new Actions(driver);
        act.moveToElement(Carticon).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement Viewcart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'View Cart')]")));
    	Viewcart.click();
    	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("window.scrollBy(0,250)");
		WebElement Checkout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//a[1][contains(text(), 'Checkout')]")));
    	Checkout.click();
    	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
    	
    	@Test (dependsOnMethods = { "validGuestOrderTC34Test" })
     	public void validCheckoutTest() throws InterruptedException {
    	
    		//Checkout as Guest User
    		WebElement guest = driver.findElement(By.xpath("//div[@id='collapse-checkout-option']//div[2]//label[1]//input[1]"));
        	guest.click();
        	GuestOrderTC34POM.clickActBtn();
        	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        	GuestOrderTC34POM.sendFirstName("Bharathi");
    		GuestOrderTC34POM.sendLastName("L"); 
    		GuestOrderTC34POM.sendEmail("bharathi@gmail.com"); 
    		GuestOrderTC34POM.sendTelephone("9941999419"); 
    		GuestOrderTC34POM.sendAddress1("20/46 Vivekananda st"); 
    		GuestOrderTC34POM.sendAddress2("MGR Nagar"); 
    		GuestOrderTC34POM.sendCity("Chennai"); 
    		GuestOrderTC34POM.sendPostcode("600084");
    		JavascriptExecutor jse = (JavascriptExecutor)driver;
    		jse.executeScript("window.scrollBy(0,300)");
    		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    		Select drpCountry = new Select (driver.findElement(By.id("input-payment-country")));
    		drpCountry.selectByVisibleText("India");
    		Select drpRegion = new Select (driver.findElement(By.id("input-payment-zone")));
    		drpRegion.selectByVisibleText("Tamil Nadu");
    		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    		GuestOrderTC34POM.clickGuestBtn();   
    		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    		GuestOrderTC34POM.sendComment("This product is nice");
	    	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	    	GuestOrderTC34POM.clickShipBtn();
	    	WebDriverWait wait = new WebDriverWait(driver, 20);
	    	WebElement agree = wait.until(ExpectedConditions.elementToBeClickable(By.name("agree")));
	    	agree.click();
	    	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    	GuestOrderTC34POM.clickPayBtn();
	    	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    	GuestOrderTC34POM.clickConfBtn();
    		
	    	//Order confirmation Assertion
			String order = driver.findElement(By.xpath("//p[contains(text(),'Your order has been successfully processed!')]")).getText();
			Assert.assertEquals(order, "Your order has been successfully processed!");
			System.out.println(order);
			screenShot.captureScreenShot("GuestOrderPlaced");
			
			//Shopping cart empty Assertion
			WebElement Carticon = driver.findElement(By.xpath("//i[@class='tb_icon ico-linea-ecommerce-bag']"));
	        Actions act = new Actions(driver);
	        act.moveToElement(Carticon).build().perform();
	        WebDriverWait wait1 = new WebDriverWait(driver, 20);
	        String Viewcart = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='empty']"))).getText();
	    	Assert.assertEquals(Viewcart, "Your shopping cart is empty!");
			System.out.println(Viewcart);
			screenShot.captureScreenShot("Guestcartempty");
    		
    		 		
				     }
	}









