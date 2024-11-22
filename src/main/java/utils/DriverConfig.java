package utils;

import java.util.Objects;

public record DriverConfig(String browser, String version, String platform) {
    public DriverConfig(String browser, String version, String platform) {
        this.browser = Objects.requireNonNull(browser, "Browser must not be null");
        this.version = Objects.requireNonNull(version, "Version must not be null");
        this.platform = Objects.requireNonNull(platform, "Platform must not be null");
    }

    public static DriverConfig requireDriverConfig(ThreadLocal<DriverConfig> threadLocalConfig) {
        return Objects.requireNonNull(threadLocalConfig.get(), "Driver parameters are not set");
    }
}
