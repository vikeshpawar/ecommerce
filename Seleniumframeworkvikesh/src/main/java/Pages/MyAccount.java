package Pages;

import org.openqa.selenium.By;

public class MyAccount extends EPageActions {

	public static final By MyAccountButonLink  =  By.xpath("/html/body/div[1]/div[2]/div/div[1]/span[2]");
	private static final By HomeIndexPage=  By.xpath("/html/body/div[1]/div[2]/div/div[1]/a/i");
	// Women Dresses Tshirts
	private static final By WomenPageLink = By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a");
	private static final By DressesPageLink = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[2]/form/div/p[1]/a");
	private static final By TShirtsPaMyAccountgeLink = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[2]/form/div/p[1]/a");

	
	public void VisitDressesPage() {
		waitUntilElementVisible(MyAccountButonLink);
		click(DressesPageLink);
			
	}
	public void VisitWomenPage() {
		waitUntilElementVisible(MyAccountButonLink);
		click(WomenPageLink);
			
	}
	public void VisitTShirtsPage() {
		waitUntilElementVisible(MyAccountButonLink);
		click(TShirtsPaMyAccountgeLink);
		
	}
}
