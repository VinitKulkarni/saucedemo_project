package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Page-2
public class InventoryPage {
	//web element
	@FindBy (xpath = "//div[text()='Sauce Labs Bike Light']") private WebElement sauceLabsBikeLightPrd;
	@FindBy (xpath = "//span[text()='Products']") private WebElement inventoryPageTitle;
	@FindBy (xpath = "//button[@id='react-burger-menu-btn']") private WebElement menuBtn;
	@FindBy (xpath = "//a[@id='logout_sidebar_link']") private WebElement logOutBtn;
	
	//constructor
	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//method
	public void clickOnProduct() {
		sauceLabsBikeLightPrd.click();
	}

	public String getPageTitle() {
		return inventoryPageTitle.getText();
	}
	
	public void clickOnMenu() {
		menuBtn.click();
	}
	
	public void clickOnLogOutBtn() {
		logOutBtn.click();
	}
}
