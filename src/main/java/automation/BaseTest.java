package automation;

import org.openqa.selenium.WebDriver;

public class BaseTest {

	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();   
	
	public WebDriver createInstance() {
		
		return null;	
	}
	
}
