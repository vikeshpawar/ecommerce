package Browsers;

import org.openqa.selenium.WebDriver;

public class BrowserFactory {

	
	private static WebDriver driver;

	public static Browser provideBrowser(String b) {
		
		if("IE".equalsIgnoreCase(b))
	    	return new IEBrowser(driver) ; 
	    else if ("mozilla".equalsIgnoreCase(b))
	    	return new FirefoxBrowser(driver);
	    else if ("chrome".equalsIgnoreCase(b))
	    	return new ChromeBrowser(driver);
	    else if ("headlessChrome".equalsIgnoreCase(b))
	    	return new ChromeBrowser (driver, "headless");
	    	else			
		return null;
		
	}
}
