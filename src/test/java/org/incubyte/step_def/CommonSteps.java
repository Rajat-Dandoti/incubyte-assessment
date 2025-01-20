package org.incubyte.step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.incubyte.driver_base.DriverBase;
import org.incubyte.page_objects.CommonPageObj;
import org.testng.Assert;

import java.time.Duration;
import java.util.logging.Logger;

public class CommonSteps extends DriverBase {
    private static final Logger logger = Logger.getLogger(CommonSteps.class.getName());

    @Given("User navigate-to {string}")
    public static void userNavigateTo(String url) {
        logger.info("Navigating to URL: " + url);
        CommonPageObj.getURL(url);
        Assert.assertEquals(driver.getTitle(), "Home Page");
    }

    @When("User clicks on {string}")
    public static void userClicksOn(String loc) {
        logger.info("Clicking on element: " + loc);
        CommonPageObj.clickOn(loc);
    }

    @And("User wait for {int} seconds")
    public static void waitForSeconds(int sec) throws InterruptedException {
        logger.info("Waiting for " + sec + " seconds");
        Thread.sleep(Duration.ofSeconds(sec));
    }

    @And("User clear the field {string}")
    public static void userClearField(String loc) {
        logger.info("Clearing field: " + loc);
        CommonPageObj.clearField(loc);
    }
}