package automation;

import org.openqa.selenium.WebDriver;

public class LocalDriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver() {
		System.out.println("getDriver");
		return driver.get();
	}
	
	static void setWebDriver(WebDriver uidriver) {
		System.out.println("setDriver");
        driver.set(uidriver);
    } 
}
