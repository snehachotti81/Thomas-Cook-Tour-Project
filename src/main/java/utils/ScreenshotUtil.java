package utils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {
     //Takes a screenshot and returns a path suitable for ExtentReports.
    public static String takeScreenshot(WebDriver driver, String name) {
        try {
            // Base folder for screenshots (should be relative to project)
            String folder = ConfigReader.get("screenshot.path"); // e.g., "screenshots"
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = name.replaceAll("[^a-zA-Z0-9-_\\.]", "_") + "_" + timestamp + ".png";

            // Use relative path for Extent reports
            Path relativePath = Path.of(folder, fileName);
            Files.createDirectories(relativePath.getParent());

            // Capture screenshot
            byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Files.write(relativePath, bytes);

            // Return file:// URL for Extent to read properly
            return relativePath.toUri().toString();
        } catch (Exception e) {
            System.err.println("Failed to take screenshot: " + e.getMessage());
            return null;
        }
    }
}



