package org02.demoblazeWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class DemoBlaze02CartPage extends SeleniumUtility{
	public DemoBlaze02CartPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//button[text()='Place Order']")
	private WebElement orderPlaceBtn;
	public void clickPlaceOrderBtn() {
		clickOnElement(orderPlaceBtn);
	}
	
	@FindBy(id="name")
	private WebElement nameField;
	public void enterName(String name) {
		typeInput(nameField,name);
	}
	
	@FindBy(id="country")
	private WebElement countryField;
	public void enterCountry(String country) {
		typeInput(countryField,country);
	}
	
	@FindBy(id="city")
	private WebElement cityField;
	public void enterCity(String city) {
		typeInput(cityField,city);
	}
	
	@FindBy(id="card")
	private WebElement cardField;
	public void enterCard(String cardDetails) {
		typeInput(cardField,cardDetails);
	}
	
	@FindBy(css="#month")
	private WebElement monthField;
	public void enterMonth(String month) {
		typeInput(monthField,month);
	}
	
	@FindBy(css="year")
	private WebElement yearField;
	public void enterYear(String year) {
		typeInput(yearField,year);
	}
	
	@FindBy(xpath="//button[@onClick='purchaseOrder()']")
	private WebElement purchaseButton;
	public void clickOnPurchaseButton() {
		clickOnElement(purchaseButton);
		//driver.switchTo().alert().accept();
	}
	
	@FindBy(xpath="//div[@id='exampleModal']/div/div/div[3]/button[1]")
	private WebElement closeButton;
	public void clickOnCloseButton() {
		clickOnElement(closeButton);
	}
	
	@FindBy(xpath="//h2[text()='Thank you for your purchase!']")
	private WebElement msg;
	public void orderPlaceMessage() {
		isElementExist(msg);
	}
}
