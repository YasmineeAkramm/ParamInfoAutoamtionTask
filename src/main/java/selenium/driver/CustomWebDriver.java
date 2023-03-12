package selenium.driver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * CustomWebDriver class is used to hold all the common selenium driver methods
 *
 * @author yakram
 */
public class CustomWebDriver {
    private final WebDriver driver;

    public CustomWebDriver(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * open the url page
     *
     * @param pageUrl url to open
     */
    public void openPage(String pageUrl) {
        driver.get(pageUrl);
    }

    /**
     * driver close
     */
    public void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    /**
     * find and gets the webelement for the by locator
     *
     * @param locator to find
     * @return WebElement
     */
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    /**
     * find and gets the webelements for the by locator
     *
     * @param locator to find
     * @return WebElements List
     */
    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    /**
     * Checks if webelement is visible
     *
     * @param by locator to check
     * @return return true if visible, false if not
     */
    public boolean isVisible(By by) {
        return driver.findElement(by).isDisplayed();
    }

    /**
     * Use this method to simulate typing into an element,which includes set its value
     * Waits for the element, clear the data inside element and send the new key
     * sequence.
     *
     * @param keys    character sequence to send to the element
     * @param locator From the element we want to operate
     */
    public void sendKeysToAndEnter(String keys, WebElement locator) {
        locator.clear();
        locator.sendKeys(keys);
        locator.sendKeys(Keys.ENTER);
    }

    /**
     * driver wait till element is visible
     *
     * @param by      element the driver will wait for
     * @param seconds seconds to wait
     * @return boolean
     */
    public boolean waitExpectedConditionsVisibilityOf(By by, int seconds) {
        Duration durationInSeconds = Duration.ofSeconds(seconds);
        WebDriverWait wait = new WebDriverWait(driver, durationInSeconds);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return isVisible(by);
        } catch (TimeoutException ex) {
            return false;
        }
    }

    /**
     * driver wait till element is visible and clicks
     *
     * @param by element the driver will click on
     */

    public void clickOn(By by) {
        waitExpectedConditionsVisibilityOf(by, 5);
        driver.findElement(by).click();
    }

    /**
     * Return the text from from the element
     *
     * @param element element to get text of
     * @return string that contains specified element text
     */
    public String getTextFromElement(By element) {
        waitExpectedConditionsVisibilityOf(element, 5);
        return driver.findElement(element).getText();
    }

    /**
     * Return the text from all the element specified by the by
     *
     * @param elements List of webelements to get text from
     * @return List of string that contains all the specified element text
     */
    public List<String> getTextFromAllChildElements(List<WebElement> elements) {
        List<String> texts = new ArrayList<>();
        for (WebElement element : elements) {
            texts.add(element.getText());
        }
        return texts;
    }

}
