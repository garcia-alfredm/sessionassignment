package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.CartPOM;

public class CartSDF {

    private CartPOM cartPOM = new CartPOM(DriverSingleton.getInstance());

    @Given("a user is on the shopping cart page")
    public void a_user_is_on_the_shopping_cart_page() {
        Assertions.assertEquals("https://www.saucedemo.com/cart.html", cartPOM.getCurrentUrl());
    }
    @When("the checkout button is clicked")
    public void the_checkout_button_is_clicked() {
        this.cartPOM.clickCheckoutBtn();
    }
    @Then("user is redirected to step one page")
    public void user_is_redirected_to_step_one_page() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-one.html", this.cartPOM.getCurrentUrl());
    }

}
