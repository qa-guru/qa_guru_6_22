package io.github.qaguru.owner.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:/tmp/local.properties",
        "classpath:testing.properties"
})
public interface FileSourceConfig extends Config {

    @Key("baseUrl")
    String baseUrl();

    @Key("username")
    String username();

    @Key("password")
    String password();

}
