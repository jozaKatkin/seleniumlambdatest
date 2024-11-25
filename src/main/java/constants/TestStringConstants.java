package constants;

public enum TestStringConstants {
    CORRECT_SIMPLE_FORM_DEMO_URL("simple-form-demo"),
    WELCOME_TO_LAMBDA_TEST_STRING("Welcome to LambdaTest"),

    ;

    TestStringConstants(String value) {
        this.value = value;
    }

    private final String value;

    public String getValue() {
        return value;
    }
}
