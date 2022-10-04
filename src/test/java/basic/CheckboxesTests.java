package basic;

import base.BaseTest;
import jdk.jfr.Description;
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
    @Description("exercise 3 : checkbox")
    public void ThirdTest() {
        log.info("Verifying checkbox");
        var selectList = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (var select : selectList) {
            Assert.assertFalse(selectList.get(0).isSelected());
            Assert.assertTrue(selectList.get(1).isSelected());
        }

        log.info("Mark checkbox 1/ uncheck checkbox 2");
        for (var button : selectList) {
            button.click();
        }

        log.info("Verifying checkbox");
        for (var select : selectList) {
            Assert.assertTrue(selectList.get(0).isSelected());
            Assert.assertFalse(selectList.get(1).isSelected());
        }
    }
}
