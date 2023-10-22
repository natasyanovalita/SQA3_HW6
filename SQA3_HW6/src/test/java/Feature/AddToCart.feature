Feature: AddToCart
  Scenario: Successful Adding to Cart
    Given I open my browser
    And Open saucedemo website
    And Located on saucedemo website
    When I input the right username
    And I input the right password
    And I go to the homepage
    And I add product to cart
    Then The product is added to Cart