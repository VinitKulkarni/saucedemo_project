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
import pages.AddPersonInfoPage;
import pages.CheckOutOverViewPage;
import pages.InventoryPage;
import pages.LoginPage;
import pages.ProductPage;
import pages.ViewCartPage;
import utilis.ExtentManager;
import utilis.UtilityClass;

//TestPage-7
public class OrderPlacedPageTest extends SauceDemoBaseClass {
	LoginPage loginPageObj;
	InventoryPage inventoryPageObj;
	ProductPage productPageObj;
	ViewCartPage viewCartPageObj;
	AddPersonInfoPage addPersonInfoPageObj;
	CheckOutOverViewPage checkOutOverViewPageObj;
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
		
		addPersonInfoPageObj = new AddPersonInfoPage(driver);
		addPersonInfoPageObj.setFirstName("QQQ");
		addPersonInfoPageObj.setLastName("RRR");
		addPersonInfoPageObj.setZipCode("11111");
		addPersonInfoPageObj.clickOnContinueButton();
		
		checkOutOverViewPageObj = new CheckOutOverViewPage(driver);
		checkOutOverViewPageObj.clickOnFinish();
	}
	
	@Test
	public void validateOrderPlacedPageUrl() throws EncryptedDocumentException, IOException {
		//TC-00
		
		new File("reports").mkdirs();
        report = ExtentManager.getReport();
        test = report.createTest("validateOrderPlacedPageUrl");
		
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = UtilityClass.readDataFromExcelFile(6, 0);
		assertEquals(actualUrl, expectedUrl);
		test.pass("Order Placed Page Url verified");
	}
	
	@AfterMethod
	public void postSteps() {
		//logout
		inventoryPageObj.clickOnMenu();
		inventoryPageObj.clickOnLogOutBtn();
		report.flush();
	}
}
