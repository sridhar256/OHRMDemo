package com.gurudemo.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gurudemo.pageObjects.LoginPage;
import com.gurudemo.utilities.XLUtils;

public class TC_LoginTest_001 extends BaseClass {

	LoginPage loginpage;
	XLUtils utility = new XLUtils();
	HashMap<String, String> tcData;

	@Test
	public void LoginTest() throws IOException {
		
		tcData = utility.readDataFromExcel("tc1");
		
		logger.info("URL is opened");
		
		loginpage = new LoginPage(driver);

		loginpage.enterTextOnUsername(username);
		logger.info("Entered Username");
		
		//loginpage.enterTextOnPassword(password);
		loginpage.enterTextOnPassword(tcData.get("password"));
		logger.info("Entered Password");

		
		loginpage.clickOnLogin();
		logger.info("Clicked on Login");


		if (driver.getTitle().equalsIgnoreCase("OrangeHRM")) {
			Assert.assertTrue(true);
			logger.info("Login Test is Pass");

		} else {
			captureScreen(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("Login Test is Fail");

		}

	}

}
