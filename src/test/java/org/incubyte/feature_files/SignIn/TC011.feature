@signin
Feature: Sign In

  Background: Ensure user is registered
    Given User navigate-to "https://magento.softwaretestingboard.com/"
    And User clicks on "LP_CreateAccount_link"

    And User enters value: "Test" in field: "FirstName_field"
    And User enters value: "One" in field: "LastName_field"

    And User enters unique email address in field "EmailAddress_field"
    And User enters value: "TestMag@1234" in field: "Password_field"
    And User enters value: "TestMag@1234" in field: "ConfirmPassword_field"

    When User clicks on "CreateAccount_button"
    Then Verify sign up is successful
    And User clicks on "Welcome_dropdown_button"
    And User clicks on "SignOut_button"

  Scenario: Sign In With Newly Registered User

    Given User navigate-to "https://magento.softwaretestingboard.com/"
    And User clicks on "LP_SignIn_link"

    And User sign in with newly registered email address

    When User clicks on "SignIn_button"
    Then Verify sign in is successful