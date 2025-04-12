package base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    public static Logger logger = Logger.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() throws Exception {
        if(driver == null) {
            PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/properties/log4j.properties");
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/Config.properties");
            config.load(fis);
            logger.debug("File config load!");

            fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/OR.properties");
            OR.load(fis);

            if (config.getProperty("browser").equals("firefox")) {

                driver = new FirefoxDriver();

            } else if (config.getProperty("browser").equals("chrome")) {
                driver = new ChromeDriver();
                System.out.println("Chrome driver loaded");
            } else if (config.getProperty("browser").equals("ie")) {
                driver = new InternetExplorerDriver();
            }
            driver.get(config.getProperty("testsiteurl"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
        }
    }
    public boolean isElementPresent(By by)
    {
        try {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

    @AfterSuite
    public void tearDown() throws Exception {
        if(driver != null) {
            driver.quit();
        }

    }
}
