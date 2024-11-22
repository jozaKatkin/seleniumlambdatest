package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.DriverConfig;

import java.time.Duration;

public class DriverManager {

    private static final ThreadLocal<RemoteWebDriver> threadLocalDriver = new ThreadLocal<>();
    private static final ThreadLocal<DriverConfig> threadLocalConfig = new ThreadLocal<>();

    public static void setDriverParameters(String browser, String version, String platform) {
        DriverConfig driverConfig = new DriverConfig(version, platform, browser);
        threadLocalConfig.set(driverConfig);
    }

    public static void initializeDriver() {
        DriverConfig driverParameters = DriverConfig.requireDriverConfig(threadLocalConfig);
        String browser = driverParameters.browser();
        String version = driverParameters.version();
        String platform = driverParameters.platform();

        DriverFactory driverFactory;
        switch (browser.toLowerCase()) {
            case "chrome" -> driverFactory = new ChromeDriverFactory();
            case "firefox" -> driverFactory = new FirefoxDriverFactory();
            case "edge" -> driverFactory = new EdgeDriverFactory();
            case "explorer" -> driverFactory = new ExplorerDriverFactory();
            default -> throw new IllegalStateException("Unexpected value: " + browser);
        }
        RemoteWebDriver driver = driverFactory.createDriver(version, platform);
        setImplicitWait(driver, 5);
        threadLocalDriver.set(driver);
    }

    public static WebDriver getDriver() {
        if (threadLocalDriver.get() == null) {
            initializeDriver();
        }
        return threadLocalDriver.get();
    }

    public static void quitDriver() {
        if (threadLocalDriver.get() != null) {
            threadLocalDriver.get().quit();
            threadLocalDriver.remove();
        }
    }

    public static void cleanDriverConfig() {
        if (threadLocalConfig.get() != null) {
            threadLocalConfig.remove();
        }
    }

    private static void setImplicitWait(WebDriver driver, int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
}
