package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailTC65POM {
	@SuppressWarnings("unused")
	private WebDriver driver; 
	
	public ProductDetailTC65POM(WebDriver driver) {
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
	private WebElement Prodname; 
	
	@FindBy(id="input-meta-title1")
	private WebElement Metaname; 
	
	@FindBy(id="input-price")
	private WebElement Price; 
	
	@FindBy(id="input-quantity")
	private WebElement Quantity; 
	
	@FindBy(id="input-model")
	private WebElement Modname; 
	
	@FindBy(id="input-category")
	private WebElement Category; 
	
	@FindBy(xpath="//table[@id='discount']//button[@class='btn btn-primary']")
	private WebElement DiscBtn;
	
	@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Quantity']")
	private WebElement Quantity1;
	
	@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Price']")
	private WebElement Price1;
	
	@FindBy(id="input-points")
	private WebElement Points;
	
	@FindBy(xpath="//div[@class='pull-right']//button[@class='btn btn-primary']")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//span[@class='hidden-xs hidden-sm hidden-md']")
	private WebElement LogoutBtn;
	
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
	
	public void sendProdname(String prodname) {
		this.Prodname.clear();
		this.Prodname.sendKeys(prodname);
	}
	
	public void sendMetaname(String metaname) {
		this.Metaname.clear();
		this.Metaname.sendKeys(metaname);
	}
	
	public void sendModname(String modname) {
		this.Modname.clear();
		this.Modname.sendKeys(modname);
	}
	
	public void sendPrice(String price) {
		this.Price.clear();
		this.Price.sendKeys(price);
	}
	
	public void sendQuantity(String quantity) {
		this.Quantity.clear();
		this.Quantity.sendKeys(quantity);
	}
	
	public void sendCategory(String category) {
		this.Category.clear();
		this.Category.sendKeys(category);
	}
	
	public void clickDiscBtn() {
		this.DiscBtn.click(); 
	}
	
	public void sendQuantity1(String quantity1) {
		this.Quantity1.clear();
		this.Quantity1.sendKeys(quantity1);
	}
	
	public void sendPrice1(String price1) {
		this.Price1.clear();
		this.Price1.sendKeys(price1);
	}
	
	public void sendPoints(String points) {
		this.Points.clear();
		this.Points.sendKeys(points);
			}
	public void clickSaveBtn() {
		this.SaveBtn.click(); 
	}
	
	public void clickLogoutBtn() {
		this.LogoutBtn.click(); 
	}
	
}