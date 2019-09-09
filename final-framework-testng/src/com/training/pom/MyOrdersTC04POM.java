package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrdersTC04POM {
	@SuppressWarnings("unused")
	private WebDriver driver; 
	
	public MyOrdersTC04POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement Email; 
	
	@FindBy(id="input-password")
	private WebElement Password;
		
	public void sendEmail(String email) {
		this.Email.clear();
		this.Email.sendKeys(email);
	}
	
	public void sendPassword(String password) {
		this.Password.clear(); 
		this.Password.sendKeys(password); 
	}
	
	}

