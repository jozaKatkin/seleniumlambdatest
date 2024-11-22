package driver;


import org.openqa.selenium.remote.RemoteWebDriver;

public interface DriverFactory {
    RemoteWebDriver createDriver(String version, String platform);
}
