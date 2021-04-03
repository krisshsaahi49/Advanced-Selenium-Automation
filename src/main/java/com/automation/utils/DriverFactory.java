package com.automation.utils;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	static DriverFactory instance;
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	private DriverFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static DriverFactory getDriverInstance() {
		if(instance==null) {
			instance = new DriverFactory();
		}
		return instance;
	}
	
}
