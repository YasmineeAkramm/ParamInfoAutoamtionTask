package BasePackage;


import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * BrowserOptions class file scope is to store options for each browser
 *
 * @author yakram
 */

public class BrowserOptions {
    /**
     * Set the Chrome browser option values into a Chrome options Object
     *
     * @return Object of ChromeOptions
     */
    public static ChromeOptions getChromeBrowserOptions() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.setHeadless(false);
        return options;
    }

    /**
     * Set the Firefox browser option values into a Chrome options Object
     *
     * @return Object of FirefoxOptions
     */
    public static FirefoxOptions getFireFoxOptions() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.setHeadless(false);
        return options;
    }
}
