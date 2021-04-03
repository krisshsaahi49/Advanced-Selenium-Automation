package com.automation.practice;

import org.openqa.selenium.WebDriver;

public class Test{

	@org.testng.annotations.Test
	public void main() {
		DriverFactory.setDriver();
		DriverFactory.getDriver().get("https://google.com");
		DriverFactory.closeBrowser();
	}

	
	@org.testng.annotations.Test
	public void test1() {
		WebDriver driver = DriverFactory1.getInstance().getDriver();
		driver.get("https://bing.com");
		System.out.println(driver.getTitle());
		DriverFactory1.getInstance().removeDriver();
	}
	
}
