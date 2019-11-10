package Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Frmwrk.Seleniumframeworkvikesh.DriverActions;

import Frmwrk.Seleniumframeworkvikesh.DriverActions;

public class ChromeBrowser implements Browser {

	WebDriver driver ; 
	public ChromeBrowser(WebDriver driver ) {
		this.driver = driver ; 
		try {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikeshpawar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		}
		catch (IllegalStateException e ){
			// System.setProperty("webdriver.chrome.driver", "C:\\Users\\vpawar\\Downloads\\chromedriver_win32\\chromedriver.exe");

		}
		
		finally {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\vpawar\\Documents\\Bluetooth\\chromedriver_win32\\chromedriver.exe");
	
		}
		driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 setDriver(driver);
		 System.out.println("Started Execution with Chrome Browser");
	}
	public ChromeBrowser(WebDriver driver ,String headless) {
		this.driver = driver ; 
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikeshpawar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions() ; 
		options.addArguments("window-size=1400,800");
		options.addArguments(headless);
		 driver = new ChromeDriver(options);
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 setDriver(driver);
		 System.out.println( "Started Execution with Headless Chrome Browser");
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
