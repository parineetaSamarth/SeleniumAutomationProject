package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DemoBlazeHomePage {
	// Driver and its initialization
	private RemoteWebDriver driver;

	public DemoBlazeHomePage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	By LoginButton = By.id("login2");
	By Signup = By.id("signin2");
	By enterURL = By.xpath("//textarea[@aria-label='Search']");
	By searchButton = By.className("gNO89b");
	By clickOnSearchResult = By.className("OBMEnb");
	By linkTextClick = By.cssSelector("h3");

	public void googleEnter(String googleURL) {
		this.driver.findElement(enterURL).sendKeys(googleURL);
	}

	public void clickSearchResult() {
		this.driver.findElement(searchButton).click();
	}

	public void clickOnDemoBlaze() {
		this.driver.findElement(linkTextClick).click();
	}

	public void clickOnSignUp() {
		this.driver.findElement(Signup).click();
	}

	public void clickOnLogin() {
		this.driver.findElement(LoginButton).click();
	}

}
