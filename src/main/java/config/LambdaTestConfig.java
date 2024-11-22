package config;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static config.PropertiesConfig.PROPERTIES_CONFIG;

public class LambdaTestConfig {

    private static final ConcurrentHashMap<String, Object> ltOptions = new ConcurrentHashMap<>(
            Map.of(
                    "username", PROPERTIES_CONFIG.username(),
                    "accessKey", PROPERTIES_CONFIG.accessKey(),
                    "project", PROPERTIES_CONFIG.projectName(),
                    "name", PROPERTIES_CONFIG.testName(),
                    "selenium_version", "4.26.0",
                    "w3c", true,
                    "visual", true,
                    "video", true
            )
    );

    public static ConcurrentHashMap<String, Object> getOptions() {
        return ltOptions;
    }

    public static URL getGridUrl() {
        String formattedUrl = String.format(
                PROPERTIES_CONFIG.gridUrl(),
                PROPERTIES_CONFIG.username(),
                PROPERTIES_CONFIG.accessKey()
        );
        URL url;
        try {
            url = URI.create(formattedUrl).toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid URL", e);
        }
        return url;
    }
}
