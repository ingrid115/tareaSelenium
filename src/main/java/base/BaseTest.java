package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import utilities.Logs;

public class BaseTest {
    protected final Logs log = new Logs();
    protected SoftAssert softAssert;
    protected final String smoke = "Smoke";
    protected final String regression = "Regression";

    @BeforeMethod(alwaysRun = true)
    public void setupBase() {
        softAssert = new SoftAssert();
        log.info("Iniciando el baseTest");
    }

    @AfterMethod(alwaysRun = true)
    public void teardownBase() {
        log.info("Terminando el base Test");
        log.info(" ");
    }
}
