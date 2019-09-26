
	package com.training.pom;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class AddCategTC64POM {
		@SuppressWarnings("unused")
		private WebDriver driver; 
		
		public AddCategTC64POM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="input-username")
		private WebElement Username; 
		
		@FindBy(id="input-password")
		private WebElement Password;
			
		@FindBy(xpath="//button[@class='btn btn-primary']")
		private WebElement LoginBtn; 
		
		@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
		private WebElement AddnewBtn;
		
		@FindBy(id="input-name1")
		private WebElement CategoryName; 
		
		@FindBy(id="//div[@class='note-editable panel-body']")
		private WebElement Description; 
		
		@FindBy(id="input-meta-title1")
		private WebElement MetatagTitle; 
		
		@FindBy(id="input-meta-description1")
		private WebElement MetatagDesc; 
		
		@FindBy(xpath="//i[@class='fa fa-save']")
		private WebElement SaveBtn;
		
		public void sendUsername(String username) {
			this.Username.clear();
			this.Username.sendKeys(username);
		}
		
		public void sendPassword(String password) {
			this.Password.clear(); 
			this.Password.sendKeys(password); 
				}
		public void clickLoginBtn() {
			this.LoginBtn.click(); 
		}
		
		public void clickAddnewBtn() {
			this.AddnewBtn.click(); 
		}
		
		public void sendCategoryName(String CategoryName) {
			this.CategoryName.clear();
			this.CategoryName.sendKeys(CategoryName);
		}
		
		public void sendDescription(String Description) {
			this.Description.clear();
			this.Description.sendKeys(Description);
		}
		
		public void sendMetatagTitle(String MetatagTitle) {
			this.MetatagTitle.clear();
			this.MetatagTitle.sendKeys(MetatagTitle);
		}
		
		public void sendMetatagDesc(String MetatagDesc) {
			this.MetatagDesc.clear();
			this.MetatagDesc.sendKeys(MetatagDesc);
		}
		
		public void clickSaveBtn() {
			this.SaveBtn.click(); 
		}
		
	}


