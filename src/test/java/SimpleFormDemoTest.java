import constants.TestStringConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SeleniumPlaygroundPage;
import pages.SimpleFormDemoPage;

import static constants.TestStringConstants.CORRECT_SIMPLE_FORM_DEMO_URL;

public class SimpleFormDemoTest extends BaseTest {


    @Test
    public void simpleFormDemoTest() {
        SeleniumPlaygroundPage seleniumPlaygroundPage = new SeleniumPlaygroundPage(driver);
        seleniumPlaygroundPage.clickSimpleFormDemoLink();

        SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage(driver);
        Assert.assertTrue(
                simpleFormDemoPage.getCurrentUrl().contains(CORRECT_SIMPLE_FORM_DEMO_URL.getValue()),
                String.format("URL does not contain %s", CORRECT_SIMPLE_FORM_DEMO_URL.getValue())
        );
    }
}
