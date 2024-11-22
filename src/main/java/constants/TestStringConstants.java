package constants;

public enum TestStringConstants {
    CORRECT_SIMPLE_FORM_DEMO_URL("simple-form-demo"),
    ;

    TestStringConstants(String value) {
        this.value = value;
    }

    private final String value;

    public String getValue() {
        return value;
    }
}
