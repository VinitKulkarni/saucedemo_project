package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Page-5
public class AddPersonInfoPage {
	//web elements
	@FindBy (xpath = "//input[@id='first-name']") private WebElement firstName;
	@FindBy (xpath = "//input[@id='last-name']") private WebElement lastName;
	@FindBy (xpath = "//input[@id='postal-code']") private WebElement zipCode;
	@FindBy (xpath = "//input[@id='continue']") private WebElement continueButton;
	@FindBy (xpath = "//span[text()='Checkout: Your Information']") private WebElement AddPersonInfoPageTitle;
	
		
	//constructor
	public AddPersonInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//methods
	public void setFirstName(String fName) {
		firstName.sendKeys(fName);
	}
	
	public void setLastName(String lName) {
		lastName.sendKeys(lName);
	}

	public void setZipCode(String zCode) {
		zipCode.sendKeys(zCode);
	}

	public void clickOnContinueButton() {
		continueButton.click();
	}
}
