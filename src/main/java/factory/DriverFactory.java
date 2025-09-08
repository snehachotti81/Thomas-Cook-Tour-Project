package factory;
import utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> THREAD_DRIVER = new ThreadLocal<>();
    public static void initDriver() {
        if (THREAD_DRIVER.get() == null) {
            String browser = ConfigReader.get("browser");
            WebDriver driver;
            if ("firefox".equalsIgnoreCase(browser)) {
                driver = new FirefoxDriver();
            } else {
              
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-extensions");
                options.addArguments("--start-maximized");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--disable-notifications"); // allow notifications
                driver = new ChromeDriver(options);
            }
            // Implicit wait
            long implicit = Long.parseLong(ConfigReader.get("implicit.wait"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicit));
            driver.manage().window().maximize();
            
            String baseUrl = ConfigReader.get("base.url");
            driver.get(baseUrl);

            // Wait for page to render
            try {
                Thread.sleep(2000);
           } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Save driver in ThreadLocal
            THREAD_DRIVER.set(driver);
        }
    }
    //Get WebDriver instance for the current thread.
    public static WebDriver getDriver() {
        return THREAD_DRIVER.get();
    }
    //Quit WebDriver and remove from ThreadLocal.
    public static void quitDriver() {
        WebDriver driver = THREAD_DRIVER.get();
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception ignored) {}
            THREAD_DRIVER.remove();
        }
    }
}
