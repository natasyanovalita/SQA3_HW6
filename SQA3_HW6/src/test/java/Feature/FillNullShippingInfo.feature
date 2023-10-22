Feature: FillNullShippingInfo
  Scenario: Fail to continue after filling empty shipping info
    Given I open edge browser
    And Open saucedemo website on edge browser
    And Located on saucedemo first page
    When I input my username
    And I input my password
    And I am directed to saucedemo homepage
    And I add a product to the cart
    And The selected product is added to The Cart
    When I click checkout button
    And Located on the shipping form
    And I input empty first name
    And I input empty last name
    And I input empty ZIP
    Then I click continue button and get an error message "Error: First Name is required"