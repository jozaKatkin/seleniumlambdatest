package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources("classpath:config.properties")
public interface PropertiesConfig extends Config {

    PropertiesConfig PROPERTIES_CONFIG = ConfigFactory.create(PropertiesConfig.class);

    @Key("base.url")
    String baseUrl();

    @Key("grid.url")
    String gridUrl();

    @Key("username")
    String username();

    @Key("access.key")
    String accessKey();

    @Key("project.name")
    String projectName();

    @Key("test.name")
    String testName();
}
