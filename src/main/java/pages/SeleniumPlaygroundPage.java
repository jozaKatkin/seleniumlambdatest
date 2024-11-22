package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeleniumPlaygroundPage extends BasePage {
    public SeleniumPlaygroundPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(@href, 'simple-form-demo')]")
    private WebElement simpleFormDemoLinkElement;

    public void clickSimpleFormDemoLink() {
        clickOn(simpleFormDemoLinkElement);
    }
}
