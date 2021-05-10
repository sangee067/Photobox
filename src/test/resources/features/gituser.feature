@ui
Feature: Git User account creation
  Description: Verify the username is exists or not

  Scenario Outline: Verify the appropriate Error for Creating Account
    Given User is on the Home page
    When User clicks on the SignUp button
    Then User should be navigated to the create account page
    And User enters username "<Text>"
    Then User should see the "<Message>" validation in the Create Account page
    Examples:
      | Text       | Message                   |
      | photobox   | Username is not available |
      | sangee1988 | Success                   |