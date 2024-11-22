package pages;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    public WebDriverWait waiter;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.waiter = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    }

}
