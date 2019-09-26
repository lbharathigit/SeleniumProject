package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

@SuppressWarnings("unused")
public class LoginExcelTest {
	private WebDriver driver;
	private String baseUrl1;
	private LoginPOM loginPOM;
	private static Properties properties;
	@SuppressWarnings("unused")
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
		loginPOM = new LoginPOM(driver);
		baseUrl1 = properties.getProperty("baseURL1");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl1);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String userName, String password) throws InterruptedException {
		loginPOM.sendUserName(userName);
		loginPOM.sendPassword(password);
		Thread.sleep(3000);
		//loginPOM.clickLoginBtn();
		//screenShot.captureScreenShot(userName);

	}

}