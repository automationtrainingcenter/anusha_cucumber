@role
Feature: Role Creation

  Background:
    Given user is in home page
    And user did login with valid credentials
      | Admin | Admin |
    And user clicks roles button
    And user clicks new role button

  @reset @dd
  Scenario: role creation reset
    When user clicks reset button by filling role name and role type
      | roleName        | roleType |
      | admin           | E        |
      | banker          | E        |
      | personalAccount | C        |

  @create
  Scenario: role creation with valid data
    When user clicks submit button by filling role name and role type
      | roleName | roleType |
      | admin    | E        |

  @cancel @dd
  Scenario: role creation cancel by filling the form
    When user clicks cancel button by filling role name and role type
      | admin           | E |
      | banker          | E |
      | personalAccount | C |

