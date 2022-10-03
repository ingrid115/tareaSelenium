package base;

import listeners.SuiteListeners;
import listeners.TestListeners;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import utilities.DriverMananger;
import utilities.Logs;
import utilities.Utilities;

@Listeners({SuiteListeners.class, TestListeners.class})
public class BaseTest {
    protected final Logs log = new Logs();
    protected final Utilities utilities = new Utilities();
    protected final DriverMananger driverMananger = new DriverMananger();
    protected SoftAssert softAssert;
    protected WebDriver driver;
    protected final String smoke = "Smoke";
    protected final String regression = "Regression";
    protected final String mainUrl = "http://the-internet.herokuapp.com/";
    protected final String mainUrl1 = "login";
    protected final String mainUrl2 = "checkboxes";
    protected final String mainUrl3 = "add_remove_elements/";
    protected final String mainUrl4 = "status_codes";

    @BeforeMethod(alwaysRun = true)
    public void setupBase() {
        softAssert = new SoftAssert();
        driver = driverMananger.createDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void teardownBase() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
