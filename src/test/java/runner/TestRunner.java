package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// Cucumber + TestNG runner
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber.html"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
