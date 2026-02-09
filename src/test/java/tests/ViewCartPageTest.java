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
import utilis.ExtentManager;
import utilis.UtilityClass;

//TestPage-4
public class ViewCartPageTest extends SauceDemoBaseClass {
	LoginPage loginPageObj;
	InventoryPage inventoryPageObj;
	ProductPage productPageObj;
	static ExtentReports report;
    static ExtentTest test;
	
	@BeforeMethod
	public void preSetup() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.setUserName(UtilityClass.readDataFromPropertiesFile("userName"));
		loginPageObj.setPassword(UtilityClass.readDataFromPropertiesFile("password"));
		loginPageObj.clickOnLoginButton(driver);
		
		inventoryPageObj = new InventoryPage(driver);
		inventoryPageObj.clickOnProduct();
		
		productPageObj = new ProductPage(driver);
		productPageObj.clickOnAddToCart();
		productPageObj.clickOnViewCart();
	}
	
	@Test
	public void validateViewCartPageUrl() throws EncryptedDocumentException, IOException {
		//TC-00
		new File("reports").mkdirs();
        report = ExtentManager.getReport();
        test = report.createTest("validateViewCartPageUrl");
		
		test.info("Logged In and Now inside Cart Page");
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/cart.html";
		assertEquals(actualUrl, expectedUrl);
		test.pass("View Cart Page URL verified");
	}
	
	@AfterMethod
	public void postSetup() {
		report.flush();
		inventoryPageObj.clickOnMenu();
		inventoryPageObj.clickOnLogOutBtn();
	}
}
