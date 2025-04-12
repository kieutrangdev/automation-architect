package testcases;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BankManagementLoginTest extends TestBase {
    @Test
    public void loginTest() throws InterruptedException {
        logger.debug("Inside Login Test");
        driver.findElement(By.xpath(OR.getProperty("bmlBtn_CSS"))).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn_CSS"))),"Login not successfully");
        Reporter.log("This is a test log!", true);
    }
}
