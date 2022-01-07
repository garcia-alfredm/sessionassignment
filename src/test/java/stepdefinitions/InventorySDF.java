package stepdefinitions;

import io.cucumber.java.bs.I;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import poms.InventoryPOM;

public class InventorySDF {
    private InventoryPOM inventoryPOM = new InventoryPOM(DriverSingleton.getInstance());

    @Given("a user is on the inventory page")
    public void a_user_is_on_the_inventory_page() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", this.inventoryPOM.getCurrentUrl());
    }
    @When("a user clicks the add-to-cart button on an item")
    public void a_user_clicks_the_add_to_cart_button_on_an_item() {
        this.inventoryPOM.clickAddToCartBtn();
    }
    @Then("the shopping cart badge count increases by one")
    public void the_shopping_cart_badge_count_increases_by_one(){
        Assertions.assertEquals(new String("1"), this.inventoryPOM.shoppingCartNumberIncreases());
    }

    @When("a user clicks on the shopping cart icon")
    public void a_user_clicks_on_the_shopping_cart_icon() {
        this.inventoryPOM.clickShoppingCartLink();
    }
    @Then("the user is redirected to the cart page")
    public void the_user_is_redirected_to_the_cart_page() {
        Assertions.assertEquals("https://www.saucedemo.com/cart.html", this.inventoryPOM.getCurrentUrl());
    }

}
