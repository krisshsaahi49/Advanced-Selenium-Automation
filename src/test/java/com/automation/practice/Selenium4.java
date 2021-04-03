package com.automation.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium4 {

	@org.testng.annotations.Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://bing.com");
		
	}
}
