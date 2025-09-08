package base;
import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import utils.ExtentManager;

public class BaseTest {
    protected WebDriver driver;
    protected ExtentReports extent = ExtentManager.getExtent();
    protected ExtentTest test;
    
}
