package pages;
//Page-7

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPlacedPage {
	@FindBy (xpath = "//span[text()='Checkout: Complete!']") private WebElement orderPlacedPageTitle;
}
