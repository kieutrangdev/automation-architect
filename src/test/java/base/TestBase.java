package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;

    @BeforeSuite
    public void setUp() throws Exception {
        if(driver == null) {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/Config.properties");
            config.load(fis);

            fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/OR.properties");
            OR.load(fis);

        }

    }
}
