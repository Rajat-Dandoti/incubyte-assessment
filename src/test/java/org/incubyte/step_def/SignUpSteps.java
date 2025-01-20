package org.incubyte.step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.incubyte.driver_base.DriverBase;
import org.incubyte.page_objects.CommonPageObj;
import org.incubyte.page_objects.SignUpPage;
import org.incubyte.utils.CommonUtil;
import org.incubyte.utils.ScenarioContext;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class SignUpSteps extends DriverBase {
    private static final Logger logger = Logger.getLogger(SignUpSteps.class.getName());

    @And("User enters unique email address in field {string}")
    public static void userEntersUniqueEmailID(String loc) {
        String str = CommonUtil.generateUniqueEmail();
        logger.info("Entering unique email: " + str);
        logCreatedUser(str);
        CommonPageObj.enterValueInField(str, loc);
        ScenarioContext.setContext("unique_email", str);
    }

    @And("User enters value: {string} in field: {string}")
    public static void userEntersValue(String str, String loc) {
        logger.info("Entering value: " + str + " in field: " + loc);
        CommonPageObj.enterValueInField(str, loc);
        if (loc.equals("Password_field")) {
            ScenarioContext.setContext("password", str);
        }
    }

    @Then("Verify sign up is successful")
    public static void validateSignUp() {
        logger.info("Verifying successful sign up");
        SignUpPage.verifySignUp();
    }

    @Then("Verify that password format is not as expected")
    public static void validatePwdFormat() {
        logger.info("Verifying password format");
        String password = ScenarioContext.getContext("password").toString();
        SignUpPage.verifyIncorrectPwdFormat(password);
    }

    @Then("Verify that email id is invalid")
    public static void validateEmailId() {
        logger.info("Verifying invalid email ID");
        SignUpPage.verifyInvalidEmailId();
    }

    @Then("Verify that error is displayed for all fields")
    public static void validateThatErrorIsDisplayedForAllFields() {
        logger.info("Verifying error for all fields");
        SignUpPage.verifyErrorForAllFields();
    }

    @Then("Verify that an error message is displayed for registered user")
    public static void validateDuplicateUser() {
        logger.info("Verifying error message for duplicate user");
        SignUpPage.verifyDuplicateUser();
    }

    private static void logCreatedUser(String email) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("created_users.log", true))) {
            writer.write(email);
            writer.newLine();
        } catch (IOException e) {
            logger.severe("Error logging created user: " + e.getMessage());
        }
    }
}