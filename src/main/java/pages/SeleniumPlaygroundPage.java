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

    @FindBy(xpath = "//a[contains(@href, 'drag-drop-range')]")
    private WebElement dragAndDropSlidersLinkElement;

    @FindBy(xpath = "//a[contains(@href, 'input-form-demo')]")
    private WebElement inputFormDemoLinkElement;

    public void clickSimpleFormDemoLink() {
        clickOn(simpleFormDemoLinkElement);
    }

    public void clickDragAndDropSlidersLink() {
        clickOn(dragAndDropSlidersLinkElement);
    }

    public void clickInputFormDemoLink() {
        clickOn(inputFormDemoLinkElement);
    }
}
