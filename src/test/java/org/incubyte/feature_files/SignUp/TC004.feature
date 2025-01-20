@signup
Feature: Sign Up

  Scenario: Creating a new account (Invalid Sign up - Empty fields)

    Given User navigate-to "https://magento.softwaretestingboard.com/"
    And User clicks on "LP_CreateAccount_link"
    When User clicks on "CreateAccount_button"
    Then Verify that error is displayed for all fields