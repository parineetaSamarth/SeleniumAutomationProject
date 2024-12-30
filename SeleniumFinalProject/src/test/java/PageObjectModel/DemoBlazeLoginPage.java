package PageObjectModel;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.WaitUtil;

public class DemoBlazeLoginPage {

	// Driver and its initialization
	private RemoteWebDriver driver;
	private WebDriverWait wait;

	public DemoBlazeLoginPage(RemoteWebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(WaitUtil.Web_Driver_Wait_Time));
	}
	
	
	By titleLoginModal = By.id("logInModalLabel");
	By userNameLogin = By.id("loginusername");
	By passwordLogin = By.id("loginpassword");
	By loginButton = By.xpath("//button[text()='Log in']");
	By welcomeUser = By.id("nameofuser");

	public void enterUserName(String usernamelogin) {
		this.driver.findElement(userNameLogin).sendKeys(usernamelogin);
	}

	public void enterPassword(String loginPassword) {
		this.driver.findElement(passwordLogin).sendKeys(loginPassword);
	}

	public void clickLoginButton() {
		this.driver.findElement(loginButton).click();
	}

	public String userWelcome() {
		WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeUser));
		return messageElement.getText();
	}

	public String loginModalTitle() {
		return driver.findElement(titleLoginModal).getText();
	}
}
