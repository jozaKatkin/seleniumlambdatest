package driver;

import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import config.LambdaTestConfig;

public class ExplorerDriverFactory implements DriverFactory {

    public RemoteWebDriver createDriver(String version, String platform) {
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setBrowserVersion(version);
        options.setPlatformName(platform);
        options.setCapability("LT:Options", LambdaTestConfig.getOptions());
        return new RemoteWebDriver(LambdaTestConfig.getGridUrl(), options);
    }
}
