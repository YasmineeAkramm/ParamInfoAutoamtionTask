package cucumber.hooks;

import BasePackage.BrowserOptions;
import BasePackage.DriverFactory;
import BasePackage.SystemPropertise;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;

/**
 * GlobalHooks contains all the hooks which will be triggered before each scenario run
 *
 * @author yakram
 */
public class GlobalHooks {

    private static final org.apache.log4j.Logger logger = Logger.getLogger(GlobalHooks.class.getName());



    @Before(order = 0)
    public void startBrowser() {
        logger.trace("start browser");
        DriverFactory.setDriver(SystemPropertise.getSeleniumBrowser());
    }

    @Before(order = 1)
    public void logScenarioName(Scenario scenario) {
        String message = "Entering scenario " + scenario.getName();
        logger.info(message);
    }

    @Before(order = 2)
    public void goToURL() {
        logger.trace("open Home Page");
        DriverFactory.getDriver().openPage(SystemPropertise.getUrl());
    }

    @After(order = 0)
    public void closeBrowser() throws InterruptedException {
        logger.info("Browser is closed");
        DriverFactory.getDriver().quit();
    }
}
