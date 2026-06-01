package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.EnvConfig;

import java.time.Duration;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {

        WebDriver webDriver;

        String browser = EnvConfig.getBrowser();

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;

            case "firefox":
            default:
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
        }

        driver.set(webDriver);

        driver.get().manage().window().maximize();

        driver.get().manage().timeouts().implicitlyWait(
                Duration.ofSeconds(EnvConfig.getWait())
        );

        driver.get().get(EnvConfig.getBaseUrl());
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}