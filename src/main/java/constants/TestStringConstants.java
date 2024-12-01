package constants;

public enum TestStringConstants {
    CORRECT_SIMPLE_FORM_DEMO_URL("simple-form-demo"),
    WELCOME_TO_LAMBDA_TEST_STRING("Welcome to LambdaTest"),

    NAME("John"),
    EMAIL("john@example.com"),
    PASSWORD("johnpassword123"),
    COMPANY("No name company"),
    WEBSITE("website.com"),
    COUNTRY_VALUE("US"),
    CITY("Washington"),
    ADDRESS1("Something street 54/8/4"),
    ADDRESS2("Something 2 street 78/1"),
    STATE("Washington DC"),
    ZIPCODE("569658"),

    PLEASE_FILL_OUT_THIS_FIELD_STRING("Please fill out this field"),
    THANKS_FOR_CONTACTING_US_STRING("Thanks for contacting us, we will get back to you shortly");

    TestStringConstants(String value) {
        this.value = value;
    }

    private final String value;

    public String getValue() {
        return value;
    }
}
