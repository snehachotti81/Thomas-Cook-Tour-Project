package utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import utils.ConfigReader;
public class ExtentManager {

    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> TEST_THREAD = new ThreadLocal<>();

    public static synchronized ExtentReports getExtent() {
        if (extent == null) {
            String out = ConfigReader.get("report.path");
            ExtentSparkReporter spark = new ExtentSparkReporter(out + "/extent.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Project", "Thomos Cook Tour");
        }
        return extent;
    }

    public static synchronized ExtentTest createTest(String name) {
        ExtentTest t = getExtent().createTest(name);
        TEST_THREAD.set(t);
        return t;
    }

    public static synchronized ExtentTest getTest() {
        return TEST_THREAD.get();
    }

    public static synchronized void removeTest() {
        TEST_THREAD.remove();
    }
 // ✅ Add this flush method
    public static synchronized void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
 
}
