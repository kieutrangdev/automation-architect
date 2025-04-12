package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest {
    @Test(dataProvider = "getData")
    public void addCustomer(String firstName, String lastName, String code)
    {

    }
    @DataProvider
    public Object[][] getData()
    {

    }

}
