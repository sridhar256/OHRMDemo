package com.gurudemo.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.gurudemo.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) {

		logger = Logger.getLogger("Ohrm");
		PropertyConfigurator.configure("Log4j.properties");

		if (browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxpath());
			driver = new FirefoxDriver();

		} else if (browser.equals("ie")) {

			System.setProperty("webdriver.ie.driver", readconfig.getiepath());
			driver = new InternetExplorerDriver();

		}

		driver.get(baseURL);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/ScreenShots" + tname + ".png" );
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

}
