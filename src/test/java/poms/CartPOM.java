package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPOM {
    WebDriver driver;
    WebDriverWait wait;

    CartPOM cartPOM;

    @FindBy(name = "checkout")
    WebElement checkoutBtn;

    public CartPOM(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5000));

        PageFactory.initElements(this.driver, this);
    }

    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }

    public void clickCheckoutBtn(){
        this.checkoutBtn.click();
    }

    public void waitForShoppingCartPage(){
        this.wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/cart.html"));
    }

    public void waitForStepOnePage(){
        this.wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/checkout-step-one.html"));
    }
}
