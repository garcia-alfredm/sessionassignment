package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPOM {
    WebDriver webDriver;
    WebDriverWait wait;

    @FindBy(name = "user-name")
    WebElement usernameInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(name = "login-button")
    WebElement loginButton;

    @FindBy(tagName = "h3")
    WebElement errMessage;

    public LoginPOM(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(5000));

        PageFactory.initElements(this.webDriver, this);
    }

    public void enterUsername(String username){
        this.usernameInput.sendKeys(username);
    }

    public void enterPassword(String password){
        this.passwordInput.sendKeys(password);
    }

    public void clickLoginBtn(){
        this.loginButton.click();
    }

    public String getErrorMessage(){
        this.wait.until(ExpectedConditions.visibilityOf(this.errMessage));
        return this.errMessage.getText();
    }

    public String getCurrentUrl(){
        return this.webDriver.getCurrentUrl();
    }

    public void waitForSuccessfulLogin(){
        this.wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
    }

    public void waitForLoginVisibility(){
        this.wait.until(ExpectedConditions.visibilityOf(this.loginButton));
    }

}
