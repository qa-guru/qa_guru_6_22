package io.github.qaguru.owner.config;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverProvider {

    private WebDriverConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }

    public WebDriver createDriver() {
        WebDriver driver = getDriver();
        driver.get(config.getBaseUrl());
        return driver;
    }

    private WebDriver getDriver() {
        final Browser browser = config.getBrowser();
        switch (browser) {
            case FIREFOX: {
                return new FirefoxDriver();
            }
            case CHROME: {
                return new ChromeDriver();
            }
        }
        throw new RuntimeException("No such browser: " + browser);
    }


}
