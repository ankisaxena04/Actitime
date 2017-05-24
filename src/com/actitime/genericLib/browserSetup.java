package com.actitime.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

public class browserSetup {
	static WebDriver driver;
	@Parameters("browser")
	public static WebDriver startBrowser(String browserName, String URL) throws Exception{		
			
		if(browserName.equalsIgnoreCase("firefox")){
			
			driver = new FirefoxDriver();
		
		}
		else if(browserName.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\as251039\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}
	
			
		driver.get(URL);
		return driver;
				
	}


}
