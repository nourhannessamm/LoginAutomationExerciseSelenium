package utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {
    static WebDriver driver;

    @Step("Initializing new driver (Browser Type:{browserType}")
    public static WebDriver initDriver(String browserType, Boolean maximizeOption, int implicitWait, Boolean headless) {
        if (browserType.equalsIgnoreCase("chrome")) {
            //driver = new ChromeDriver();
            ChromeOptions chromeOptions;
            if (headless) {
                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                driver = new ChromeDriver(chromeOptions);
            } else {
                driver = new ChromeDriver();
            }
        } else if (browserType.equalsIgnoreCase("firefox")) {
            FirefoxOptions ffOptions;
            if (headless) {
                ffOptions = new FirefoxOptions();
                ffOptions.addArguments("--headless");
                driver = new FirefoxDriver(ffOptions);
            } else {
                driver = new FirefoxDriver();
            }
        } else if (browserType.equalsIgnoreCase("edge")) {
            EdgeOptions edgeOptions;
            if (headless) {
                edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new");
                driver = new EdgeDriver(edgeOptions);
            } else {
                driver = new EdgeDriver();
            }
        } else {
            driver = new SafariDriver();
        }
        if (maximizeOption) {
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        return driver;
    }

    /* overloading (initDriver) method by default values for the maximize option and implicit
    wait value */
    public static WebDriver initDriver(String browserType) {
        return initDriver(browserType, true, 20, false);
    }

    // overloading to use our default Global properties (Configurations)
    public static WebDriver initDriver() {
        return initDriver(System.getProperty("browserType"),
                Boolean.valueOf(System.getProperty("maximizeWindow")),
                Integer.parseInt(System.getProperty("waits")),
                Boolean.valueOf(System.getProperty("headlessExecution")));
    }

}
