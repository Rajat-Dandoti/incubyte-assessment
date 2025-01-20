package org.incubyte.driver_base;

import org.incubyte.utils.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class DriverBase {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    private static final Logger logger = Logger.getLogger(DriverBase.class.getName());
    private static final int WEB_DRIVER_WAIT = Integer.parseInt(ConfigManager.getProperty("web_driver_wait"));

    public static void initializeDriver() {
        String browser = ConfigManager.getProperty("browser");
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(WEB_DRIVER_WAIT));
        logger.info("Initialized driver for browser: " + browser);
    }

    public static void tearDownDriver() {
        if (driver != null) {
            driver.quit();
            logger.info("Driver quit successfully");
        }
    }
}
