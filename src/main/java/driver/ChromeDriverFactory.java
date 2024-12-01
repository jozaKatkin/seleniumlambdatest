package driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import config.LambdaTestConfig;

public class ChromeDriverFactory implements DriverFactory {

    public RemoteWebDriver createDriver(String version, String platform) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--no-sandbox");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-infobars");
        options.addArguments("--no-first-run");
        options.setBrowserVersion(version);
        options.setPlatformName(platform);
        options.setCapability("LT:Options", LambdaTestConfig.getOptions());
        return new RemoteWebDriver(LambdaTestConfig.getGridUrl(), options);
    }


}
