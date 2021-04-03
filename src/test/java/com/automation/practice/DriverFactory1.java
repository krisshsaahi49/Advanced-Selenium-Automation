package com.automation.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory1 {

	private DriverFactory1() {
		// Do-nothing..Do not allow to initialize this class from outside
	}

	private static DriverFactory1 instance = new DriverFactory1();

	public static DriverFactory1 getInstance() {
		return instance;
	}

	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver

	{

		@Override
		protected WebDriver initialValue() {
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver(); // can be replaced with other browser drivers
		}
	};

	public void setDriver() {
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
	}

	public WebDriver getDriver() // call this method to get the driver object and launch the browser
	{
		return driver.get();
	}

	public void removeDriver() // Quits the driver and closes the browser
	{
		driver.get().quit();
		driver.remove();
	}
}