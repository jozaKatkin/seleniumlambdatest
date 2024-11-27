import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragAndDropSlidersPage;
import pages.SeleniumPlaygroundPage;

public class DragAndDropSlidersTest extends BaseTest {

    @Test
    public void testDragAndDropSliders() {
        int targetSliderValue = 95;
        SeleniumPlaygroundPage seleniumPlaygroundPage = new SeleniumPlaygroundPage(driver);
        seleniumPlaygroundPage.clickOnAllowAllButtonIfExists();

        seleniumPlaygroundPage.clickDragAndDropSlidersLink();
        DragAndDropSlidersPage dragAndDropSlidersPage = new DragAndDropSlidersPage(driver);
        dragAndDropSlidersPage.clickOnAllowAllButtonIfExists();

        dragAndDropSlidersPage.moveSliderTo95();
        Assert.assertEquals(
                dragAndDropSlidersPage.getCurrentSliderValue(),
                targetSliderValue,
                "Target value is not 95"
        );
    }
}
