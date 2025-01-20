package org.incubyte.page_objects;

import org.incubyte.driver_base.DriverBase;
import org.incubyte.utils.CommonUtil;
import org.testng.Assert;

import static org.incubyte.utils.CommonUtil.byLocator;

public class SignUpPage extends DriverBase {

    public static void verifySignUp() {
        String expectedErrorMsg = "Thank you for registering with Main Website Store.";
        CommonUtil.waitForVisibility("Welcome_dropdown_text");
        String actualSuccessMsg = driver.findElement(byLocator("CreateAccount_SuccessMsg")).getText();
        Assert.assertEquals(actualSuccessMsg, expectedErrorMsg);
    }

    public static void verifyInvalidEmailId() {
        String expectedErrorMsg = "Please enter a valid email address (Ex: johndoe@domain.com).";
        String actualSuccessMsg = driver.findElement(byLocator("EmailAddress_fieldError")).getText();
        Assert.assertEquals(actualSuccessMsg, expectedErrorMsg);
    }

    public static void verifyIncorrectPwdFormat(String password) {
        String errorMsgLength = "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.";
        String errorMsgClasses = "Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.";

        assert password != null;
        boolean isLengthValid = password.length() >= 8;

        // Validate the password character classes
        boolean hasLowerCase = password.chars().anyMatch(Character::isLowerCase);
        boolean hasUpperCase = password.chars().anyMatch(Character::isUpperCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        boolean hasSpecialChar = password.chars().anyMatch(ch -> !Character.isLetterOrDigit(ch));
        int classesCount = 0;
        if (hasLowerCase) classesCount++;
        if (hasUpperCase) classesCount++;
        if (hasDigit) classesCount++;
        if (hasSpecialChar) classesCount++;

        // Check for errors and validate error messages
        if (!isLengthValid) {
            String actualErrorMsg = driver.findElement(byLocator("Password_fieldError")).getText();
            Assert.assertEquals(actualErrorMsg, errorMsgLength);
        } else if (classesCount < 3) {
            String actualErrorMsg = driver.findElement(byLocator("Password_fieldError")).getText();
            Assert.assertEquals(actualErrorMsg, errorMsgClasses);
        } else {
            Assert.fail("Password meets the criteria but an error message is displayed.");
        }
    }

    public static void verifyPwdMismatch() {
        String errorMsg = "Please enter the same value again.";
        Assert.assertEquals(driver.findElement(byLocator("ConfirmPwd_fieldError")).getText(), errorMsg);
    }

    public static void verifyErrorForAllFields() {
        String errorMsg = "This is a required field.";

        Assert.assertEquals(driver.findElement(byLocator("FirstName_fieldError")).getText(), errorMsg);
        Assert.assertEquals(driver.findElement(byLocator("LastName_fieldError")).getText(), errorMsg);
        Assert.assertEquals(driver.findElement(byLocator("EmailAddress_fieldError")).getText(), errorMsg);
        Assert.assertEquals(driver.findElement(byLocator("Password_fieldError")).getText(), errorMsg);
        Assert.assertEquals(driver.findElement(byLocator("ConfirmPwd_fieldError")).getText(), errorMsg);
    }

    public static void verifyDuplicateUser() {
        String expectedErrorMsg = "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
        String actualErrorMsg = CommonUtil.waitForVisibility("DuplicateUser_ErrorMsg").getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }
}
