package selenium.Pages;
import BasePackage.DriverFactory;
import selenium.driver.CustomWebDriver;


/**
 * BasePage used to hold all the shared attributes or methods between all pages
 *
 * @author yakram
 */
public class BasePage {
    public static CustomWebDriver driver = DriverFactory.getDriver();

}
