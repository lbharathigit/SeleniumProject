package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
import com.training.pom.LoginOrderTC33POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


@SuppressWarnings("unused")
public class LoginOrderTC33Test {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginOrderTC33POM LoginOrderTC33POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			LoginOrderTC33POM = new LoginOrderTC33POM(driver); 
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
	public void validLoginOrderTC33Test() throws InterruptedException {
		
		//Opening Login Page
        WebElement accounticon=driver.findElement(By.xpath("//li[@class='tb_link dropdown tb_menu_system_account_account']"));
        Actions act=new Actions(driver);
        act.moveToElement(accounticon).build().perform();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[text()='LOGIN / REGISTER']")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
        //Filling Login details
        LoginOrderTC33POM.sendEmail("lbharathi@gmail.com");
        LoginOrderTC33POM.sendPassword("Angels12"); 
        LoginOrderTC33POM.clickLoginBtn();
        boolean Email = driver.getPageSource().contains("MY ACCOUNT");
		Assert.assertTrue(Email);
	}
        @Test (dependsOnMethods = { "validLoginOrderTC33Test" })
    	public void validPlaceOrderTest() throws InterruptedException {
    		        			
			//Selecting the Product
			driver.findElement(By.linkText("HOME")).click();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,2000)");
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	        driver.findElement(By.xpath("//div[@class='col col-xs-fill']//a[contains(text(),'lacinia congue')]")).click();
	        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	        
	        
	        //Adding to Cart
	        LoginOrderTC33POM.clickCartBtn();
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	         
	        //Checking out from cart
	        WebElement Carticon = driver.findElement(By.xpath("//i[@class='tb_icon ico-linea-ecommerce-bag']"));
	        Actions act = new Actions(driver);
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
	    	LoginOrderTC33POM.clickPayContBtn();
	    	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    	LoginOrderTC33POM.clickShipContBtn();
	    	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    	LoginOrderTC33POM.sendComment("This product is nice");
	    	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	    	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
			jse2.executeScript("window.scrollBy(0,350)");
			WebDriverWait wait1 = new WebDriverWait(driver, 20);
		    WebElement Shopcont = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-shipping-method")));
		    Shopcont.click();
	    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    	WebDriverWait wait2 = new WebDriverWait(driver, 20);
	    	WebElement agree = wait2.until(ExpectedConditions.elementToBeClickable(By.name("agree")));
	    	agree.click();
	    	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			LoginOrderTC33POM.clickPay1ContBtn();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			LoginOrderTC33POM.clickConfBtn();
			
			//Order confirmation Assertion
			String order = driver.findElement(By.xpath("//p[contains(text(),'Your order has been successfully processed!')]")).getText();
			Assert.assertEquals(order, "Your order has been successfully processed!");
			System.out.println(order);
			screenShot.captureScreenShot("OrderPlaced");
			
			//Shopping cart empty Assertion
			WebElement Carticon1 = driver.findElement(By.xpath("//i[@class='tb_icon ico-linea-ecommerce-bag']"));
	        Actions act1 = new Actions(driver);
	        act1.moveToElement(Carticon1).build().perform();
	        WebDriverWait wait3 = new WebDriverWait(driver, 20);
	        String Viewcart2 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='empty']"))).getText();
	    	Assert.assertEquals(Viewcart2, "Your shopping cart is empty!");
			System.out.println(Viewcart2);
			screenShot.captureScreenShot("cartempty");
		}
	}
