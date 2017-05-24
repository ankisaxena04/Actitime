package com.actitime.scripts;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.genericLib.BaseLib;
import com.actitime.genericLib.ExcelLib;
import com.actitime.pom.LoginPage;
import com.actitime.pom.TasksPage;

public class CreateCustAndProjTest extends BaseLib{
	@Test (priority=1)
	public void createCustomerTest(){
		LoginPage lp=new LoginPage(driver);
		String username=ExcelLib.readExcelData(3, 2);
		String password=ExcelLib.readExcelData(3, 3);
		String customerName=ExcelLib.readExcelData(3, 4);
		lp.login(username, password);
		wLib.implicitWaitForSeconds(driver, 20);
		TasksPage tp=new TasksPage(driver);
		tp.clickOnTasksPage();
		wLib.implicitWaitForSeconds(driver, 20);
		tp.clickOnProjAndCustLink();
		wLib.implicitWaitForSeconds(driver, 20);
		tp.createCustomer(customerName);
		wLib.implicitWaitForSeconds(driver, 20);
		tp.verifyCreateCustomerMsg();
	}
	@Test (priority=3)
	public void deleteCustomerTest(){
		LoginPage lp=new LoginPage(driver);
		String username=ExcelLib.readExcelData(3, 2);
		String password=ExcelLib.readExcelData(3, 3);
		lp.login(username, password);
		wLib.implicitWaitForSeconds(driver, 20);
		TasksPage tp=new TasksPage(driver);
		tp.clickOnTasksPage();
		wLib.implicitWaitForSeconds(driver, 20);
		tp.clickOnProjAndCustLink();
		wLib.implicitWaitForSeconds(driver, 20);
		tp.deleteCustomer();
		wLib.implicitWaitForSeconds(driver, 20);
		WebElement successMsg=tp.getSuccessMsg();
		wLib.explicitWait(driver, 20, successMsg);
		tp.verifyDeletedCustomerMsg();
	}
	@Test (priority=2)
	public void createProjectTest(){
		LoginPage lp=new LoginPage(driver);
		String username = ExcelLib.readExcelData(4, 2);
		String password = ExcelLib.readExcelData(4, 3);
		String customerName = ExcelLib.readExcelData(4, 4);
		String projectName = ExcelLib.readExcelData(4, 5);
		lp.login(username, password);
		wLib.implicitWaitForSeconds(driver, 20);
		TasksPage tp=new TasksPage(driver);
		tp.clickOnTasksPage();
		wLib.implicitWaitForSeconds(driver, 20);
		tp.clickOnProjAndCustLink();
		wLib.implicitWaitForSeconds(driver, 20);
		tp.createProject(customerName, projectName);
		wLib.implicitWaitForSeconds(driver, 20);
		tp.verifyCreateProjectMsg();
		Reporter.log("Project is successfully created", true);
	}
}
