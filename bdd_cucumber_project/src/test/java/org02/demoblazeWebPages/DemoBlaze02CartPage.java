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
}
