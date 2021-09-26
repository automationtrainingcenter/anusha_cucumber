@branch
Feature: Branch Creation

  Background:
    Given user is in home page

  @create
  Scenario: Verify branch creation using valid data
    Given user did login with valid credentials username as "Admin" and password as "Admin"
    When user clicks branches button
    And user clicks new branch button
    And user fills branch name as "SanathNagar"
    And user fills address1 as "Sanath nagar"
    And user fills zipcode as "43322"
    And user selects country as "india"
    And user selects state as "Delhi"
    And user selects city as "Delhi"
    And user clicks on submit button
    Then user can see an alert with branch with some id created "sucessfully"

  @create @dd
  Scenario Outline: Verify branch creation using valid data
    Given user did login with valid credentials
      | Admin | Admin |
    When user clicks branches button
    And user clicks new branch button
    And user fills branch name as "<branchName>"
    And user fills address1 as "<address1>"
    And user fills zipcode as "<zipcode>"
    And user selects country as "<country>"
    And user selects state as "<state>"
    And user selects city as "<city>"
    And user clicks on submit button
    Then user can see an alert with branch with some id created "<message>"
    Examples:
      | branchName  | address1 | zipcode | country | state   | city               | message     |
      | branchOne   | b1add    | 12334   | India   | Kerala  | thiruvananthapuram | sucessfully |
      | branchTwo   | b2add    | 89765   | UK      | England | London             | sucessfully |
      | branchThree | b3add    | 98765   | usa     | NewYork | watertown          | sucessfully |