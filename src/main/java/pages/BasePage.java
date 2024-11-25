package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utils.Waiter;

public abstract class BasePage {

    protected WebDriver driver;
    protected Waiter waiter;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new Waiter(driver);
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected void clickOn(WebElement element) {
        waiter.waitForElementToBeClickable(element, 300)
                .click();
    }

    protected String getTextOf(WebElement element) {
        return waiter.waitForElementToBeVisible(element, 300)
                .getText();
    }

    protected void enterTextIntoInput(WebElement input, String text) {
        input.sendKeys(text);
    }
}
