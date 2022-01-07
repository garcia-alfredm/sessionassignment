package stepdefinitions;

import com.sun.xml.internal.ws.policy.AssertionSet;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.remote.service.DriverService;
import poms.LoginPOM;

public class LoginSDF {

    private LoginPOM loginPOM;

    @After
    public void tearDown(){
        DriverSingleton.quitInstance();
    }

    @Given("a user is on the login page")
    public void a_user_is_on_the_login_page() throws InterruptedException {
        DriverSingleton.getInstance().get("https://www.saucedemo.com");
        this.loginPOM = new LoginPOM(DriverSingleton.getInstance());
        //this.loginPOM.waitForLoginVisibility();
        //Thread.sleep(5000);
        Assertions.assertEquals("https://www.saucedemo.com/", this.loginPOM.getCurrentUrl());
    }

    @When("a user inputs valid credentials")
    public void a_user_inputs_valid_credentials() {
        this.loginPOM.enterUsername("standard_user");
        this.loginPOM.enterPassword("secret_sauce");
        this.loginPOM.clickLoginBtn();
    }
    @Then("a user is redirected to the inventory page")
    public void a_user_is_redirected_to_the_inventory_page() {
        this.loginPOM.waitForSuccessfulLogin();
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", this.loginPOM.getCurrentUrl());
    }

    @When("a user inputs invalid credentials")
    public void a_user_inputs_invalid_credentials() {
        this.loginPOM.enterUsername("standard_user");
        this.loginPOM.enterPassword("wrongpassword");
        this.loginPOM.clickLoginBtn();
    }
    @Then("an error message will be displayed")
    public void an_error_message_will_be_displayed() {
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", this.loginPOM.getErrorMessage());
    }
}
