package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features/inventory.feature",
        glue = "stepdefinitions",
        dryRun = false, //dry run verifies that there is a step definition for each step
        plugin = {"pretty", "html:target/cucumber.html"} //can out put results to an html file
)
public class CucumberTestRunner {

}
