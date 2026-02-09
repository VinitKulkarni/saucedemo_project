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
import pages.ProductPage;
import pages.ViewCartPage;
import utilis.ExtentManager;
import utilis.UtilityClass;

//TestPage-5
public class AddPersonInfoPageTest extends SauceDemoBaseClass {
	LoginPage loginPageObj;
	InventoryPage inventoryPageObj;
	ProductPage productPageObj;
	ViewCartPage viewCartPageObj;
	static ExtentReports report;
	static ExtentTest test;
	
	@BeforeMethod
	public void preSteps() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.setUserName(UtilityClass.readDataFromPropertiesFile("userName"));
		loginPageObj.setPassword(UtilityClass.readDataFromPropertiesFile("password"));
		loginPageObj.clickOnLoginButton(driver);
		
		inventoryPageObj = new InventoryPage(driver);
		inventoryPageObj.clickOnProduct();
		
		productPageObj = new ProductPage(driver);
		productPageObj.clickOnAddToCart();
		productPageObj.clickOnViewCart();
		
		viewCartPageObj = new ViewCartPage(driver);
		viewCartPageObj.clickOnCheckOutButton();
	}
	
	@Test
	public void validateAddPersonInfoPageUrl() throws EncryptedDocumentException, IOException {
		//TC-00
		
		new File("reports").mkdirs();
	    report = ExtentManager.getReport();
	    test = report.createTest("validateAddPersonInfoPageUrl");
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = UtilityClass.readDataFromExcelFile(4, 0);
		test.info("got the expected url");
		assertEquals(actualUrl, expectedUrl);
		test.pass("Add Person Info Page Url verified");
	}
	
	@AfterMethod
	public void postSteps() {
		//logout
		inventoryPageObj.clickOnMenu();
		inventoryPageObj.clickOnLogOutBtn();
		report.flush();
	}
}
