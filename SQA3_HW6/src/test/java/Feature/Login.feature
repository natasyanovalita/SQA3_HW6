Feature: Login
  Scenario: Successful login
    Given I open browser
    And Open website saucedemo
    And Located on saucedemo
    When I input valid username
    And I input valid password
    Then I go to homepage