package basic;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxesTests extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        log.info("Navigating to the main url");
        var url = String.format("%s%s", mainUrl, mainUrl2);
        driver.get(url);

        log.info("Waiting main page to load");
        utilities.waitSeconds(2);
    }

    @Test(groups = {regression})
    public void ThirdTest() {

        var selectList = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (var select : selectList) {
            Assert.assertFalse(selectList.get(0).isSelected());
            Assert.assertTrue(selectList.get(1).isSelected());
        }

        for (var button : selectList) {
            button.click();
        }

        for (var select : selectList) {
            Assert.assertTrue(selectList.get(0).isSelected());
            Assert.assertFalse(selectList.get(1).isSelected());
        }
    }
}
