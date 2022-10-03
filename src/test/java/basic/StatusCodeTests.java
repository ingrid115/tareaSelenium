package basic;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StatusCodeTests extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        log.info("Navigating to the main url");
        var url = String.format("%s%s", mainUrl, mainUrl4);
        driver.get(url);

        log.info("Waiting main page to load");
        utilities.waitSeconds(2);
    }

    @Test(groups = {smoke, regression})
    public void fifthTest() {
        var currentUrl = driver.getCurrentUrl();

        driver.findElement(By.xpath("//a[text()='404']")).click();
        log.info("Waiting main page to load");
        utilities.waitSeconds(2);

        driver.findElement(By.xpath("//a[text()='here']")).click();
        log.info("Waiting main page to load");
        utilities.waitSeconds(2);

        var currentUrl2 = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl2, currentUrl);

    }
}
