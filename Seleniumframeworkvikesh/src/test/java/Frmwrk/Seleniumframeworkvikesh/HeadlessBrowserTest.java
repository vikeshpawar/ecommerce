package Frmwrk.Seleniumframeworkvikesh;

import org.testng.annotations.Test;

import Browsers.BrowserFactory;
import Pages.MyAccount;
import Pages.SignInPage;
import Pages.WomenPage;

public class HeadlessBrowserTest {

	SignInPage signinpage = new SignInPage();  
	BrowserFactory fact = new BrowserFactory() ;
	DriverActions driveractions = new DriverActions() ;
	MyAccount account = new MyAccount();
	WomenPage women = new WomenPage();
  @Test
  public void addAnItemTotheCartTest() {
	  //fact.provideBrowser("headlessChrome");
	  fact.provideBrowser("ie");
	  signinpage.signIn("vikeshpawar@gmail.com", "Vikesh@1234");
	  account.VisitWomenPage();
	  women.EnterTextAndSearch("blouse");
	  System.out.println("Search Done ");
	  women.SelectAndAddToCartfirstElement();
	  System.out.println("Clicked");
	  //women.SelectAndAddToCartNthElement(2);
	  women.proceedToCheckout();
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  driveractions.closeTabs();
  }
}
