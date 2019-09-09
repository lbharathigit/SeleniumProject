package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationTC01POM {
	private WebDriver driver; 
	
	public RegistrationTC01POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstname; 
	
	@FindBy(id="input-lastname")
	private WebElement lastname; 
	
	@FindBy(id="input-email")
	private WebElement email; 
	
	@FindBy(id="input-telephone")
	private WebElement telephone; 
	
	@FindBy(id="input-address-1")
	private WebElement address1; 
	
	@FindBy(id="input-address-2")
	private WebElement address2; 
	
	@FindBy(id="input-city")
	private WebElement city; 
	
	@FindBy(id="input-postcode")
	private WebElement postcode; 
	
	@FindBy(id="input-country")
	private WebElement country; 
	
	@FindBy(id="input-zone")
	private WebElement zone; 
	
	@FindBy(name="password")
	private WebElement password; 
	
	@FindBy(name="confirm")
	private WebElement confirm; 
	
	@FindBy(name="newsletter")
	private WebElement newsletter; 
	
	@FindBy(name="agree")
	private WebElement agree; 
	
	@FindBy(xpath="//*[@id=\"System_nyHsmShk\"]/form/div/div[2]/input")
	private WebElement continueBtn; 
	
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
	
	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void sendConfirm(String confirm) {
		this.confirm.clear();
		this.confirm.sendKeys(confirm);
	}
	
	public void clickcontinueBtn() {
		this.continueBtn.click(); 
	}
}
