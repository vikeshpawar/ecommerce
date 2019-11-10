package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WomenPage extends EPageActions {
	ShoppingCartPage cart = new ShoppingCartPage() ;
	private static final By CategoriesBlock  =  By.id("categories_block_left");
	private static final By HomeIndexPage =  By.xpath("/html/body/div[1]/div[2]/div/div[1]/a/i");
	// LastElement of the Search Page
	private static final By Social_block = By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a");
	private String NthItemInSearchxpath = "/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[#]/div/div[2]/div[2]/a[1]/span";
	private static final By FirstItemInSearch = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/div[2]/a[1]/span");
	private static final By FirstElementHover = By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[1]/div/a[1]/img");
	private static final By ProceedToCheckOutPop = By.id("layer_cart");
	private static final By ProceedToCheckButton = By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span");
	private static final By GoToCartButton = By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[3]/div/a/b");
	
	public void EnterTextAndSearch(String inputSearchText) {
		enterValueInTextField(inputSearchText, SearchTextBox);
		click(SearchButton);
		waitUntilElementVisible(Social_block);
	}
		
	public void SelectAndAddToCartNthElement (int n) {
		By selector = By.xpath (NthItemInSearchxpath.replaceFirst("#", String.valueOf(n)));
		executeJavaScript("window.scrollBy(0,600)");
		hoverOnElementAndClick(selector);
		waitUntilElementVisible(ProceedToCheckOutPop);
			
	}
	
	public void SelectAndAddToCartfirstElement() {
		executeJavaScript("window.scrollBy(0,500)");
		hoverOnElement(FirstElementHover);
		waitUntilElementVisible(FirstItemInSearch);
		click(FirstItemInSearch);
		waitUntilElementVisible(ProceedToCheckOutPop);
		
	}
	
	public void goToCart () {
		click(GoToCartButton);
		waitUntilElementVisible(ShoppingCartPage.ProceedToCHeckoutButton);
		
	}
	 
	public void proceedToCheckout() {
	
		if (ElementPresent(ProceedToCheckOutPop)) {
			hoverOnElementAndClick(ProceedToCheckButton);
			}
		else {
			throw new ElementNotVisibleException("Proceed to checkout PopUp not Present");
		}
	}
	
	
}
