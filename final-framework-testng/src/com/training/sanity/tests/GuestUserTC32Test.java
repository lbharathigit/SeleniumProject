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
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import com.training.generics.ScreenShot;
	import com.training.pom.GuestUserTC32POM;
	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;


	@SuppressWarnings("unused")
	public class GuestUserTC32Test {
		
		private WebDriver driver;
		private String baseUrl;
		private GuestUserTC32POM GuestUserTC32POM;
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
		GuestUserTC32POM = new GuestUserTC32POM(driver); 
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
		public void validGuestUserTC32Test() throws InterruptedException {
						
			//Selecting the Product
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,1500)");
	        driver.findElement(By.xpath("//a[contains(text(),'lacinia congue')]")).click();
	        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	        
	        //Adding to Cart
	        GuestUserTC32POM.clickCartBtn();
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
	    	
	    	//Login Page Assertion
	    	String Loginpage = driver.findElement(By.xpath("//legend[contains(text(),'Returning Customer')]")).getText();
			Assert.assertEquals(Loginpage, "Returning Customer");
			System.out.println("Login Page is dispayed");
			screenShot.captureScreenShot("LoginPage");
	        	        			
					     }
		}


	
	

