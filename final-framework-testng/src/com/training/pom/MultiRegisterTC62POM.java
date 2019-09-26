package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultiRegisterTC62POM {
	@SuppressWarnings("unused")
	private WebDriver driver; 
	
	public MultiRegisterTC62POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="firstname")
	private WebElement FirstName; 
	
	@FindBy(id="input-lastname")
	private WebElement LastName; 
	
	@FindBy(id="input-email")
	private WebElement Email; 
	
	@FindBy(id="input-telephone")
	private WebElement Telephone; 
	
	@FindBy(id="input-address-1")
	private WebElement Address1; 
	
	@FindBy(id="input-address-2")
	private WebElement Address2; 
	
	@FindBy(id="input-city")
	private WebElement City; 
	
	@FindBy(id="input-postcode")
	private WebElement PostalCode; 
	
	@FindBy(id="input-country")
	private WebElement Country; 
	
	@FindBy(id="input-zone")
	private WebElement Region; 
	
	@FindBy(id="input-password")
	private WebElement Password; 
	
	@FindBy(id="input-confirm")
	private WebElement ConfirmPassword; 
	
	@FindBy(name="agree")
	private WebElement agree; 
	
	@FindBy(xpath="//*[@id=\"System_nyHsmShk\"]/form/div/div[2]/input")
	private WebElement continueBtn; 
	
	public void sendFirstName(String firstname) {
		this.FirstName.clear();
		this.FirstName.sendKeys(firstname);
	}
	
	public void sendLastName(String lastname) {
		this.LastName.clear(); 
		this.LastName.sendKeys(lastname); 
	}
	
	public void sendEmail(String email) {
		this.Email.clear();
		this.Email.sendKeys(email);
	}
		
	public void sendTelephone(String telephone) {
		this.Telephone.clear();
		this.Telephone.sendKeys(telephone);
	}
	
	public void sendAddress1(String address1) {
		this.Address1.clear();
		this.Address1.sendKeys(address1);
	}
	
	public void sendAddress2(String address2) {
		this.Address2.clear();
		this.Address2.sendKeys(address2);
	}
	
	public void sendCity(String city) {
		this.City.clear();
		this.City.sendKeys(city);
	}
	
	public void sendPostalCode(String postcode) {
		this.PostalCode.clear();
		this.PostalCode.sendKeys(postcode);
	}
	
	public void sendCountry(String country) {
		this.Country.clear();
		this.Country.sendKeys(country);
	}
	
	public void sendRegion(String region) {
		this.Region.clear();
		this.Region.sendKeys(region);
	}
	
	public void sendPassword(String password) {
		this.Password.clear();
		this.Password.sendKeys(password);
	}
	
	public void sendConfirmPassword(String confirm) {
		this.ConfirmPassword.clear();
		this.ConfirmPassword.sendKeys(confirm);
		
	}

	public void clickcontinueBtn() {
		this.continueBtn.click(); 
	}
}



