package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SeleniumPlaygroundPage extends BasePage {
    public SeleniumPlaygroundPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")
    private List<WebElement> allowAllButtonList;

    @FindBy(xpath = "//a[contains(@href, 'simple-form-demo')]")
    private WebElement simpleFormDemoLinkElement;

    public void clickSimpleFormDemoLink() {
        clickOn(simpleFormDemoLinkElement);
    }

    public void clickOnAllowAllButtonIfExists() {
        if (!allowAllButtonList.isEmpty()) {
            clickOn(allowAllButtonList.getFirst());
        }
    }
}
