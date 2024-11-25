package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SimpleFormDemoPage extends BasePage {
    public SimpleFormDemoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='user-message']")
    private WebElement enterMessageInput;

    @FindBy(xpath = "//button[@id='showInput']")
    private WebElement getCheckedValueButton;

    @FindBy(xpath = "//p[@id='message']")
    private WebElement appearedMessageText;

    public void enterMessageIntoField(String message) {
        enterTextIntoInput(enterMessageInput, message);
    }

    public void clickOnGetCheckedValueButton() {
        clickOn(getCheckedValueButton);
    }

    public String getAppearedMessageText() {
        return getTextOf(appearedMessageText);
    }
}
