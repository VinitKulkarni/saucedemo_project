package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utilis.UtilityClass;


public class SauceDemoBaseClass {
	protected WebDriver driver;
	
	@BeforeClass
	public void initalSetup() throws IOException {
		driver = new FirefoxDriver();
		//driver.get(UtilityClass.readDataFromPropertiesFile("url"));
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void teardown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
