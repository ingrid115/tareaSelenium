package basic;

import base.BaseTest;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        log.info("Navigating to the main url");
        var url = String.format("%s%s", mainUrl, mainUrl1);
        driver.get(url);

        log.info("Waiting main page to load");
        utilities.waitSeconds(2);
    }

    @Test(groups = {smoke})
    @Description("exercise 1 : login")
    public void firstTest() {
        log.info("Verifying Login displayed");
        Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("radius")).isDisplayed());

        log.info("Login credentials");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        log.info("Make click");
        driver.findElement(By.className("radius")).click();

        log.info("Waiting main page to load");
        utilities.waitSeconds(2);

        log.info("Verifying message");
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='flash success']")).isDisplayed());

        log.info("Verifying button displayed");
        Assert.assertTrue(driver.findElement(By.cssSelector("a[class='button secondary radius']")).isDisplayed());

        log.info("Make click");
        driver.findElement(By.cssSelector("a[class='button secondary radius']")).click();

        log.info("Waiting main page to load");
        utilities.waitSeconds(2);

        log.info("Verifying Login displayed");
        Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed());
    }

    @Test(groups = {smoke, regression})
    @Description("exercise 2 : login")
    public void secondTest() {
        log.info("Verifying Login displayed");
        Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("radius")).isDisplayed());

        log.info("Login credentials");
        driver.findElement(By.id("username")).sendKeys("hola123");
        driver.findElement(By.id("password")).sendKeys("hehehe");

        log.info("Make click");
        driver.findElement(By.className("radius")).click();

        log.info("Waiting main page to load");
        utilities.waitSeconds(2);

        log.info("Verifying message");
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='flash error']")).isDisplayed());
    }
}
