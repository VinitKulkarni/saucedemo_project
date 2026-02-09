package tests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.SauceDemoBaseClass;
import utilis.ExtentManager;
import utilis.UtilityClass;

//TestPage-1
public class LoginPageTest extends SauceDemoBaseClass {
	
    static ExtentReports report;
    static ExtentTest test;
	
	@Test
	public void validateLoginPageUrl() throws EncryptedDocumentException, IOException {
		//TC-00
        new File("reports").mkdirs();
        report = ExtentManager.getReport();
        test = report.createTest("validateLoginPageUrl");
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = UtilityClass.readDataFromExcelFile(0, 0);
		assertEquals(actualUrl, expectedUrl);
		test.pass("Login Sucess");
		report.flush();
	}
}
