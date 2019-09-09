package com.training.pom;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class ForgotpassTC03POM {
		@SuppressWarnings("unused")
		private WebDriver driver; 
		
		public ForgotpassTC03POM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="input-email")
		private WebElement Email; 
		
		@FindBy(xpath="//input[@type='submit']")
		private WebElement ContBtn; 
				
		public void sendEmail(String email) {
			this.Email.clear();
			this.Email.sendKeys(email);
		}
		
		public void clickContBtn() {
			this.ContBtn.click(); 
		}
		
		}
		
		




