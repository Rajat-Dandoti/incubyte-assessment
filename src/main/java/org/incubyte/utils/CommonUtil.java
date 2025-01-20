package org.incubyte.utils;

import org.incubyte.driver_base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil extends DriverBase {

    public static By byLocator(String loc){
        return By.xpath(ConfigManager.getLocator(loc));
    }

    public static WebElement waitForVisibility(String loc) {
        By locator = byLocator(loc);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeClickable(String loc) {
        By locator = byLocator(loc);
        return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
    }

    public static String generateUniqueEmail() {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return "TestMag" + timestamp + "@hmail.com";
    }
}
