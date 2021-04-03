package com.automation.coreUtilities;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	// Singleton design pattern to instantiate driver a.k.a once instance across the Flow
	
	public static DriverFactory instance;			// static reference to class and lazy instantiation
	
	private DriverFactory() {}						// Private Constructor to restrict object creation
	
	public static DriverFactory getInstance() {
		if(instance==null) {
			instance = new DriverFactory();
			synchronized (DriverFactory.class) {	// Double check lock
				if(instance==null) {
					instance = new DriverFactory();
				}
			}
		}
		return instance;
	}
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();	// Creating thread safe webdriver

	public WebDriver getDriver() {
		return driver.get();
	}

	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}
	
	public void closeBrowser() {
		driver.get().quit();
		driver.remove();
	}
}
