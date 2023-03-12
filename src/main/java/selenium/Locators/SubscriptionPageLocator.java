package selenium.Locators;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public enum SubscriptionPageLocator {
    STC_TV_PAGE_LOGO(By.xpath("//a[@id='jawwy-logo-web']")),
    SWITCH_COUNTRY_BUTTON(By.xpath("//a[@id='country-btn']")),
    SWITCH_COUNTRY_OPTIONS_POPUP(By.xpath("//div[@id='country-selct']")),
    SWITCH_COUNTRY_POPUP_COUNTRY_BOX("//div[@id='country-selct']//span[contains(@id,'contry-lable') and contains(text(),'%s')]/.."),
    LOGGED_COUNTRY_BOX("//div[@id='country']//span[contains(text(),'%s')]"),
    SUBSCRIPTION_PACKGES_TYPES_BY_TEXT("//div[@class='plan-names']//strong[@class='plan-title' and contains(text(),'%s')]"),
    SUBSCRIPTION_PACKAGE_PRICE_BY_TYPE("//div[@class='price' and @id='currency-%s']//b"),
    SUBSCRIPTION_PACKAGE_CURRENCY_BY_TYPE("//div[@class='price' and @id='currency-%s']//i");;

    static Logger logger = Logger.getLogger(SubscriptionPageLocator.class.getName());
    private By locator;
    private String key;

    SubscriptionPageLocator(By locator) {
        this.locator = locator;
    }
    SubscriptionPageLocator(String key) {
        this.key = key;
    }

    public By by() {
        logger.trace("Subscription Page Locator");
        return locator;
    }

    public By by(Object... index) {
        logger.trace("Subscription Page selector");
        return (By.xpath(String.format(key, index)));
    }
}
