package BasePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import selenium.driver.CustomWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * DriverFactory class file scope is to set driver options based on browser used or get the driver object
 *
 * @author yakram
 */
public class DriverFactory {
    public static CustomWebDriver driver;
    private static final org.apache.log4j.Logger logger = Logger.getLogger(DriverFactory.class.getName());

    /**
     * set driver based on browser used
     *
     * @param browserName brower at propertise file
     */
    public static void setDriver(String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")) {
            logger.info("Chrome Browser will Start");
            WebDriverManager.chromedriver().setup();
            driver = new CustomWebDriver(new ChromeDriver(BrowserOptions.getChromeBrowserOptions()));
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            logger.info("FireFox Browser will Start");
            driver = new CustomWebDriver(new FirefoxDriver(BrowserOptions.getFireFoxOptions()));
        } else {
            throw new RuntimeException("Unsupported browser! will not start any browser");
        }
    }

    /**
     * Get the driver
     *
     * @return static driver
     */
    public static CustomWebDriver getDriver() {
        return driver;
    }
}
