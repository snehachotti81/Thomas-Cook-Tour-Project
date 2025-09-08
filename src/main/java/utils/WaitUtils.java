package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtils {

    private WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public static WebElement waitForVisibility(WebDriver driver, WebElement element) {
        int seconds = Integer.parseInt(ConfigReader.get("explicit.wait"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(WebElement element) {
        int seconds = Integer.parseInt(ConfigReader.get("explicit.wait"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
