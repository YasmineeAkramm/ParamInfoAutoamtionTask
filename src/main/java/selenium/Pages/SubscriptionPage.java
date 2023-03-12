package selenium.Pages;

import static selenium.Locators.SubscriptionPageLocator.*;

public class SubscriptionPage extends BasePage {


    public boolean isUserAtSTCTVPage() {
        driver.waitExpectedConditionsVisibilityOf(STC_TV_PAGE_LOGO.by(), 10);
        return driver.isVisible(STC_TV_PAGE_LOGO.by());
    }

    public void navigateToSTCTVKW() {
        driver.openPage(" https://subscribe.stctv.com/kw-en");
    }

    public void switchCountryTo(String country) {
        driver.clickOn(SWITCH_COUNTRY_BUTTON.by());
        driver.waitExpectedConditionsVisibilityOf(SWITCH_COUNTRY_OPTIONS_POPUP.by(),10);
        driver.clickOn(SWITCH_COUNTRY_POPUP_COUNTRY_BOX.by(country));
        driver.waitExpectedConditionsVisibilityOf(LOGGED_COUNTRY_BOX.by(country),10);
    }

    public boolean verifySubscriptionPackageTypeIsVisible(String packageType) {
       return driver.isVisible(SUBSCRIPTION_PACKGES_TYPES_BY_TEXT.by(packageType));
    }

    public String getPackagePrice(String packageType) {
        driver.waitExpectedConditionsVisibilityOf(SUBSCRIPTION_PACKGES_TYPES_BY_TEXT.by(packageType),10);
        return driver.getTextFromElement(SUBSCRIPTION_PACKAGE_PRICE_BY_TYPE.by(packageType.toLowerCase()));
    }

    public String getPackageCurrency(String packageType) {
        driver.waitExpectedConditionsVisibilityOf(SUBSCRIPTION_PACKGES_TYPES_BY_TEXT.by(packageType),10);
        return driver.getTextFromElement(SUBSCRIPTION_PACKAGE_CURRENCY_BY_TYPE.by(packageType.toLowerCase()));
    }
}
