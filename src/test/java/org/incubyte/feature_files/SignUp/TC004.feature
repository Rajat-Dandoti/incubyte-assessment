@signup
Feature: Sign Up

  Scenario: Creating a new account (Invalid Sign up - Password Mismatch)

    Given User navigate-to "https://magento.softwaretestingboard.com/"
    And User clicks on "LP_CreateAccount_link"
    And User enters value: "Test" in field: "FirstName_field"
    And User enters value: "One" in field: "LastName_field"

    And User enters value: "testabc" in field: "EmailAddress_field"
    And User enters value: "TestMag@1234" in field: "Password_field"
    And User enters value: "Test" in field: "ConfirmPassword_field"

    When User clicks on "CreateAccount_button"
    Then Verify that password is not matching