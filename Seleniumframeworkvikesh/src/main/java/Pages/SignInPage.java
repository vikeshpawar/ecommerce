package Pages;

import org.openqa.selenium.By;

public class SignInPage extends EPageActions {

	private static final By SIGNINButton =  By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[2]/form/div/p[2]/button/span");
	private static final By EmailTextBox =  By.id("email");
	private static final By Passwordtextbox = By.id("passwd");
	private static final By ForgotPasswordLink = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[2]/form/div/p[1]/a");
	private static final By AuthenticationButton = By.xpath("/html/body/div[1]/div[2]/div/div[1]/span[2]");

	public void signIn(String email , String password) {
		getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		executeJavaScript("window.scrollBy(0,200)");
		waitUntilElementVisible(SIGNINButton);
		enterValueInTextField(email, EmailTextBox);
		enterValueInTextField(password, Passwordtextbox);
		click(SIGNINButton);
		waitUntilElementVisible(MyAccount.MyAccountButonLink);
			
	}
}
