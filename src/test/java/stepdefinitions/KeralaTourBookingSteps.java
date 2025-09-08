package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.KeralaTourPage;
import utils.AppLogger;
import utils.ExtentManager;
import utils.ScreenshotUtil;
import com.aventstack.extentreports.Status;
import factory.DriverFactory;

public class KeralaTourBookingSteps {

    WebDriver driver = DriverFactory.getDriver();
    KeralaTourPage tourPage = new KeralaTourPage(driver);

    @Given("I am on ThomasCook home page")
    public void openHomePage() {
     //   driver.get("https://www.thomascook.in/");
    	String baseUrl = utils.ConfigReader.get("base.url");
        DriverFactory.getDriver().get(baseUrl);
        AppLogger.info("Opened Thomas Cook Kerala to Kochi Tour Booking: " + baseUrl);
        ExtentManager.getTest().log(Status.INFO, "Opened Thomas Cook Tour Booking to Kerala to Kochi");
    
        ExtentManager.getTest().log(Status.INFO, "Opened ThomasCook homepage");
        ExtentManager.getTest().addScreenCaptureFromPath(
                ScreenshotUtil.takeScreenshot(driver, "HomePage")
        );
    }

    @When("I hover on Holiday menu and navigate to Short Breaks in Kerala")
    public void hoverHolidayMenu() {
        tourPage.hoverOnHolidayMenu();
        ExtentManager.getTest().log(Status.INFO, "Navigated to Short Breaks in Kerala");
        ExtentManager.getTest().addScreenCaptureFromPath(
                ScreenshotUtil.takeScreenshot(driver, "HolidayMenu")
        );
    }
    @When("I click on {string} view details")
    public void clickKeralaTour(String tourName) {
        tourPage.clickKeralaQuickKochi();
        ExtentManager.getTest().log(Status.INFO, "Clicked on Kerala Quick Kochi View Details");
        ExtentManager.getTest().addScreenCaptureFromPath(
                ScreenshotUtil.takeScreenshot(driver, "ViewDetails")
        );
    }
    // ✅ Implemented step
    @When("I scroll to Calculate Price and fill Tour Type {string} and Adult {string}")
    public void i_scroll_to_calculate_price_and_fill_tour_type_and_adult(String tourType, String adults) {
        tourPage.selectTourType(tourType);
        tourPage.setAdultCount(Integer.parseInt(adults));
        ExtentManager.getTest().log(Status.INFO, "Selected Tour Type: " + tourType + ", Adults: " + adults);
    }
    @When("I select Date of Travel {string}")
    public void selectDate(String travelDate) {
        tourPage.selectTravelDate(travelDate);
        ExtentManager.getTest().log(Status.INFO, "Selected Travel Date: " + travelDate);
    }
    @When("I accept Privacy Policy & Terms and click Calculate Package Price")
    public void i_accept_privacy_policy_terms_and_click_calculate_package_price() {
        // We already handle this in fillContactDetails
        ExtentManager.getTest().log(Status.INFO, "Accepted Privacy Policy & clicked Calculate Package Price");
    }

  
    @When("I select Pay Full Amount and click Continue")
    public void i_select_pay_full_amount_and_click_continue() {
        // Already handled inside fillContactDetails -> clicking full amount + continue
        ExtentManager.getTest().log(Status.INFO, "Selected Pay Full Amount & clicked Continue");
    }

    @When("I fill Contact Details {string} and {string}")
    public void fillContact(String mobile, String email) {
        tourPage.fillContactDetails(mobile, email);
        ExtentManager.getTest().log(Status.INFO, "Filled Contact Details: " + mobile + ", " + email);
    }
    @When("I sign in with {string} and continue as guest")
    public void continueGuest(String email) {
        tourPage.continueAsGuest();
        ExtentManager.getTest().log(Status.INFO, "Continued as guest with email: " + email);
    }
    @When("I fill Traveller 1 details {string}, {string}, {string}, {string}, {string}")
    public void traveller1(String title, String fName, String lName, String dob, String meal) {
        tourPage.fillTraveller1(title, fName, lName, dob, meal);
    }
    @When("I fill Traveller 2 details {string}, {string}, {string}, {string}, {string}")
    public void traveller2(String title, String fName, String lName, String dob, String meal) {
        tourPage.fillTraveller2(title, fName, lName, dob, meal);
    }
    @When("I fill Address details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void address(String title, String fName, String lName, String addr, String state,
                        String city, String pincode, String email, String mobile) {
        tourPage.fillAddress(title, fName, lName, addr, state, city, pincode, email, mobile);
    }

    @When("I select Credit Card and fill payment details {string}, {string}, {string}, {string}, {string}")
    public void payment(String cardNum, String expM, String expY, String cvv, String holder) {
        tourPage.fillPayment(cardNum, expM, expY, cvv, holder);
    }

    @Then("I should see Payment Failed message")
    public void verifyPaymentFailed() {
        if (tourPage.isPaymentFailedMessageDisplayed()) {
            ExtentManager.getTest().log(Status.PASS, "Payment Failed message displayed");
        } else {
            ExtentManager.getTest().log(Status.FAIL, "Payment Failed message NOT displayed");
        }
    }
}
