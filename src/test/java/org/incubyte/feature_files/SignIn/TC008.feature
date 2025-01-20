@signin
Feature: Sign In

  Scenario: Invalid Sign In - Wrong Password

    Given User navigate-to "https://magento.softwaretestingboard.com/"
    And User clicks on "LP_SignIn_link"

    And User enters value: "testrrd1@hmail.com" in field: "SignIn_EmailAddress_field"
    And User enters value: "TestMag@1234" in field: "SignIn_Pwd_field"

    When User clicks on "SignIn_button"

    Then Verify sign in is unsuccessful due to wrong password or unregistered user