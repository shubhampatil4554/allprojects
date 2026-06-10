package org02.demoblazeWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class DemoBlaze01HomePage extends SeleniumUtility {
	public DemoBlaze01HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="login2")
	private WebElement loginLink;
	public void clickOnLoginLink() {
		clickOnElement(loginLink);
	}
	
	@FindBy(id="loginusername")
	private WebElement username;
	@FindBy(id="loginpassword")
	private WebElement password;
	public void enterUsernamePassword() {
		typeInput(username,"pavanol");
		typeInput(password,"test@123");
	}
	public void usernamePassword(String usern,String pass) {
		typeInput(username,usern);
		typeInput(password,pass);
	}
	
	@FindBy(xpath="//button[@onclick='logIn()']")
	private WebElement loginButton;
	public void clickOnLoginbutton() {
	 clickOnElement(loginButton);	
	}
	
	@FindBy(id="nameofuser")
	private WebElement nameOfUser;
	public boolean verifyUserName() {
		String expectedName="Welcome pavanol";
		String actualName=getTextFromElement(nameOfUser);
		return actualName.equals(expectedName);
	}
	
	@FindBy(xpath="//a[text()='Samsung galaxy s6']")
	private WebElement product;
	@FindBy(xpath="//a[@onclick='addToCart(1)']")
	private WebElement addToCartButton;
	public void addToCartProduct() {
		clickOnElement(product);
		clickOnElement(addToCartButton);
		driver.switchTo().alert().accept();
	}
	
	@FindBy(id="cartur")
	private WebElement cartLink;
	public void clickOnCartLink() {
		clickOnElement(cartLink);
	}
	
	@FindBy(css="logout2")
	private WebElement logOutLink;
	public void clickOnLogoutLink(){
		clickOnElement(logOutLink);
	}
}
