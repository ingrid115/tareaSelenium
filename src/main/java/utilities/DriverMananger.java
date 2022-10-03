package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class DriverMananger {
    protected final Logs log = new Logs();
    protected final String screenShotPath = "src/test/resources/screenshots";

    public WebDriver createDriver() {
        var browserName = System.getProperty("browser");

        if (browserName == null) {
            log.debug("Setting default local browser to CHROME");
            browserName = "CHROME";
        }

        WebDriver driver;
        switch (browserName) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                return null;
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }

    public void getScreenshot(WebDriver driver, String screenshotName) {
        log.debug("Taking screenshot");

        var screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        var path = String.format("%s/%s.png", screenShotPath, screenshotName);

        try {
            FileUtils.copyFile(screenshotFile, new File(path));
        } catch (IOException ioException) {
            log.error("Invalid path");
            log.error(ioException.getLocalizedMessage());
        }
    }

    @Attachment(value = "Screenshot failure", type = "image/png")
    public byte[] getAllureScreenshot(WebDriver driver) {
        log.info("Attaching screenshot to allure");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void deleteScreenshotDirectory() {
        try {
            log.debug("Deleting screenshot folder");
            FileUtils.deleteDirectory(new File(screenShotPath));
        } catch (IOException ioException) {
            log.error("Failed deleting directory");
            log.error(ioException.getLocalizedMessage());
        }
    }
}
