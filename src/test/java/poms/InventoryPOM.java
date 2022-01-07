package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPOM {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement backpackBtn;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    WebElement cartLink;

    public InventoryPOM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5000));

        PageFactory.initElements(this.driver, this);
    }

    public void clickAddToCartBtn(){
        this.backpackBtn.click();
    }

    public void clickShoppingCartLink(){
        this.cartLink.click();
    }

    public String shoppingCartNumberIncreases(){
        this.wait.until(ExpectedConditions.visibilityOf(this.cartBadge));
        return this.cartBadge.getText();
    }

    public String getCurrentUrl(){
        System.out.println(this.driver);
        return this.driver.getCurrentUrl();
    }

    public void waitForSuccessfulLogin(){
        this.wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
    }

}
