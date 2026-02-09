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

//TestPage-3
public class ProductPageTest extends SauceDemoBaseClass {
	LoginPage loginPageObj;
	ProductPage productPageObj;
	InventoryPage inventoryPageObj;
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
	}
	
	
	@Test(priority = 1)
	public void validateProductPageUrl() throws EncryptedDocumentException, IOException {
		//TC-00
		
		new File("reports").mkdirs();
        report = ExtentManager.getReport();
        test = report.createTest("validateProductPageUrl");
		
        test.info("Logged In and Now In the product page");
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = UtilityClass.readDataFromExcelFile(2, 0);
		assertEquals(actualUrl, expectedUrl);
		test.pass("Product Page URL verified");
	}
	
	/*
	@Test(priority = 2)
	public void validateTheInventoryPageTitle() {
		productPageObj = new ProductPage(driver);
		String actualTitle = productPageObj.getPageTitle(); 
		String expectedTitle = "Back to products";
		assertEquals(actualTitle, expectedTitle);
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
