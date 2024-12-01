import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InputFormSubmitPage;
import pages.SeleniumPlaygroundPage;

import static constants.TestStringConstants.*;

public class InputFormSubmitTest extends BaseTest {

    @Test
    public void inputFormSubmitTest() {
        SeleniumPlaygroundPage seleniumPlaygroundPage = new SeleniumPlaygroundPage(driver);
        seleniumPlaygroundPage.clickOnAllowAllButtonIfExists();

        seleniumPlaygroundPage.clickInputFormDemoLink();
        InputFormSubmitPage inputFormSubmitPage = new InputFormSubmitPage(driver);
        inputFormSubmitPage.clickOnAllowAllButtonIfExists();

        inputFormSubmitPage.clickOnSubmitButton();
        inputFormSubmitPage.clickOnAllowAllButtonIfExists();

        String realMessage = inputFormSubmitPage.getNameFieldValidationMessage();
        Assert.assertTrue(
                realMessage.contains(PLEASE_FILL_OUT_THIS_FIELD_STRING.getValue()),
                "Message is wrong"
        );

        inputFormSubmitPage.fillAllNecessaryFields();
        inputFormSubmitPage.clickOnSubmitButton();

        Assert.assertTrue(
                inputFormSubmitPage.getSuccessMessageText().contains(THANKS_FOR_CONTACTING_US_STRING.getValue()),
                "Message is wrong"
        );
    }
}
