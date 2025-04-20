package testcases;

import base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest extends TestBase {
    @Test(dataProvider = "getData")
    public void addCustomer(String firstName, String lastName, String code, String alertText) throws InterruptedException {
        driver.findElement(By.xpath(OR.getProperty("bmlBtn_CSS"))).click();
        driver.findElement(By.cssSelector(OR.getProperty("addCustBtn_CSS"))).click();
        driver.findElement(By.cssSelector(OR.getProperty("firstname_CSS"))).sendKeys(firstName);
        driver.findElement(By.cssSelector(OR.getProperty("lastname_XPATH"))).sendKeys(lastName);
        driver.findElement(By.cssSelector(OR.getProperty("postcode_CSS"))).sendKeys(code);
        driver.findElement(By.cssSelector(OR.getProperty("addCustSub_CSS"))).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.getText().contains(alertText);

    }
    @DataProvider
    public Object[][] getData()
    {
        String sheetName = "addCustomer";
        int rows = excel.getRowCount(sheetName);
        int cols = excel.getColumnCount(sheetName);
        Object[][] data = new Object[rows-1][cols];
        for(int row=2;row<=rows;row++)
        {
            for(int col=0;col<cols;col++)
            {
                data[row-2][col] = excel.getCellData("addCustomer", col, row);
            }
        }
        return data;
    }

}
