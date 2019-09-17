package com.training.pom;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class InvalidLoginTC31POM {
		@SuppressWarnings("unused")
		private WebDriver driver; 
		
		public InvalidLoginTC31POM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="input-email")
		private WebElement Email; 
				
		@FindBy(id="input-password")
		private WebElement Password;
		
		@FindBy(xpath="//input[@type='submit']")
		private WebElement LoginBtn; 
					
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
		
	}
	
		
		




