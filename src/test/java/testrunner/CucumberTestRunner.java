package testrunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import poms.CartPOM;
import stepdefinitions.DriverSingleton;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features/cart.feature",
        glue = "stepdefinitions",
        dryRun = false, //dry run verifies that there is a step definition for each step
        plugin = {"pretty", "html:target/cucumber.html"} //can out put results to an html file
)
public class CucumberTestRunner {

}
