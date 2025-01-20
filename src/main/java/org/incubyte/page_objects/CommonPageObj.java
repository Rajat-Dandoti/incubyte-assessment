package org.incubyte.page_objects;

import org.incubyte.driver_base.DriverBase;
import org.incubyte.utils.CommonUtil;
import org.openqa.selenium.WebElement;

public class CommonPageObj extends DriverBase {

    public static void getURL(String url) {
        driver.get(url);
    }

    public static void enterValueInField(String str, String loc) {
        WebElement element = CommonUtil.waitForVisibility(loc);
        element.sendKeys(str);
    }

    public static void clickOn(String loc) {
        WebElement element = CommonUtil.waitForElementToBeClickable(loc);
        element.click();
    }

    public static void clearField(String loc) {
        WebElement element = CommonUtil.waitForVisibility(loc);
        element.clear();
    }
}