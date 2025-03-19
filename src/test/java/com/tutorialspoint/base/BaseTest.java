package com.tutorialspoint.base;


import com.codeborne.selenide.Configuration;
import com.tutorialspoint.config.ConfigManager;
import com.tutorialspoint.config.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public abstract class BaseTest {

    protected TestConfig testConfig;

    @BeforeMethod
    public void setUp() {

        // 1. Load the JSON config data
        testConfig = ConfigManager.loadJsonConfig();

        // 2. Initialize the WebDriver
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.timeout = 60000;
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";

        // 3. Set the base URL for Selenide
        Configuration.baseUrl = testConfig.getBaseUrl();
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}

