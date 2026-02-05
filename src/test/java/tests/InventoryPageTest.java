package tests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.SauceDemoBaseClass;
import pages.InventoryPage;
import pages.LoginPage;
import utilis.ExtentManager;
import utilis.UtilityClass;

//TestPage-2
public class InventoryPageTest extends SauceDemoBaseClass {
	InventoryPage inventoryPageObj;
	static ExtentReports report;
	static ExtentTest test;
	
	@BeforeMethod
	public void preSteps() throws IOException {
		LoginPage loginPageObj = new LoginPage(driver);
		//loginPageObj.setUserName(UtilityClass.readDataFromPropertiesFile("userName"));
		//loginPageObj.setPassword(UtilityClass.readDataFromPropertiesFile("password"));
		loginPageObj.setUserName("standard_user");
		loginPageObj.setPassword("secret_sauce");
		loginPageObj.clickOnLoginButton(driver);
	}
	
	@Test(priority = 1)
	public void validateInventoryPageUrl() throws EncryptedDocumentException, IOException {
		//TC-00
		
		new File("reports").mkdirs();
        report = ExtentManager.getReport();
        test = report.createTest("validateInventoryPageUrl");

        test.info("Logged in");
		inventoryPageObj = new InventoryPage(driver);
		inventoryPageObj.clickOnProduct();
		test.info("clicked on product");
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory-item.html?id=0";
		assertEquals(actualUrl, expectedUrl);

		test.pass("Inventory Page Url Verified");
	}
	
	/*
	@Test(priority = 2)
	public void validateTheInventoryPageTitle() {
		new File("reports").mkdirs();

        report = ExtentManager.getReport();
        test = report.createTest("validateTheInventoryPageTitle");
		
        test.info("Logged in");
		inventoryPageObj = new InventoryPage(driver);
		String actualTitle = inventoryPageObj.getPageTitle(); 
		String expectedTitle = "Products";
		assertEquals(actualTitle, expectedTitle);
		
		test.info("page title verified");
	}
	*/
	
	@AfterMethod
	public void postSetups() {
		//post steps
		report.flush();
		inventoryPageObj.clickOnMenu();
		inventoryPageObj.clickOnLogOutBtn();
	}
}
