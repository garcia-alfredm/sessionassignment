package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    public static WebDriver driver = null;

    public DriverSingleton() {
    }

    public static WebDriver getInstance(){
        if(driver == null){
            System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
            driver = new FirefoxDriver();
        }

        return driver;
    }

    public static void quitInstance(){
        driver.quit();
        driver = null;
    }
}
