package cucumber.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import selenium.Pages.SubscriptionPage;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class SubscriptionPageStepDef {
    @Given("I am at STC TV website")
    public void i_am_at_stc_tv_website() {
        SubscriptionPage subscriptionPage= new SubscriptionPage();
        Assert.assertTrue("user is not at stc tv homepage",subscriptionPage.isUserAtSTCTVPage());
    }

    @When("I am navigating to Kuwait Country")
    public void i_am_navigating_from_kuwait_country() {
        SubscriptionPage subscriptionPage= new SubscriptionPage();
        subscriptionPage.navigateToSTCTVKW();
    }

    @Then("I will find the following packages details")
    public void i_will_find_the_following_packages_details(DataTable typeFieldsDetails) {
        SubscriptionPage subscriptionPage= new SubscriptionPage();
        typeFieldsDetails.asLists(String.class).forEach(type->
        {
            String packageType=type.get(0);
            Assert.assertTrue("Subscription Type "+packageType+" is not visible",subscriptionPage.verifySubscriptionPackageTypeIsVisible(packageType));
            Assert.assertEquals("Subscription Type "+packageType+" Price is not correct",type.get(1),subscriptionPage.getPackagePrice(packageType));
            Assert.assertEquals("Subscription Type "+packageType+"Currency is not correct",type.get(2),subscriptionPage.getPackageCurrency(packageType));
        });
    }

    @When("^I switch Country to (Bahrain|KSA)$")
    public void i_switch_country_to_bahrain(String country) {
        SubscriptionPage subscriptionPage= new SubscriptionPage();
        subscriptionPage.switchCountryTo(country);
    }
}
