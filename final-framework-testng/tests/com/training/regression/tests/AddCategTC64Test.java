package com.training.regression.tests;


	import java.io.FileInputStream;
	import java.io.IOException;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;
	import java.util.Date;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	import com.training.dataproviders.AddCategTC64DataProviders;
	import com.training.generics.ScreenShot;
	import com.training.pom.AddCategTC64POM;
	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;


	public class AddCategTC64Test {
		
		private WebDriver driver;
		private String baseUrl1;
		private AddCategTC64POM AddCategTC64POM;
		private static Properties properties;
		private ScreenShot screenShot;
		WebDriverWait wait;
				
		@BeforeMethod
		public void setUpBeforeClass() throws IOException {
				properties = new Properties();
				FileInputStream inStream = new FileInputStream("./resources/others.properties");
				properties.load(inStream);
				driver = DriverFactory.getDriver(DriverNames.CHROME);
				AddCategTC64POM = new AddCategTC64POM(driver); 
				baseUrl1 = properties.getProperty("baseURL1");
				screenShot = new ScreenShot(driver); 
				driver.get(baseUrl1);
				wait = new WebDriverWait(driver, 5);
	}

		@AfterMethod
		public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();

		}
		
							
			 //Filling Login details
		
		
		
		@Test (dataProvider = "excel-inputs", dataProviderClass = AddCategTC64DataProviders.class)
		public void AddingCategoryTest(String CategoryName, String Description, String MetatagTitle, String MetatagDesc) throws InterruptedException {	

			//System.out.println("CategoryName:"+ CategoryName + "Description:"+ Description + "MetatagTitle:"+ MetatagTitle + "MetatagDesc:"+ MetatagDesc);
			//Logging in as Admin
			AddCategTC64POM.sendUsername("admin");
			AddCategTC64POM.sendPassword("admin@123"); 
			AddCategTC64POM.clickLoginBtn();
			
			//Adding Category list through data provider
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	        WebElement Catalog = driver.findElement(By.xpath("//i[@class='fa fa-tags fw']"));
	        Actions act  = new Actions(driver);
	        act.moveToElement(Catalog).build().perform();
	        driver.findElement(By.xpath("//li[@id='menu-catalog']//ul//li//a[contains(text(),'Categories')]")).click();
	        AddCategTC64POM.clickAddnewBtn();
	        AddCategTC64POM.sendCategoryName(CategoryName); 
	        AddCategTC64POM.sendMetatagTitle(MetatagTitle); 
	        AddCategTC64POM.sendMetatagDesc(MetatagDesc);
			AddCategTC64POM.clickSaveBtn();
			 	
			 	//Validating Success message
			 	boolean modified = driver.getPageSource().contains("Success: You have modified categories!");
				Assert.assertTrue(modified);
							
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
				String filename="RTTC64_"+df.format(new Date()).toString();
				System.out.println(filename);
		        screenShot.captureScreenShot(filename);
		        
				}
					
	}
			  
	        
	        	        			
					     
		













