Feature: FillShippingInfo
  Scenario: Successful Filling Shipping Info
    Given I open my edge browser
    And Open saucedemo website on browser
    And Located on saucedemo login page
    When I input the given username
    And I input the given password
    And I go to saucedemo homepage
    And I add product to the cart
    And The product is added to The Cart
    When I click checkout
    And Located on shipping form
    And I input valid first name
    And I input valid last name
    And I input valid ZIP
    Then I click continue