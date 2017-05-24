package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;


public class LoginPage {
	@FindBy(name="username")
	private WebElement unTxtBx;
	@FindBy(name="pwd")
	private WebElement pwdTxtBx;
	@FindBy(id="loginButton")
	private WebElement loginBtn;
	@FindBy(className="errormsg")
	private WebElement errorMsg;
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public void login(String username, String password){
		unTxtBx.sendKeys(username);
		pwdTxtBx.sendKeys(password);
		loginBtn.click();
	}
	
	public WebElement getErrorMsg() {
		return errorMsg;
	}
	public void verifyErrorMsg(){
		Assert.assertTrue(errorMsg.isDisplayed(), "error msg is not displayed");
		Reporter.log("Error Msg is displayed", true);
	}
}