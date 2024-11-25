package com;

import com.shop.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() {
        logger.info("Starting the application setup...");
        app.init();
        logger.info("Application setup completed.");
    }

    @AfterSuite
    public void tearDown() {
        logger.info("Stopping the application...");
        app.stop();
        logger.info("Application stopped.");
    }
}
