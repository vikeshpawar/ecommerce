package Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import Frmwrk.Seleniumframeworkvikesh.DriverActions;

public class FirefoxBrowser implements Browser {

	WebDriver driver ; 
	public FirefoxBrowser(WebDriver driver ) {
		this.driver = driver ; 
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\vikeshpawar\\Downloads\\geckodriver-v0.26.0-win32\\geckodriver.exe");
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 setDriver(driver);
	}
	
	public FirefoxBrowser(WebDriver driver, String headless ) {
		this.driver = driver ; 
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\vikeshpawar\\Downloads\\geckodriver-v0.26.0-win32\\geckodriver.exe");
		 FirefoxOptions options = new FirefoxOptions() ;
		 options.setHeadless(true);
		 driver = new FirefoxDriver(options);
		 driver.manage().window().maximize();
		 setDriver(driver);
	}
	private void setDriver(WebDriver driver) {
		// TODO Auto-generated method stub
		DriverActions.setDriver(driver);
	}
	public WebDriver getDriver( ) {
		// TODO Auto-generated method stub
		return driver;
	}
	
	

	

}
