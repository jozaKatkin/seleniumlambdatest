package pages;

import org.openqa.selenium.Keys;
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

        clickOn(defaultValue15Slider);

        int counter = 0;
        int currentSliderValue = getCurrentSliderValue();

        while (true) {
            if (currentSliderValue == targetValue) {
                log().info("Target value reached: " + targetValue);
                break;
            }

            if (currentSliderValue < targetValue) {
                defaultValue15Slider.sendKeys(Keys.ARROW_RIGHT);
            } else {
                defaultValue15Slider.sendKeys(Keys.ARROW_LEFT);
            }

            counter++;
            log().info("Counter: " + counter);
            currentSliderValue = getCurrentSliderValue();
        }
    }

    public void moveSliderTo95() {
        int targetValue = 95;
        moveSliderToValue(targetValue);
    }
}
