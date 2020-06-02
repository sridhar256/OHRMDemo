package com.gurudemo.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {
	
	WebDriver driver;
	//Actions action = new Actions(driver);

	public AddCustomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "menu_pim_viewPimModule")
	WebElement PIMlink;
	
	@FindBy(id = "menu_pim_addEmployee")
	WebElement AddCustomerLink;
	
	@FindBy(id = "firstName")
	WebElement FirstName;
	
	@FindBy(id = "lastName")
	WebElement LastName;
	
	@FindBy(id = "btnSave")
	WebElement Save;
	
	public void clickOnPIMlink() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", PIMlink);
	}
	
	public void clickOnAddCustomerlink() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", AddCustomerLink);
	}
	
	public void enterTextOnFirstname(String firstname) {
		FirstName.sendKeys(firstname);
	}
	
	public void enterTextOnLastname(String lastname) {
		LastName.sendKeys(lastname);
	}
	
	public void clickOnSave() {
		Save.click();
	}
	
	
	
	

}
