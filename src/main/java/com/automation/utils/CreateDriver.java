package com.automation.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CreateDriver {
	// local variables
	private static CreateDriver instance = null;
	private String browserHandle = null;
	private static final int IMPLICIT_TIMEOUT = 0;

	private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	private ThreadLocal<AppiumDriver<MobileElement>> mobileDriver = new ThreadLocal<AppiumDriver<MobileElement>>();

	private ThreadLocal<String> sessionId = new ThreadLocal<String>();

	private ThreadLocal<String> sessionBrowser = new ThreadLocal<String>();

	private ThreadLocal<String> sessionPlatform = new ThreadLocal<String>();

	private ThreadLocal<String> sessionVersion = new ThreadLocal<String>();

	private String getEnv = null;

	private CreateDriver() {

	}

	public static CreateDriver getInstance() {
		if (instance == null) {
			instance = new CreateDriver();
		}
		return instance;
	}

	/**
	 * setDriver method
	 *
	 * @param browser
	 * @param environment
	 * @param platform
	 * @param optPreferences
	 * @throws Exception
	 */
	@SafeVarargs
	public final void setDriver(String browser, String environment, String platform,
			Map<String, Object>... optPreferences) throws Exception {

		String getPlatform = null;

		switch (browser) {
		case "firefox":
			webDriver.set(new FirefoxDriver());
			break;
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> chromePrefs = new HashMap<String, Object>();

			chromePrefs.put("credentials_enable_service", false);
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("--disable-plugins", "--disable-extensions", "--disable-popup-blocking",
					"--maximized");
			webDriver.set(new ChromeDriver(options));
			break;
		case "internet explorer":
			webDriver.set(new InternetExplorerDriver());
			break;
		case "safari":
			webDriver.set(new SafariDriver());
			break;
		case "microsoftedge":
			webDriver.set(new EdgeDriver());
			break;
		case "iphone":
		case "ipad":
			if (browser.equalsIgnoreCase("ipad")) {

			}

			else {

			}

			break;
		case "android":

			break;
		}
	}

	public void setDriver(WebDriver driver) {
		webDriver.set(driver);

		sessionId.set(getSessionId().toString());

		sessionBrowser.set("");

		sessionPlatform.set(getSessionPlatform().toString());

//		setBrowserHandle(getDriver().getWindowHandle());
	}

	/**
	 * getDriver method will retrieve the active WebDriver
	 *
	 * @return WebDriver
	 */
	public WebDriver getDriver() {
		return webDriver.get();
	}

	/**
	 * getDriver method will retrieve the active AppiumDriver
	 *
	 * @param mobile boolean parameter
	 * @return AppiumDriver
	 */
	public AppiumDriver<MobileElement> getDriver(boolean mobile) {
		return mobileDriver.get();
	}

	/**
	 * getCurrentDriver method will retrieve the active WebDriver or AppiumDriver
	 *
	 * @return WebDriver
	 */
	public WebDriver getCurrentDriver() {
		if (getInstance().getSessionBrowser().contains("iphone") || getInstance().getSessionBrowser().contains("ipad")
				|| getInstance().getSessionBrowser().contains("android")) {

			return getInstance().getDriver(true);
		}

		else {
			return getInstance().getDriver();
		}
	}

	/**
	 * driverWait method pauses the driver in seconds
	 *
	 * @param seconds to pause
	 */
	public void driverWait(long seconds) {
		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
		}

		catch (InterruptedException e) {
			// do something
		}
	}

	/**
	 * driverRefresh method reloads the current browser page
	 */
	public void driverRefresh() {
		getCurrentDriver().navigate().refresh();
	}

	/**
	 * closeDriver method quits the current active driver
	 */
	public void closeDriver() {
		try {
			getCurrentDriver().quit();
		}

		catch (Exception e) {
			// do something
		}
	}

	/**
	 * getSessionId method gets the browser or mobile id of the active session
	 *
	 * @return String
	 */
	public String getSessionId() {
		return sessionId.get();
	}

	/**
	 * getSessionBrowser method gets the browser or mobile type of the active
	 * session
	 *
	 * @return String
	 */
	public String getSessionBrowser() {
		return sessionBrowser.get();
	}

	/**
	 * getSessionVersion method gets the browser or mobile version of the active
	 * session
	 * 
	 * @return String
	 */
	public String getSessionVersion() {
		return sessionVersion.get();
	}

	/**
	 * getSessionPlatform method gets the browser or mobile platform of the active
	 * session
	 *
	 * @return String
	 */
	public String getSessionPlatform() {
		return sessionPlatform.get();
	}
}
