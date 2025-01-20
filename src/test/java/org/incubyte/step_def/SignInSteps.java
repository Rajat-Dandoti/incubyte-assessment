package org.incubyte.step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.incubyte.driver_base.DriverBase;
import org.incubyte.page_objects.CommonPageObj;
import org.incubyte.page_objects.SignInPage;
import org.incubyte.utils.ScenarioContext;

import java.util.logging.Logger;

public class SignInSteps extends DriverBase {
    private static final Logger logger = Logger.getLogger(SignInSteps.class.getName());

    @And("User sign in with newly registered email address")
    public static void userEnterNewlyRegisteredEmail() {
        String email = ScenarioContext.getContext("unique_email").toString();
        logger.info("Signing in with email: " + email);
        CommonPageObj.enterValueInField(email, "SignIn_EmailAddress_field");
        CommonPageObj.enterValueInField("TestMag@1234", "SignIn_Pwd_field");
    }

    @Then("Verify sign in is successful")
    public static void validateSignIn() {
        logger.info("Verifying successful sign in");
        SignInPage.verifyValidSignIn();
    }

    @Then("Verify sign in is unsuccessful due to wrong password or unregistered user")
    public void validateSignInWithWrongPwd() {
        logger.info("Verifying unsuccessful sign in due to wrong password or unregistered user");
        SignInPage.verifyInvalidOrUnregisteredUser();
    }

    @Then("Verify sign in is unsuccessful due to empty email and password field")
    public void validateSignInWithEmptyFields() {
        logger.info("Verifying unsuccessful sign in due to empty email and password fields");
        SignInPage.verifyErrorForEmptyFields();
    }
}