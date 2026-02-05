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
import pages.InventoryPage;
import pages.LoginPage;
import pages.ProductPage;
import pages.ViewCartPage;
import utilis.ExtentManager;
import utilis.UtilityClass;

//TestPage-6
public class CheckOutOverViewPageTest extends SauceDemoBaseClass {
	LoginPage loginPageObj;
	InventoryPage inventoryPageObj;
	ProductPage productPageObj;
	ViewCartPage viewCartPageObj;
	AddPersonInfoPage addPersonInfoPageObj;
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
	}
	
	@Test
	public void validateCheckOutOverViewPageUrl() throws EncryptedDocumentException, IOException {
		//TC-00
		
		new File("reports").mkdirs();
        report = ExtentManager.getReport();
        test = report.createTest("validateCheckOutOverViewPageUrl");
		
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/checkout-step-two.html";
		assertEquals(actualUrl, expectedUrl);
		test.pass("Check Out Over View Page Url verified");
	}
	
	@AfterMethod
	public void postSteps() {
		//logout
		inventoryPageObj.clickOnMenu();
		inventoryPageObj.clickOnLogOutBtn();
		report.flush();
	}
}
