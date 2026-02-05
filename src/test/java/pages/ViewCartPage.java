package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Page-4
public class ViewCartPage {
	@FindBy (xpath = "//button[@id='checkout']") private WebElement checkOutButton;
	@FindBy (xpath = "//span[text()='Your Cart']") private WebElement ViewCartPageTitle;
	
	
	//constructor
	public ViewCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//method
	public void clickOnCheckOutButton() {
		checkOutButton.click();
	}
}
