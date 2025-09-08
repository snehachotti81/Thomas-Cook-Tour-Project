package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

public class RegistrationPage {

    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By loginToggle = By.xpath("//*[@id='LoginLogoutToggel']");
    By newUserRegister = By.xpath("//*[@id='newUserId']/p[1]/a[1]");
    By titleDropdown = By.xpath("//select[@name='title']");
    By firstName = By.xpath("//input[@id='registerFName']");
    By lastName = By.xpath("//input[@id='registerLName']");
    By emailId = By.xpath("//input[@id='registerEmailId']");
    By password = By.xpath("//input[@id='registerPwd']");
    By confirmPassword = By.xpath("//input[@id='registerConfirmPwd']");
    By mobile = By.xpath("//input[@id='registerMobileNo']");
    By privacyPolicy = By.xpath("//input[@id='tandc']");
    By registerButton = By.xpath("//button[text()='Register']");

    // Field-level error locators (adjust if actual DOM differs)
    By firstNameError = By.xpath("//input[@id='registerFName']/following-sibling::span[contains(@class,'error-msg')]");
    By lastNameError = By.xpath("//input[@id='registerLName']/following-sibling::span[contains(@class,'error-msg')]");
    By emailError = By.xpath("//input[@id='registerEmailId']/following-sibling::span[contains(@class,'error-msg')]");
    By mobileError = By.xpath("//input[@id='registerMobileNo']/following-sibling::span[contains(@class,'error-msg')]");
    By passwordError = By.xpath("//input[@id='registerPwd']/following-sibling::span[contains(@class,'error-msg')]");
    By confirmPasswordError = By.xpath("//input[@id='registerConfirmPwd']/following-sibling::span[contains(@class,'error-msg')]");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // navigation
    public void clickLoginToggle() {
        wait.until(ExpectedConditions.elementToBeClickable(loginToggle)).click();
    }

    public void clickNewUserRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(newUserRegister)).click();
        // wait until first name visible to ensure modal loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
    }

    // select title
    public void selectTitle(String title) {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(titleDropdown));
        new Select(dropdown).selectByVisibleText(title);
    }

    // --- Field entry methods that use driver.findElement(...) as requested ---
    private void safeSendKeys(By locator, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
            // primary approach: use driver.findElement(...) directly
            WebElement el = driver.findElement(locator);
            el.clear();
            el.sendKeys(value);
            // trigger blur/validation
            el.sendKeys(Keys.TAB);
            // small pause to let JS validation run (keeps it stable)
            try { Thread.sleep(300); } catch (InterruptedException ignored) {}
            // verify value set; if not, fallback to JS
            String current = el.getAttribute("value");
            if (current == null || !current.equals(value)) {
                // fallback: set value via JS and dispatch events
                ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].value = arguments[1];" +
                    "arguments[0].dispatchEvent(new Event('input'));" +
                    "arguments[0].dispatchEvent(new Event('change'));" +
                    "arguments[0].dispatchEvent(new Event('blur'));",
                    el, value
                );
            }
        } catch (Exception e) {
            // absolute fallback: JS set (if driver.findElement failed)
            try {
                WebElement el = driver.findElement(locator);
                ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].value = arguments[1];" +
                    "arguments[0].dispatchEvent(new Event('input'));" +
                    "arguments[0].dispatchEvent(new Event('change'));" +
                    "arguments[0].dispatchEvent(new Event('blur'));",
                    el, value
                );
            } catch (Exception ignored) {}
        }
    }

    public void enterFirstName(String fName) {
        safeSendKeys(firstName, fName);
    }

    public void enterLastName(String lName) {
        safeSendKeys(lastName, lName);
    }

    public void enterEmail(String email) {
        safeSendKeys(emailId, email);
    }

    public void enterMobile(String mobileNo) {
        safeSendKeys(mobile, mobileNo);
    }

    public void enterPassword(String pwd) {
        safeSendKeys(password, pwd);
    }

    public void enterConfirmPassword(String confPwd) {
        safeSendKeys(confirmPassword, confPwd);
    }

    // privacy policy checkbox (JS click to avoid overlay issues)
//    public void selectPrivacyPolicy() {
//        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(privacyPolicy));
//        if (!checkbox.isSelected()) {
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
//        }
//    }

    // register click with JS fallback
    public void clickRegister() {
        WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(registerButton));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(registerButton));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        } catch (Exception e) {
            // final fallback
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        }
    }

    // --- Error retrieval ---
    private String getErrorText(By locator) {
        try {
            WebElement err = driver.findElement(locator);
            if (err.isDisplayed()) {
                String text = err.getText();
                return text == null ? "" : text.trim();
            }
        } catch (NoSuchElementException ignored) {}
        return "";
    }

    public String getFirstNameError() { return getErrorText(firstNameError); }
    public String getLastNameError() { return getErrorText(lastNameError); }
    public String getEmailError() { return getErrorText(emailError); }
    public String getMobileError() { return getErrorText(mobileError); }
    public String getPasswordError() { return getErrorText(passwordError); }
    public String getConfirmPasswordError() { return getErrorText(confirmPasswordError); }

    public Map<String, String> getAllFieldErrors() {
        Map<String, String> errors = new LinkedHashMap<>();
        errors.put("First Name", getFirstNameError());
        errors.put("Last Name", getLastNameError());
        errors.put("Email", getEmailError());
        errors.put("Mobile", getMobileError());
        errors.put("Password", getPasswordError());
        errors.put("Confirm Password", getConfirmPasswordError());
        return errors;
    }
}
