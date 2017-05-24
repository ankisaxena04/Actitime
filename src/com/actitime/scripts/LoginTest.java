package com.actitime.scripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.genericLib.BaseLib;
import com.actitime.genericLib.ExcelLib;
import com.actitime.pom.EnterTimeTrackPage;
import com.actitime.pom.LoginPage;
import com.actitime.pom.TasksPage;

public class LoginTest extends BaseLib {
	LoginPage lp;
	@Test (priority=1)
	public void loginTest() throws InterruptedException{
		lp=new LoginPage(driver);
		String username=ExcelLib.readExcelData(1, 2);
		String password=ExcelLib.readExcelData(1, 3);
		lp.login(username, password);
		wLib.implicitWaitForSeconds(driver, 20);
		TasksPage tp=new TasksPage(driver);
		WebElement logoutLink=tp.getLogoutLink();
		wLib.explicitWait(driver, 20, logoutLink);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.verifyHomePageTitle();
		
		Reporter.log("login successfully", true);
		tp.clickOnLogoutLink();
		Reporter.log("logout successfully", true);
//		Thread.sleep(3000);
//		String homePageTile=driver.getTitle();
//		Assert.assertEquals("actiTIME - Enter Time-Track", homePageTile, "home page title is not displayed");
		
	}
	
	@Test (priority=2, enabled=false)
	public void invalidLoginTest(){
		lp=new LoginPage(driver);
		String username=ExcelLib.readExcelData(2, 2);
		String password=ExcelLib.readExcelData(2, 3);
		lp.login(username, password);
		wLib.implicitWaitForSeconds(driver, 20);
		WebElement errorMsg=lp.getErrorMsg();
		wLib.explicitWait(driver, 20, errorMsg);
		lp.verifyErrorMsg();
	}
}
