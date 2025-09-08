package stepdefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import factory.DriverFactory;
import pages.RegistrationPage;
import utils.AppLogger;
import utils.ExtentManager;
import utils.ScreenshotUtil;
import java.util.Map;
import static org.testng.Assert.*;

public class RegistrationSteps {

    WebDriver driver = DriverFactory.getDriver();
    RegistrationPage regPage = new RegistrationPage(driver);

    @Given("I open the Thomas Cook website")
    public void i_open_the_thomas_cook_website() {
    	String baseUrl = utils.ConfigReader.get("base.url");
        DriverFactory.getDriver().get(baseUrl);
        AppLogger.info("Opened Thomas Cook website: " + baseUrl);
        ExtentManager.getTest().log(Status.INFO, "Opened Thomas Cook website");
    }
    @And("I navigate to the registration page")
    public void i_navigate_to_the_registration_page() {
        regPage.clickLoginToggle();
        regPage.clickNewUserRegister();
        AppLogger.info("Navigated to registration page");
    }
    @When("I select title {string}")
    public void i_select_title(String title) {
        regPage.selectTitle(title);
        AppLogger.info("Selected title: " + title);
    }
    @And("I enter first name {string}")
    public void i_enter_first_name(String fName) {
        regPage.enterFirstName(fName);
    }

    @And("I enter last name {string}")
    public void i_enter_last_name(String lName) {
        regPage.enterLastName(lName);
        AppLogger.info("Entered last name: " + lName);
    }
    @And("I enter email {string}")
    public void i_enter_email(String email) {
        regPage.enterEmail(email);
        AppLogger.info("Entered email: " + email);
    }
    @And("I enter password {string}")
    public void i_enter_password(String pwd) {
        regPage.enterPassword(pwd);
        AppLogger.info("Entered password");
    }
    @And("I enter confirm password {string}")
    public void i_enter_confirm_password(String confirmPwd) {
        regPage.enterConfirmPassword(confirmPwd);
        AppLogger.info("Entered confirm password");
    }
    @And("I enter mobile number {string}")
    public void i_enter_mobile_number(String mobile) {
        regPage.enterMobile(mobile);
        AppLogger.info("Entered mobile number: " + mobile);
    }
//    @And("I accept the privacy policy")
//    public void i_accept_the_privacy_policy() {
//        regPage.selectPrivacyPolicy();
//        AppLogger.info("Accepted privacy policy");
//    }
    @And("I click on Register button")
    public void i_click_on_register_button() throws InterruptedException {
        regPage.clickRegister();
        // allow client-side validation messages or redirect to happen
        Thread.sleep(2000);
        AppLogger.info("Clicked on Register button");
        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "ValidInput");
        ExtentManager.getTest().addScreenCaptureFromPath(screenshotPath, "Validation  Screenshot");
    }
    @Then("I should see error messages for invalid inputs")
    public void i_should_see_error_messages_for_invalid_inputs() {
        Map<String, String> errors = regPage.getAllFieldErrors();
        boolean hasError = errors.values().stream().anyMatch(e -> e != null && !e.isEmpty());
        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "InvalidInputErrors");
        ExtentManager.getTest().addScreenCaptureFromPath(screenshotPath, "Validation Errors Screenshot");

        if (hasError) {
            System.out.println("❌ Field-level validation errors:");
            errors.forEach((field, err) -> {
                if (err != null && !err.isEmpty()) {
                    System.out.println(field + " → " + err);
                    AppLogger.warn("Validation errors found: " + errors);
                    ExtentManager.getTest().log(Status.FAIL, "Validation errors: " + errors);
                }
            });
        }
        assertTrue(hasError, "Expected validation errors but none were displayed!");
    }
    @Then("I should be redirected to the home page without error")
    public void i_should_be_redirected_to_the_home_page_without_error() {
        Map<String, String> errors = regPage.getAllFieldErrors();
        boolean hasError = errors.values().stream().anyMatch(e -> e != null && !e.isEmpty());
        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "SuccessfulRegistration");
        ExtentManager.getTest().addScreenCaptureFromPath(screenshotPath, "Successful Registration Screenshot");
        if (!hasError) {
            AppLogger.info("Registration successful, redirected to home page.");
            ExtentManager.getTest().log(Status.PASS, "User successfully registered and redirected to home page");
        }
        assertFalse(hasError, "Unexpected error messages were displayed with valid data!");
        assertTrue(driver.getCurrentUrl().contains("thomascook.in"), "User was not redirected to home page after successful registration.");
    }
}
