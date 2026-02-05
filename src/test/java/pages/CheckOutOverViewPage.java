package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Page-6
public class CheckOutOverViewPage {
	//web element
	@FindBy (xpath = "//button[@id='finish']") private WebElement finishButton;
	@FindBy (xpath = "//span[text()='Checkout: Overview']") private WebElement CheckOutOverViewPageTitle;
	
	
	//constructor
	public CheckOutOverViewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//method
	public void clickOnFinish() {
		finishButton.click();
	}
}
