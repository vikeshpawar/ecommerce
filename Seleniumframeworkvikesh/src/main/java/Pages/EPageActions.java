package Pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Frmwrk.Seleniumframeworkvikesh.DriverActions;



public class EPageActions extends DriverActions {

	
	public By SearchTextBox = By.id("search_query_top"); 
	public By SearchButton = By.name("submit_search");
	Duration durationseconds = Duration.ofSeconds(30);
	
	
	public void enterValueInTextField(String value, By selector) {
		getDriver().findElement(selector).sendKeys(value);
	}

	public void click(By selector) {
		getDriver().findElement(selector).click();
	}

	public void clickOnLink(String linkText) {
		getDriver().findElement(By.linkText(linkText));
	}
	public WebElement getWebElement(By selector) {
		WebElement element= getDriver().findElement(selector);
		return element ; 
	}
	
	public void hoverOnElement(By selector) {
		Actions a = new Actions(getDriver());
		a.moveToElement(getWebElement(selector)).perform();
	}
		public void hoverOnElementAndClick(By selector) {
			Actions a = new Actions(getDriver());
			a = a.moveToElement(getWebElement(selector));	
			//WebElement e= getDriver().findElement(selector);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebDriverWait wait = new WebDriverWait(getDriver(), durationseconds);
			wait.until(ExpectedConditions.elementToBeClickable(selector));
			a.click().build().perform();
		}
	
	public void executeJavaScript(String script) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript(script);
	}
	
	public void executeJavaScript(String script, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript(script,element );
	}
	
	
	public void waitUntilElementVisible(By selector) {

		 Wait wait = new WebDriverWait(getDriver(),durationseconds );
		 wait.until(ExpectedConditions.visibilityOfElementLocated(selector));

		 
	}
	
	public boolean ElementPresent (By selector) {
		if (getDriver().findElement(selector).isDisplayed())
		return true ; 
		else 	
		return false;
		
	}
	
	public void webpageScreenshot(String status) throws Exception
	{
		File src= ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir").toString()+"\\resources\\"+status+"\\"+dateTimeStamp()+".png"));
	}
	
	public String dateTimeStamp()
	{
		Date date = new Date();
		return Long.toString(date.getTime());
	}
	
	public void captureJSerrors() {
        LogEntries logEntries = getDriver().manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(dateTimeStamp() + " " + entry.getLevel() + " " + entry.getMessage());
        }
	}
	
	public String readAJAXrequests() throws Exception
	{
		FileReader fr = new FileReader(new File (System.getProperty("user.dir").toString() + "\\resources\\monitorAJAXrequests.txt"));
	    BufferedReader br = new BufferedReader(fr);
	    String buffer;
	    String fulltext="";
	    while ((buffer = br.readLine()) != null) {
	        fulltext += buffer;
	    }
	    br.close();
	    fr.close();
	    return fulltext;
		
	}
	
	public List<String> collectAJAXrequests() throws Exception
	{
		List<String> calls = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		calls.add((String)js.executeScript(readAJAXrequests()));
		return calls;	
	}

}
