package step.definition;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Utility.WaitUtil;
import PageObjectModel.DemoBlazeHomePage;
import PageObjectModel.DemoBlazeLoginPage;
import PageObjectModel.DemoBlazeSignUpPage;
import Utility.LoggerUtil;
import Utility.ScreenshotUtil;
import Utility.BrowserUtil;

public class DemoBlazeAppSteps {
	RemoteWebDriver driver = BrowserUtil.getDriver();
	DemoBlazeHomePage homePage = new DemoBlazeHomePage(driver);
	DemoBlazeSignUpPage signUpPage = new DemoBlazeSignUpPage(driver);
	DemoBlazeLoginPage loginPage = new DemoBlazeLoginPage(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitUtil.Web_Driver_Wait_Time));
	private static final Logger log = LoggerUtil.getLogger(DemoBlazeAppSteps.class);

	@Given("user open google browser {string}")
	public void user_opened_google_browser(String googleurl) throws IOException {
		driver.get(googleurl);
		ScreenshotUtil.takeScreenshot(driver, "Screenshots/googleurl.png");
		log.debug("User has Opened the" + googleurl);
	}

	@Given("user navigated to DemoBlaze Application URL {string}")
	public void user_navigated_to_URL(String uRL) {
		homePage.googleEnter(uRL);
		ScreenshotUtil.takeScreenshot(driver, "Screenshots/listofresult.png");
		homePage.clickSearchResult();
		ScreenshotUtil.takeScreenshot(driver, "Screenshots/ClickedOnSearch.png");
		homePage.clickOnDemoBlaze();
		ScreenshotUtil.takeScreenshot(driver, "Screenshots/demoBlazeApp.png");
		log.debug("User has navigated to " + uRL);
	}

	@Then("User has the title of the page as {string}")
	public void user_has_the_title(String expectedtitleOfPage) {
		String actualHomePageTitle = driver.getTitle();
		Assert.assertEquals(actualHomePageTitle, expectedtitleOfPage);
		ScreenshotUtil.takeScreenshot(driver, "Screenshots/demoblazetitle.png");
		log.debug("User has the title of the page as  " + actualHomePageTitle);
	}

	@Then("user receives welcome greetings {string}")
	public void user_receives_welcome_greetings(String greetings) {
		ScreenshotUtil.takeScreenshot(driver, "Screenshots/greetings.png");
		log.debug("User has seen " + greetings);
	}

	@When("user clicks on Sign up link and {string} modal is displayed")
	public void user_clicks_on_sign_link(String expectedTitle) {
		homePage.clickOnSignUp();
		ScreenshotUtil.takeScreenshot(driver, "Screenshots/signuplink.png");
		String actualTitle = signUpPage.getTitleofModal();
		ScreenshotUtil.takeScreenshot(driver, "Screenshots/signupModal.png");
		Assert.assertEquals(actualTitle, expectedTitle);
		log.debug("user clicked on sign up link and " + actualTitle + " modal is displayed");

	}

	@When("user input username as {string} and password as {string} and clicked on Sign up")
	public void user_input_username_psswrd_signup(String userName, String password) {
		signUpPage.userNameInput(userName);
		ScreenshotUtil.takeScreenshot(driver, "Screenshots/username.png");
		log.debug("user has entered username " + userName);
		signUpPage.psswrdInput(password);
		ScreenshotUtil.takeScreenshot(driver, "Screenshots/password.png");
		log.debug("user has entered password" + password);
		signUpPage.clickSignUpButton();
		ScreenshotUtil.takeScreenshot(driver, "Screenshots/SignUpButtonClicked.png");
		log.debug("user has clicked on signup button");
	}

	@Then("user is successfully signed up and {string} alert is displayed")
	public void user_successfully_signedup(String expectedAlertText) {

		wait.until(ExpectedConditions.alertIsPresent());
		log.debug("Sign up alert is present");
		String alertText = driver.switchTo().alert().getText();
		log.debug("AlertActualText- " + alertText + ", AlertExpectedText- " + expectedAlertText);
		Assert.assertEquals(alertText, expectedAlertText);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().alert().accept();
		ScreenshotUtil.takeScreenshot(driver, "Screenshots/AlertAcceptSignup.png");
		log.debug("Sign up alert is accepted");
	}

	@When("user clicks on Login link and {string} modal is displayed")
	public void user_clicked_on_login(String expectedTitle) {
		homePage.clickOnLogin();
		log.debug("user clicked on log in link");
		ScreenshotUtil.takeScreenshot(driver, "Screenshots/loginLink.png");
		String actualTitle = loginPage.loginModalTitle();
		ScreenshotUtil.takeScreenshot(driver, "Screenshots/loginModal.png");
		Assert.assertEquals(actualTitle, expectedTitle);
		log.debug("Log in Modal is displayed with title" + expectedTitle);
	}

	@When("user input username as {string} and password as {string} and clicked on Log in")
	public void user_input_username_psswrd_login(String loginuserName, String loginpassword) {
		loginPage.enterUserName(loginuserName);
		ScreenshotUtil.takeScreenshot(driver, "Screenshots/username1.png");
		log.debug("user has entered username " + loginuserName);
		loginPage.enterPassword(loginpassword);
		ScreenshotUtil.takeScreenshot(driver, "Screenshots/password1.png");
		log.debug("user has entered password" + loginpassword);
		loginPage.clickLoginButton();
		ScreenshotUtil.takeScreenshot(driver, "Screenshots/LoginButtonClicked.png");
		log.debug("user has clicked on login button");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("user is successfully logged in and {string} is displayed on loginpage")
	public void user_successfully_logged_in(String expectedWelcome) {
		String actualWelcome = loginPage.userWelcome();
		log.debug("user has Welcome Message- " + actualWelcome);
		ScreenshotUtil.takeScreenshot(driver, "Screenshots/WelcomeMessage.png");
		Assert.assertEquals(actualWelcome, expectedWelcome);
	}

	@Then("User closes the browser")
	public void user_closes_browser() {
		driver.quit();
		log.debug("User closed the browser");
	}

}
