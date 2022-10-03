package basic;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTests extends BaseTest {

    @Test(groups = {smoke})
    public void firstTest() {
        var currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed());
        //Assert.assertTrue(driver.findElement(By.className("fa fa-2x fa-sign-in")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()=' Login']")).isDisplayed());

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("fa fa-2x fa-sign-in")).click();

        log.info("Waiting main page to load");
        utilities.waitSeconds(2);
        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed());
        //Assert.assertTrue(driver.findElement(By.className("flash success")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("button secondary radius")).isDisplayed());
        driver.findElement(By.className("button secondary radius")).click();

        log.info("Waiting main page to load");
        utilities.waitSeconds(2);
        Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed());
    }

    @Test(groups = {smoke, regression})
    public void secondTest() {
        var currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("fa fa-2x fa-sign-in")).isDisplayed());

        driver.findElement(By.id("username")).sendKeys("hola123");
        driver.findElement(By.id("password")).sendKeys("hehehe");
        driver.findElement(By.className("fa fa-2x fa-sign-in")).click();

        log.info("Waiting main page to load");
        utilities.waitSeconds(2);
        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed());
        //Assert.assertTrue(driver.findElement(By.className("flash error")).isDisplayed());
    }

}
