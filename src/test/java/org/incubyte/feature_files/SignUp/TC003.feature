@signup
Feature: Sign Up

  Scenario: Creating a new account (Invalid Sign Up - Incorrect Password Format)

    Given User navigate-to "https://magento.softwaretestingboard.com/"
    And User clicks on "LP_CreateAccount_link"

    And User enters value: "Test" in field: "FirstName_field"
    And User enters value: "One" in field: "LastName_field"

    And User enters value: "testOne@hmail.com" in field: "EmailAddress_field"
    When User enters value: "TEST@TEST" in field: "Password_field"
    Then Verify that password format is not as expected

    And User clear the field "Password_field"
    And User enters value: "Test" in field: "Password_field"
    And Verify that password format is not as expected