package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Page-3
public class ProductPage {
	//web elements
	@FindBy (xpath = "//button[@id='add-to-cart']") private WebElement addToCartButton;
	@FindBy (xpath = "//a[@class='shopping_cart_link']") private WebElement clickOnViewCartButton;
	@FindBy (xpath = "//button[@id='back-to-products']") private WebElement productPageTitle;
		
		
	//constructor
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
		
	//methods
	public void clickOnAddToCart() {
		addToCartButton.click();
	}
		
	public void clickOnViewCart() {
		clickOnViewCartButton.click();
	}
	
	public String getPageTitle() {
		return productPageTitle.getText();
	}
}
