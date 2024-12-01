package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.TestStringConstants.*;

public class InputFormSubmitPage extends BasePage {
    public InputFormSubmitPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'loginform')]//button[@type='submit' ]")
    private WebElement submitButton;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@id='inputEmail4']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='inputPassword4']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='company']")
    private WebElement companyField;

    @FindBy(xpath = "//input[@id='websitename']")
    private WebElement websiteField;

    @FindBy(xpath = "//select[@name='country']")
    private WebElement countryDropdown;

    @FindBy(xpath = "//input[@id='inputCity']")
    private WebElement cityField;

    @FindBy(xpath = "//input[@id='inputAddress1']")
    private WebElement addressField1;

    @FindBy(xpath = "//input[@id='inputAddress2']")
    private WebElement addressField2;

    @FindBy(xpath = "//input[@id='inputState']")
    private WebElement stateField;

    @FindBy(xpath = "//input[@id='inputZip']")
    private WebElement zipcodeField;

    @FindBy(xpath = "//p[contains(@class, 'success-msg hidden')]")
    private WebElement successMessage;

    public void clickOnSubmitButton() {
        clickOn(submitButton);
    }

    private boolean isFieldValid(WebElement field) {
        return (Boolean) jsExecutor.executeScript("return arguments[0].checkValidity();", field);

    }

    private String getFieldValidationMessage(WebElement field) {
        String validationMessage = "";
        boolean isFieldValid = isFieldValid(field);
        if (!isFieldValid) {
            validationMessage = (String)  jsExecutor.executeScript("return arguments[0].validationMessage;", field);
            log().info("Message: " + validationMessage);
        } else {
            log().info("No validation message found");
        }
        return validationMessage;
    }

    public String getNameFieldValidationMessage() {
        waiter.waitForElementToBeClickable(nameField, 200);
        return getFieldValidationMessage(nameField);
    }

    public void fillInNameField(String name) {
        nameField.sendKeys(name);
    }

    public void fillInEmailField(String email) {
        emailField.sendKeys(email);
    }

    public void fillInPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void fillInCompanyField(String company) {
        companyField.sendKeys(company);
    }

    public void fillInWebsitelField(String website) {
        websiteField.sendKeys(website);
    }

    public void selectFromCountryDropdownValue(String country) {
        selectFromDropdownByValue(countryDropdown, country);
    }

    public void fillInCityField(String city) {
        cityField.sendKeys(city);
    }


    public void fillInFirstAddressField(String address1) {
        addressField1.sendKeys(address1);
    }

    public void fillInSecondAddressField(String address2) {
        addressField2.sendKeys(address2);
    }

    public void fillInStateField(String state) {
        stateField.sendKeys(state);
    }

    public void fillInZipcodeField(String zipcode) {
        zipcodeField.sendKeys(zipcode);
    }

    public void fillAllNecessaryFields() {
        fillInNameField(NAME.getValue());
        fillInEmailField(EMAIL.getValue());
        fillInPasswordField(PASSWORD.getValue());
        fillInCompanyField(COMPANY.getValue());
        fillInWebsitelField(WEBSITE.getValue());
        selectFromCountryDropdownValue(COUNTRY_VALUE.getValue());
        fillInCityField(CITY.getValue());
        fillInFirstAddressField(ADDRESS1.getValue());
        fillInSecondAddressField(ADDRESS2.getValue());
        fillInStateField(STATE.getValue());
        fillInZipcodeField(ZIPCODE.getValue());
    }


    public String getSuccessMessageText() {
        return getTextOf(successMessage);
    }
}
