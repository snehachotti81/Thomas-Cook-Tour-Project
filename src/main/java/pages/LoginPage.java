package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Locators
    private By loginToggle = By.xpath("//*[@id='LoginLogoutToggel']");
    private By mainLogin = By.xpath("//*[@id='mainLogIn']");
    private By loginIdField = By.xpath("//*[@id='loginId']");
    private By sendOtpBtn = By.xpath("//*[@id='sendOTP']");
    private By loginBtn = By.xpath("//*[@id='loginButton']");
    private By errorMsg = By.xpath("//*[@id=\"loginErrorMessage\"]/p[1]/span[1]"); // Update if different
    private By profileIcon = By.xpath("//div[@class='profile-icon']"); // Update if different

    // Actions
    public void openLoginForm() {
        wait.until(ExpectedConditions.elementToBeClickable(loginToggle)).click();
        wait.until(ExpectedConditions.elementToBeClickable(mainLogin)).click();
    }

    public void enterLoginId(String loginId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginIdField)).sendKeys(loginId);
    }

    public void clickSendOtp() {
        driver.findElement(sendOtpBtn).click();
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

//    public boolean isLoginSuccessful() {
//        try {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(profileIcon));
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }

    public boolean isErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
