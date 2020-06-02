package com.gurudemo.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gurudemo.pageObjects.AddCustomer;
import com.gurudemo.pageObjects.LoginPage;
import com.gurudemo.utilities.XLUtils;

public class TC_AddCustomer_002 extends BaseClass {

	LoginPage loginpage;
	AddCustomer addcustomer;
	XLUtils utility = new XLUtils();
	HashMap<String, String> tcData;

	@Test(priority = 2)
	public void AddCustomerTest() throws FileNotFoundException, IOException, InterruptedException {

		tcData = utility.readDataFromExcel("tc1");

		logger.info("URL is opened");

		loginpage = new LoginPage(driver);

		loginpage.enterTextOnUsername(username);
		logger.info("Entered Username");

		// loginpage.enterTextOnPassword(password);
		loginpage.enterTextOnPassword(tcData.get("password"));
		logger.info("Entered Password");

		loginpage.clickOnLogin();
		logger.info("Clicked on Login");
		
		Thread.sleep(2000);

		addcustomer = new AddCustomer(driver);
		addcustomer.clickOnPIMlink();
		logger.info("Clicked on PIM Link");

		addcustomer.clickOnAddCustomerlink();
		logger.info("Clicked on AddCustomer Link");

		addcustomer.enterTextOnFirstname(tcData.get("firstname"));
		logger.info("Entered Firstname");

		addcustomer.enterTextOnLastname(tcData.get("lastname"));
		logger.info("Entered Lastname");

		addcustomer.clickOnSave();
		logger.info("Clicked on Save");

	}

}
