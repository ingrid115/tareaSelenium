package basic;

import base.BaseTest;
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
    public void fourthTest() {

        for (int i = 0; i < 10; i++) {
            driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        }

        var deleteList = driver.findElements(By.className("added-manually"));
        Assert.assertEquals(deleteList.size(), 10);

        for (var delete : deleteList) {
            delete.click();
        }
        var cont = driver.findElements(By.className("added-manually"));
        Assert.assertEquals(cont.size(), 0);
    }

}