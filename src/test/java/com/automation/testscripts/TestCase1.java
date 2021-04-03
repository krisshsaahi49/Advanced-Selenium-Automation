package com.automation.testscripts;

import org.testng.annotations.Test;
import org.testng.Reporter;
import com.automation.coreUtilities.BaseTest;
import com.automation.coreUtilities.DriverFactory;

public class TestCase1  extends BaseTest{

	@Test
	public void test1() {
		DriverFactory.getInstance().getDriver().get("https://youtube.com");
		Reporter.log("Title : "+DriverFactory.getInstance().getDriver().getTitle());
	}
	
	@Test
	public void test2() {
		DriverFactory.getInstance().getDriver().get("https://bing.com");
		Reporter.log("Title : "+DriverFactory.getInstance().getDriver().getTitle());
	}
	
	@Test
	public void test3() {
		DriverFactory.getInstance().getDriver().get("https://yahoo.com");
		Reporter.log("Title : "+DriverFactory.getInstance().getDriver().getTitle());
	}
	
	@Test
	public void test4() {
		DriverFactory.getInstance().getDriver().get("https://google.com");
		Reporter.log("Title : "+DriverFactory.getInstance().getDriver().getTitle());
	}
	@Test
	public void test5() {
		DriverFactory.getInstance().getDriver().get("https://gmail.com");
		Reporter.log("Title : "+DriverFactory.getInstance().getDriver().getTitle());
	}
	
	@Test
	public void test6() {
		DriverFactory.getInstance().getDriver().get("https://redbus.com");
		Reporter.log("Title : "+DriverFactory.getInstance().getDriver().getTitle());
	}
}
