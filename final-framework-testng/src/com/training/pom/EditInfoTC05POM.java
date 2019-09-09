	package com.training.pom;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class EditInfoTC05POM {
		@SuppressWarnings("unused")
		private WebDriver driver; 
		
		public EditInfoTC05POM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="input-firstname")
		private WebElement firstname; 
		
		@FindBy(id="input-lastname")
		private WebElement lastname; 
		
		@FindBy(id="input-email")
		private WebElement Email; 
		
		@FindBy(id="input-telephone")
		private WebElement Telephone;
		
		@FindBy(xpath="//input[@type='submit']")
		private WebElement ContBtn; 
			
			public void sendFirstName(String firstname) {
			this.firstname.clear();
			this.firstname.sendKeys(firstname);
		}
		
		public void sendLastName(String lastname) {
			this.lastname.clear(); 
			this.lastname.sendKeys(lastname); 
		}
		
		public void sendEmail1(String email) {
			this.Email.clear();
			this.Email.sendKeys(email);
		}
			
		public void sendTelephone(String Telephone) {
			this.Telephone.clear();
			this.Telephone.sendKeys(Telephone);
		}
		
		public void clickContBtn() {
			this.ContBtn.click(); 
		}
		
		}




