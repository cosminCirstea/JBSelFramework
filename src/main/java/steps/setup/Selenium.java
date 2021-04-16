package steps.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.DataFromPropertyFile;

import java.util.HashMap;
import java.util.Map;

public class Selenium {

    // This can potentially be upgraded to be used for multi threading if needed,
    // holding multiple instances of webDriver
    private Map<Long, WebDriver> driverMap = new HashMap<>();
    private WebDriver cachedWebDriver;

    private void initDriver(){
        driverMap.put(Thread.currentThread().getId(), initFirefoxDriver());
    }

    private WebDriver getDriver() {
        initDriver();
        cachedWebDriver = driverMap.get(Thread.currentThread().getId());
        return cachedWebDriver;
    }

    private WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", new DataFromPropertyFile().getChromeDriverLocationWin());
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.getWindowHandle();
        return driver;
    }

    private WebDriver initFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", new DataFromPropertyFile().getGeckoDriverLocationWin());
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.getWindowHandle();
        return driver;
    }

    // returns an already instantiated webDriver or instantiates a new one if none exists
    // this is to ensure usage of the same instance of webDriver across the same flow of tests
    public WebDriver getCachedWebDriver() {
        return cachedWebDriver != null ? cachedWebDriver : getDriver();
    }

    public void quitDriver(){
        if (cachedWebDriver != null) {
            cachedWebDriver.quit();
            cachedWebDriver = null;
            driverMap.clear();
        }
    }
}
