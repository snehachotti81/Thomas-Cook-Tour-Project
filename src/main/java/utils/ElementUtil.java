package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ElementUtil {

    private WebDriver driver;
    private WebDriverWait wait;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Scroll element into view
    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Type text into input
    public void type(WebElement element, String text) {
        scrollIntoView(element);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    // Click element
    public void click(WebElement element) {
        scrollIntoView(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    // Click using JavaScript (useful for overlays)
    public void clickUsingJS(WebElement element) {
        scrollIntoView(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // Get text
    public String getText(WebElement element) {
        scrollIntoView(element);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    // Select from dropdown by visible text
    public void selectByVisibleText(WebElement element, String text) {
        scrollIntoView(element);
        wait.until(ExpectedConditions.visibilityOf(element));
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    // Wait until element is visible
    public WebElement waitForVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait until element is clickable
    public WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}

