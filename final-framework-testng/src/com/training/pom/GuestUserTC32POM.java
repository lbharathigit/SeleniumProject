package com.training.pom;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class GuestUserTC32POM {
		@SuppressWarnings("unused")
		private WebDriver driver; 
		
		public GuestUserTC32POM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="button-cart")
		private WebElement CartBtn; 
				
	
		public void clickCartBtn() {
			this.CartBtn.click();
		}
		
			
		}
		
	
	
		
		







