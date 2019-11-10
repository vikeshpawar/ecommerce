package Frmwrk.Seleniumframeworkvikesh;


import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Browsers.BrowserFactory;
import Pages.MyAccount;
import Pages.SignInPage;
import Pages.WomenPage;
import  Frmwrk.Seleniumframeworkvikesh.DriverActions;
public class TestGotoCartFunctionality{
	
	SignInPage signinpage = new SignInPage();  
	BrowserFactory fact = new BrowserFactory() ;
	DriverActions driveractions = new DriverActions() ;
	MyAccount account = new MyAccount();
	WomenPage women = new WomenPage();
	
  @Test (enabled = false)
  public void TestLogin() throws InterruptedException {
	  fact.provideBrowser("chrome");
	  signinpage.signIn("vikeshpawar@gmail.com", "Vikesh@1234");
	  Thread.sleep(5000);
	  driveractions.closeTabs();
	 	  
  }
  @Parameters("browser")
  @Test(priority = 2)
  public void addAnItemTotheCart (String browser) throws InterruptedException {
	  fact.provideBrowser(browser);
	  signinpage.signIn("vikeshpawar@gmail.com", "Vikesh@1234");
	  account.VisitWomenPage();
	  women.EnterTextAndSearch("blouse");
	  women.SelectAndAddToCartfirstElement();
	  //women.SelectAndAddToCartNthElement(2);
	  women.proceedToCheckout();
	  Thread.sleep(5000);
	  driveractions.closeTabs();
  }
//@Test (priority = 1)
  public void addAnItemTotheCart1 () throws InterruptedException {
	  
	  fact.provideBrowser("chrome");
	  signinpage.signIn("vikeshpawar@gmail.com", "Vikesh@1234");
	  account.VisitWomenPage();
	  women.EnterTextAndSearch("Dress");
	 // women.SelectAndAddToCartfirstElement();
	  women.SelectAndAddToCartNthElement(2);
	  women.proceedToCheckout();
	  Thread.sleep(5000);
	  driveractions.closeTabs();
	  
  }
}
