package basic;

import base.BaseTest;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveElementsTests extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        log.info("Navigating to the main url");
        var url = String.format("%s%s", mainUrl, mainUrl3);
        driver.get(url);

        log.info("Waiting main page to load");
        utilities.waitSeconds(2);
    }

    @Test(groups = {regression})
    @Description("exercise 4 : remove elements")
    public void fourthTest() {
        log.info("Make click button 'add element'");
        for (int i = 0; i < 10; i++) {
            driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        }

        log.info("Verifying 10 elements");
        var deleteList = driver.findElements(By.className("added-manually"));
        Assert.assertEquals(deleteList.size(), 10);

        log.info("Make click button 'delete'");
        for (var delete : deleteList) {
            delete.click();
        }

        log.info("Verifying 0 elements");
        var cont = driver.findElements(By.className("added-manually"));
        Assert.assertEquals(cont.size(), 0);
    }
}
