@signin
Feature: Sign In

  Scenario: Invalid Sign In - Empty Fields

    Given User navigate-to "https://magento.softwaretestingboard.com/"
    And User clicks on "LP_SignIn_link"
    When User clicks on "SignIn_button"

    Then Verify sign in is unsuccessful due to empty email and password field