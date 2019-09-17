package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GuestOrderTC34POM {
	@SuppressWarnings("unused")
	private WebDriver driver; 
	
	public GuestOrderTC34POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="button-cart")
	private WebElement CartBtn; 
	
	@FindBy(id="button-account")
	private WebElement ActBtn;
	
	@FindBy(id="input-payment-firstname")
	private WebElement firstname; 
	
	@FindBy(id="input-payment-lastname")
	private WebElement lastname; 
	
	@FindBy(id="input-payment-email")
	private WebElement email; 
	
	@FindBy(id="input-payment-telephone")
	private WebElement telephone; 
	
	@FindBy(id="input-payment-address-1")
	private WebElement address1; 
	
	@FindBy(id="input-payment-address-2")
	private WebElement address2; 
	
	@FindBy(id="input-payment-city")
	private WebElement city; 
	
	@FindBy(id="input-payment-postcode")
	private WebElement postcode; 
	
	@FindBy(id="input-payment-country")
	private WebElement country; 
	
	@FindBy(id="input-payment-zone")
	private WebElement zone;
	
	@FindBy(id="button-guest")
	private WebElement GuestBtn; 
	
	@FindBy(name="comment")
	private WebElement Comment; 
	
	@FindBy(id="button-shipping-method")
	private WebElement ShipBtn;
		
	@FindBy(id="button-payment-method")
	private WebElement PayBtn;
	
	@FindBy(id="button-confirm")
	private WebElement ConfBtn;

	public void clickCartBtn() {
		this.CartBtn.click();
	}
	
	public void clickActBtn() {
		this.ActBtn.click();
	}
		
	public void sendFirstName(String firstname) {
		this.firstname.clear();
		this.firstname.sendKeys(firstname);
	}
	
	public void sendLastName(String lastname) {
		this.lastname.clear(); 
		this.lastname.sendKeys(lastname); 
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
		
	public void sendTelephone(String telephone) {
		this.telephone.clear();
		this.telephone.sendKeys(telephone);
	}
	
	public void sendAddress1(String address1) {
		this.address1.clear();
		this.address1.sendKeys(address1);
	}
	
	public void sendAddress2(String address2) {
		this.address2.clear();
		this.address2.sendKeys(address2);
	}
	
	public void sendCity(String city) {
		this.city.clear();
		this.city.sendKeys(city);
	}
	
	public void sendPostcode(String postcode) {
		this.postcode.clear();
		this.postcode.sendKeys(postcode);
	}
	
	public void clickGuestBtn() {
		this.GuestBtn.click();
	}
	
	public void sendComment(String comment) {
		this.Comment.clear();
		this.Comment.sendKeys(comment);
	}
	
	public void clickShipBtn() {
		this.ShipBtn.click();
	}
	
	public void clickPayBtn() {
		this.PayBtn.click();
	}
	
	public void clickConfBtn() {
		this.ConfBtn.click();
	}
	
	}
	


