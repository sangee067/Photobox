@api
Feature: Verify that Git User API endpoint displays user details correctly

  Scenario Outline: Test that User is able to get the User details successfully
    Given user sends "GET" request to see a specific user "<Name>" details
    Then user should see name property matches with user "<Name>"
    Examples:
      | Name       |
      | photobox   |
