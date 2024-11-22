package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
    private final WebDriver driver;

    public Waiter(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementToBeVisible(WebElement element, int timeInMillis) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeInMillis));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeClickable(WebElement element, int timeInMillis) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeInMillis));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
