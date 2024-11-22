import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public abstract class BaseTest {
    protected WebDriver driver;

    @Parameters({"browser", "version", "platform"})
    @BeforeMethod
    public void setUp(String browser, String version, String platform) {
        DriverManager.setDriverParameters(browser, version, platform);
        driver = DriverManager.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
        DriverManager.cleanDriverConfig();
    }
}
