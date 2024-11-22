package driver;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.LambdaTestConfig;

public class EdgeDriverFactory implements DriverFactory {

    public RemoteWebDriver createDriver(String version, String platform) {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.setBrowserVersion(version);
        options.setPlatformName(platform);
        options.setCapability("LT:Options", LambdaTestConfig.getOptions());
        return new RemoteWebDriver(LambdaTestConfig.getGridUrl(), options);
    }
}
