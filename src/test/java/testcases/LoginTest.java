package testcases;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test
    public void loginTest() throws InterruptedException {
        logger.debug("Inside Login Test");
        driver.findElement(By.xpath(OR.getProperty("bmlBtn_CSS"))).click();
        Thread.sleep(5000);
        Reporter.log("This is a test log!", true);
    }
}
