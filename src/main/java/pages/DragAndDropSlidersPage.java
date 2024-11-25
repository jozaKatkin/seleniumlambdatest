package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ILogger;

public class DragAndDropSlidersPage extends BasePage implements ILogger {
    public DragAndDropSlidersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='slider3']//input")
    private WebElement defaultValue15Slider;

    @FindBy(xpath = "//output[@id='rangeSuccess']")
    private WebElement valueBoxElement;

    public int getCurrentSliderValue() {
        return Integer.parseInt(getTextOf(valueBoxElement));
    }

    public void moveSliderToValue(int targetValue) {
        //ToDo
    }

    public void moveSliderTo95() {
        int targetValue = 45;
        moveSliderToValue(targetValue);
    }
}
