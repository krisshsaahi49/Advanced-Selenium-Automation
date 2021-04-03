package automation;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class WebDriverListener implements IInvokedMethodListener {


	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("beforeInvocation");
		if (method.isTestMethod()) {
			String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
			WebDriver driver = LocalDriverFactory.createInstance(browserName);
			LocalDriverManager.setWebDriver(driver);
		}
	}

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("afterInvocation");
		if (method.isTestMethod()) {
			WebDriver driver = LocalDriverManager.getDriver();
			if (driver != null) {
				driver.quit();
			}
		}
	}
}
