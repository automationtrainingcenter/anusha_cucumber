@login
Feature: Admin Login Feature
  Description: As a Admin I want to do login so that I can perform admin tasks

  Scenario: Login with valid credentials
    Given user is in home page
    When user enters valid username
    And user enters valid password
    And user clicks on login button
    Then user can see logout link
    And user can see welcome to Admin message