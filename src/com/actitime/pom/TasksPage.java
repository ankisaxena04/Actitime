package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class TasksPage extends BasePage{
	@FindBy(xpath="//a[contains(text(),'Projects')]")
	private WebElement projAndCustLink;
	@FindBy(xpath="//input[@value='Create New Customer']")
	private WebElement createNewCustBtn;
	@FindBy(name="name")
	private WebElement custNameTxtBx;
	@FindBy(name="createCustomerSubmit")
	private WebElement createCustSubmitBtn;
	@FindBy(className="successmsg")
	private WebElement successMsg;
	@FindBy(xpath="//a[text()='HDFC']/../../../../../..//input")
	private WebElement custHdfcChkbx;
	@FindBy(xpath="//input[@value='Delete Selected']")
	private WebElement delSelectdBtn;
	@FindBy(id="deleteButton")
	private WebElement delCustBtn;
	private String deleteCustMsg;
	@FindBy(xpath="//input[@value='Create New Project']")
	private WebElement createNewProjBtn;
	@FindBy(name="customerId")
	private WebElement selCustDropdwn;
	@FindBy(name="name")
	private WebElement projNameTxtBx;
	@FindBy(name="createProjectSubmit")
	private WebElement createProjSubmitBtn;
	
	public TasksPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public WebElement getSuccessMsg() {
		return successMsg;
	}

	public void clickOnProjAndCustLink(){
		projAndCustLink.click();
	}
	public void createCustomer(String customerName){
		createNewCustBtn.click();
		custNameTxtBx.sendKeys(customerName);
		createCustSubmitBtn.click();
	}
	
	public void verifyCreateCustomerMsg(){
		Assert.assertTrue(successMsg.isDisplayed(), "create Customer msg is not displayed");
		Reporter.log("Create Customer msg is displayed", true);
	}
	public void deleteCustomer(){
		custHdfcChkbx.click();
		delSelectdBtn.click();
		delCustBtn.click();
	}
	public void verifyDeletedCustomerMsg(){
		deleteCustMsg=successMsg.getText();
		Assert.assertEquals("Selected customers and projects have been successfully deleted.", deleteCustMsg , "deleted customer msg is not displayed");
		Reporter.log("Deleted customer msg is displayed", true);
	}
	public void createProject(String customerName, String projectName){
		createNewProjBtn.click();
		Select sel=new Select(selCustDropdwn);
		sel.selectByVisibleText(customerName);
		projNameTxtBx.sendKeys(projectName);
		createProjSubmitBtn.click();
	}
	public void verifyCreateProjectMsg(){
		
		Assert.assertTrue(successMsg.isDisplayed(), "Create project msg is not displayed");
		Reporter.log("Create project msg is displayed", true);
	}

}
