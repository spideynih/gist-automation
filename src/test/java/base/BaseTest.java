package base;

import core.DriverManager;
import listeners.AllureListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({AllureListener.class})
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}