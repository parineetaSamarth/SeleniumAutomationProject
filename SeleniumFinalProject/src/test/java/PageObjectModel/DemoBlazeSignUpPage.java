package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DemoBlazeSignUpPage {
	private RemoteWebDriver driver;

	public DemoBlazeSignUpPage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	By ModalTitle = By.id("signInModalLabel");
	By inputUserName = By.id("sign-username");
	By inputPassword = By.id("sign-password");
	By signUpButton = By.xpath("//button[text()='Sign up']");

	public String getTitleofModal() {
		return this.driver.findElement(ModalTitle).getText();
	}

	public void userNameInput(String userName) {
		this.driver.findElement(inputUserName).sendKeys(userName);
	}

	public void psswrdInput(String password) {
		this.driver.findElement(inputPassword).sendKeys(password);
	}

	public void clickSignUpButton() {
		this.driver.findElement(signUpButton).click();
	}

}
