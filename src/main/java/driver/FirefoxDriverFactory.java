package driver;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import config.LambdaTestConfig;

public class FirefoxDriverFactory implements DriverFactory{

    public RemoteWebDriver createDriver(String version, String platform) {
        FirefoxOptions options = new FirefoxOptions();
        options.setBrowserVersion(version);
        options.setPlatformName(platform);
        options.setCapability("LT:Options", LambdaTestConfig.getOptions());
        return new RemoteWebDriver(LambdaTestConfig.getGridUrl(), options);
    }
}
