//package stepdefinitions;
//import io.cucumber.java.en.*;
//import org.openqa.selenium.WebDriver;
//import pages.LoginPage;
//import factory.DriverFactory;
//
//public class LoginSteps {
//    WebDriver driver = DriverFactory.getDriver();
//    LoginPage loginPage = new LoginPage(driver);
//
//    @Given("I am on the ThomasCook login page")
//    public void i_am_on_login_page() {
//        driver.get("https://www.thomascook.in/");
//        loginPage.openLoginForm();
//    }
//
//    @When("I enter login details and send OTP")
//    public void i_enter_login_details() {
//       loginPage.enterLoginId("validUser123"); // replace with actual valid login
//      loginPage.clickSendOtp();
//        //Handle OTP manually or via automation if possible
//        }
//
//    @When("I enter invalid login details and send OTP")
//    public void i_enter_invalid_login_details() {
//        loginPage.enterLoginId("invalidUser");
//        loginPage.clickSendOtp();
//    }
//
//    @When("I click on the login button")
//    public void i_click_login_button() {
//        loginPage.clickLogin();
//   }
//
//    @Then("I should be logged in successfully")
//    public void i_should_be_logged_in_successfully() {
//        assert loginPage.isLoginSuccessful() : "Login was not successful";
//    }
//
//    @Then("I should see an error message")
//    public void i_should_see_error_message() {
//        assert loginPage.isErrorMessageDisplayed() : "Error message not displayed";
//   }
//}
//
//
//package stepdefinitions;
//
//import io.cucumber.java.en.*;
//import org.openqa.selenium.WebDriver;
//import pages.LoginPage;
//import factory.DriverFactory;
//import java.util.Scanner;
//
//public class LoginSteps {
//    WebDriver driver = DriverFactory.getDriver();
//    LoginPage loginPage = new LoginPage(driver);
//
//    @Given("I am on the ThomasCook login page")
//    public void i_am_on_login_page() {
//        driver.get("https://www.thomascook.in/");
//        loginPage.openLoginForm();
//    }
//
//    @When("I enter login details {string} and send OTP")
//    public void i_enter_login_details_and_send_otp(String loginId) {
//        loginPage.enterLoginId(loginId);
//        loginPage.clickSendOtp();
//
//        // Pause for manual OTP entry
//        System.out.println("Please enter OTP manually in the browser and then press Enter to continue...");
//        new java.util.Scanner(System.in).nextLine(); // waits for user to enter OTP manually
//    }
//
//    @When("I click on the login button")
//    public void i_click_login_button() {
//        loginPage.clickLogin();
//     
//        }
//    
//    
//
//    @Then("I should be logged in successfully")
//    public void i_should_be_logged_in_successfully() {
//        assert loginPage.isLoginSuccessful() : "Login was not successful";
//    
//    }
//    
//
//    @Then("I should see an error message")
//    public void i_should_see_error_message() {
//        assert loginPage.isErrorMessageDisplayed() : "Error message not displayed";
//    }
//}
//
//
//package stepdefinitions;
//
//import io.cucumber.java.en.*;
//import org.openqa.selenium.WebDriver;
//import pages.LoginPage;
//import factory.DriverFactory;
//import java.util.Scanner;
//
//public class LoginSteps {
//    WebDriver driver = DriverFactory.getDriver();
//    LoginPage loginPage = new LoginPage(driver);
//
//    @Given("I am on the ThomasCook login page")
//    public void i_am_on_login_page() {
//        driver.get("https://www.thomascook.in/");
//        loginPage.openLoginForm();
//    }
//
//    @When("I enter login details {string} and send OTP")
//    public void i_enter_login_details_and_send_otp(String loginId) {
//        loginPage.enterLoginId(loginId);
//        loginPage.clickSendOtp();
//
//        // Pause for manual OTP entry
//        System.out.println("Please enter OTP manually in the browser and then press Enter to continue...");
//        new Scanner(System.in).nextLine(); // waits for user to enter OTP manually
//    }
//
//    @When("I click on the login button")
//    public void i_click_login_button() {
//        loginPage.clickLogin();
//     
//    }
//
//    @Then("I should see an error message")
//    public void i_should_see_error_message() {
//        try {
//            assert loginPage.isErrorMessageDisplayed() : "Error message not displayed";
//            System.out.println("Error message displayed as expected.");
//        } finally {
//            // Close browser after failed login
//            DriverFactory.quitDriver();
//        }
//    }
//}
//package stepdefinitions;
//
//import io.cucumber.java.en.*;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import pages.LoginPage;
//import factory.DriverFactory;
//import utils.ScreenshotUtil;
//import utils.ExtentManager;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.ExtentTest;
//import java.time.Duration;
//import java.util.Scanner;
//
//public class LoginSteps {
//    WebDriver driver = DriverFactory.getDriver();
//    LoginPage loginPage = new LoginPage(driver);
//
//    @Given("I am on the ThomasCook login page")
//    public void i_am_on_login_page() {
//        driver.get("https://www.thomascook.in/");
//        loginPage.openLoginForm();
//        // Start extent test
//        ExtentManager.createTest("Login Failed");
//        ExtentTest test = ExtentManager.getTest();
//        test.info("Opened ThomasCook login page");
//    }
//
//    @When("I enter login details {string} and send OTP")
//    public void i_enter_login_details_and_send_otp(String loginId) {
//        loginPage.enterLoginId(loginId);
//        loginPage.clickSendOtp();
//        ExtentManager.getTest().info("Entered login ID and clicked Send OTP");
//
//        // Pause for manual OTP entry
//        System.out.println("Please enter OTP manually in the browser and then press Enter to continue...");
//        new Scanner(System.in).nextLine(); // waits for user to enter OTP manually
//    }
//
//    @When("I click on the login button")
//    public void i_click_login_button() {
//        loginPage.clickLogin();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        boolean loginSuccess = false;
//        ExtentTest test = ExtentManager.getTest();
//
//        try {
//            // Replace with actual login success element locator
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("successElementId")));
//            loginSuccess = true;
//        } catch (Exception e) {
//            System.out.println("Login failed or success element not found.");
//        } finally {
//            // Take screenshot and attach to Extent Report if login was successful
//            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "Login_Result");
//            if (screenshotPath != null) {
//                if (loginSuccess) {
//                    test.pass("Login successful",
//                            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//                    System.out.println("Login successful! Screenshot attached to report.");
//                } else {
//                    test.fail("Login failed",
//                            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//                    System.out.println("Login failed! Screenshot attached to report.");
//                }
//            }
//
//            // Quit browser immediately after login
//            DriverFactory.quitDriver();
//            System.out.println("Browser closed immediately after login.");
//
//            // Flush the Extent report for this test
//            ExtentManager.getExtent().flush();
//        }
//    }
//
//    @Then("I should be logged in successfully")
//    public void i_should_be_logged_in_successfully() {
//        System.out.println("Positive login assertion step (browser already closed).");
//    }
//
//    @Then("I should see an error message")
//    public void i_should_see_error_message() {
//        System.out.println("Negative scenario assertion step (browser already closed).");
//    }
//}
//
//
//
package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import factory.DriverFactory;
import utils.AppLogger;
import utils.ExtentManager;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class LoginSteps {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    ExtentTest test = ExtentManager.getTest(); // Get current test instance

    // ✅ Screenshot helper 
    private String takeScreenshot(String fileName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String destPath = System.getProperty("user.dir") + "/reports/screenshots/" + fileName + ".png";
            Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/reports/screenshots/"));
            Files.copy(src.toPath(), Paths.get(destPath));
            return destPath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Given("I am on the ThomasCook login page")
    public void i_am_on_login_page() {
       driver.get("https://www.thomascook.in/");
       loginPage.openLoginForm();
       test.info("Opened ThomasCook login page");
       AppLogger.info("Open Login Page ");
    
    }

    @When("I enter login details {string} and send OTP")
    public void i_enter_login_details_and_send_otp(String loginId) {
        loginPage.enterLoginId(loginId);
        loginPage.clickSendOtp();

        // Pause for manual OTP entry
        System.out.println("Please enter OTP manually in the browser and then press Enter to continue...");
        new Scanner(System.in).nextLine();
        AppLogger.info("Enter login Details ");
    }

    @When("I click on the login button")
    public void i_click_login_button() {
        loginPage.clickLogin();
        AppLogger.info("Click on Login Button ");
        //DriverFactory.quitDriver();
        
    }

//    @Then("I should be logged in successfully with valid OTP")
//    public void i_should_be_logged_in_successfully_with_valid_otp() {
//    	ExtentTest test = ExtentManager.getTest(); // get dynamically
//        try {
//            assert loginPage.isLoginSuccessful() : "Login was not successful";
//
//            String screenshotPath = takeScreenshot("ValidLogin");
//
//            // ✅ Mark as PASS
//            test.pass("✅ Login passed with valid user ID",
//                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//
//            System.out.println("Login successful with valid OTP.");
//        } catch (AssertionError ae) {
//            String screenshotPath = takeScreenshot("ValidLogin_Failed");
//            test.fail("❌ Expected login success but failed: " + ae.getMessage(),
//                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//        } catch (Exception e) {
//            String screenshotPath = takeScreenshot("ValidLogin_Exception");
//            test.fail("❌ Exception during login success check: " + e.getMessage(),
//                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//        } //finally {
           // driver.quit();
        //}
    

    @Then("I should see an error message")
    public void i_should_see_error_message() {
        try {
            assert loginPage.isErrorMessageDisplayed() : "Error message not displayed";

            String screenshotPath = takeScreenshot("InvalidLogin");

            // ✅ Mark as FAIL
            test.fail("❌ Login failed with invalid user ID (expected failure)",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

            System.out.println("Error message displayed as expected.");
        } catch (AssertionError ae) {
            String screenshotPath = takeScreenshot("InvalidLogin_NoErrorMessage");
            test.fail("❌ Expected error message but not displayed: " + ae.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (Exception e) {
            String screenshotPath = takeScreenshot("InvalidLogin_Exception");
            test.fail("❌ Exception during invalid login check: " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } finally {


            driver.quit();
            		}
    }
  }
