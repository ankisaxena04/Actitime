package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage {
	private String homePageTitle;
	public EnterTimeTrackPage(WebDriver driver){
		homePageTitle=driver.getTitle();
	}
	public void verifyHomePageTitle(){
		Assert.assertEquals("actiTIME - Enter Time-Track", homePageTitle, "home page title is not verfied");
		Reporter.log("Home page title is verified", true);
	}
}
