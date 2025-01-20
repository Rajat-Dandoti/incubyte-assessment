@signin
Feature: Sign In

  Scenario Outline: Valid Sign In

    Given User navigate-to "https://magento.softwaretestingboard.com/"
    And User clicks on "LP_SignIn_link"

    And User enters value: "<email>" in field: "SignIn_EmailAddress_field"
    And User enters value: "<password>" in field: "SignIn_Pwd_field"

    When User clicks on "SignIn_button"
    Then Verify sign in is successful

    Examples:
      |email              | password     |
      |testrrd1@hmail.com | TestTwo@1234 |