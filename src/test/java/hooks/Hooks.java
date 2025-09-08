package hooks;
import factory.DriverFactory;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class Hooks {
    @Before
    public void beforeScenario(Scenario scenario) {
        // Start WebDriver
        DriverFactory.initDriver();
        // Start Extent test
        ExtentManager.createTest(scenario.getName());
        ExtentManager.getTest().info("Scenario started: " + scenario.getName());
    }
    @After
    public void afterScenario(Scenario scenario) {
        ExtentTest test = ExtentManager.getTest();
        String screenshotPath = null;

        try {
            // Take screenshot for both pass and fail
            screenshotPath = ScreenshotUtil.takeScreenshot(DriverFactory.getDriver(), scenario.getName());

            if (scenario.isFailed()) {
                if (screenshotPath != null) {
                    test.fail("Scenario failed. Screenshot attached",
                            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                } else {
                    test.fail("Scenario failed. Screenshot unavailable.");
                }
            } else {
                if (screenshotPath != null) {
                    test.pass("Scenario passed. Screenshot attached",
                            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                } else {
                    test.pass("Scenario passed. Screenshot unavailable.");
                }
            }
        } catch (Exception e) {
            test.warning("Exception in afterScenario: " + e.getMessage());
        } finally {
            // Flush report
            ExtentManager.getExtent().flush();
            ExtentManager.removeTest();
            // Quit browser after each scenario
           DriverFactory.quitDriver();    
        }
    }
}
   


