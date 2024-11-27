package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.ILogger;
import utils.Waiter;

import java.util.HashMap;
import java.util.Map;

public abstract class BasePage implements ILogger {

    @FindBy(xpath = "//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")
    private WebElement allowAllButton;

    protected WebDriver driver;
    protected Waiter waiter;
    protected Actions actions;
    protected JavascriptExecutor jsExecutor;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new Waiter(driver);
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
        this.jsExecutor = (JavascriptExecutor) driver;
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

    public void clickOnAllowAllButtonIfExists() {
        try {
            waiter.waitForElementToBeVisible(allowAllButton, 1000);
            if (allowAllButton.isDisplayed()) {
                waiter.waitForElementToBeClickable(allowAllButton, 100)
                        .click();
                log().info("CLicked Allow All button");
            }
        } catch (NoSuchElementException | TimeoutException e) {
            log().info("Cookie dialog is not appeared. Continuing test executions");
        }
    }

    protected void selectFromDropdownByValue(WebElement dropdown, String value) {
        new Select(dropdown).selectByValue(value);
    }
}
