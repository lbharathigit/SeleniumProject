package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrderTC33POM {
	@SuppressWarnings("unused")
	private WebDriver driver; 
	
	public LoginOrderTC33POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement Email; 
	
	@FindBy(id="input-password")
	private WebElement Password;
		
	@FindBy(xpath="//input[@type='submit']")
	private WebElement LoginBtn; 
	
	@FindBy(id="button-cart")
	private WebElement CartBtn;
	
	@FindBy(id="button-payment-address")
	private WebElement PayContBtn;
	
	@FindBy(id="button-shipping-address")
	private WebElement ShipContBtn;
	
	@FindBy(name="comment")
	private WebElement Comment; 
	
	@FindBy(name="button-shipping-method")
	private WebElement Ship1ContBtn; 

	@FindBy(id="button-payment-method")
	private WebElement Pay1ContBtn;
	
	@FindBy(id="button-confirm")
	private WebElement ConfBtn;
	
	public void sendEmail(String email) {
		this.Email.clear();
		this.Email.sendKeys(email);
	}
	
	public void sendPassword(String password) {
		this.Password.clear(); 
		this.Password.sendKeys(password); 
			}
	public void clickLoginBtn() {
		this.LoginBtn.click(); 
	}
	
	public void clickCartBtn() {
		this.CartBtn.click();
	}
	
	public void clickPayContBtn() {
		this.PayContBtn.click();
	}
		
	public void clickShipContBtn() {
		this.ShipContBtn.click();
	}
	
	public void sendComment(String comment) {
		this.Comment.clear();
		this.Comment.sendKeys(comment);
	}
	
	public void clickPay1ContBtn() {
		this.Pay1ContBtn.click();
	}
	
	public void clickConfBtn() {
		this.ConfBtn.click();
	}
	
	}



