package com.actitime.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class BaseLib {
	public WebDriver driver;
	public WaitStatementLib wLib;
	public SoftAssert sAssert;
	
	@BeforeClass
	
	public void preCondition() throws Exception{
		driver = browserSetup.startBrowser("chrome", "http://newtours.demoaut.com");
		
		Reporter.log("Navigating to the actitime url", true);
		wLib=new WaitStatementLib();
		wLib.implicitWaitForSeconds(driver, 20);
		sAssert=new SoftAssert();
	}
	@AfterClass
	public void postCondition(ITestResult result){
		if (result.isSuccess()) {
		}
		else{
			String fileName=result.getMethod().getMethodName();
			ScreenshotLib sLib=new ScreenshotLib();
			sLib.getScreenshot(driver, fileName);
			Reporter.log("Screenshot taken", true);
		}
		driver.quit();
		Reporter.log("browsers closed", true);
	}
}
