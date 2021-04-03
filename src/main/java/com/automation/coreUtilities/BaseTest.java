package com.automation.coreUtilities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	@BeforeMethod
	public void setup() {
		DriverFactory.getInstance().setDriver((new BrowserFactory()).createDriver("chrome"));
//		DriverFactory.getInstance().getDriver().get("https://google.com");
	}
	
	@AfterMethod
	public void teardown() {
		DriverFactory.getInstance().getDriver().close();
//		DriverFactory.getInstance().closeBrowser();
	}
	
}
