package org.incubyte.page_objects;

import org.incubyte.driver_base.DriverBase;
import org.incubyte.utils.CommonUtil;
import org.testng.Assert;

import static org.incubyte.utils.CommonUtil.byLocator;

public class SignInPage extends DriverBase {

    public static void verifyValidSignIn() {
        CommonUtil.waitForVisibility("Welcome_dropdown_text");
    }

    public static void verifyInvalidOrUnregisteredUser() {
        String expectedErrorMsg = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        String actualErrorMsg = CommonUtil.waitForVisibility("SignIn_ErrorMsg").getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }

    public static void verifyErrorForEmptyFields() {
        String errorMsg = "This is a required field.";

        Assert.assertEquals(driver.findElement(byLocator("SignIn_Email_ErrorMsg")).getText(), errorMsg);
        Assert.assertEquals(driver.findElement(byLocator("SignIn_Pwd_ErrorMsg")).getText(), errorMsg);
    }
}
