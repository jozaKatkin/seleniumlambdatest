package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class SeleniumPlaygroundPage extends BasePage {
    public SeleniumPlaygroundPage(RemoteWebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(@href, 'simple-form-demo')]")
    private WebElement simpleFormDemoLinkElement;
}
