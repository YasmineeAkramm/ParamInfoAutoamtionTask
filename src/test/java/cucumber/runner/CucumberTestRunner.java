package cucumber.runner;

import org.junit.runner.RunWith;
import io.cucumber.testng.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Cucumber Runner class
 *
 * @author yakram
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"src/test/java/cucumber/stepdefs"}
)
public class CucumberTestRunner {
}
