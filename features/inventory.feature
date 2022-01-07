Feature: Inventory Page
  Background: A user successfully logged in and is on the inventory page
    Given a user is on the login page
    When a user inputs valid credentials
    Then a user is redirected to the inventory page
  Scenario: Clicking add to cart increases shopping cart
    Given a user is on the inventory page
    When a user clicks the add-to-cart button on an item
    Then the shopping cart badge count increases by one
  Scenario: Clicking on shopping cart link will redirect user to cart page
    Given a user is on the inventory page
    When a user clicks on the shopping cart icon
    Then the user is redirected to the cart page