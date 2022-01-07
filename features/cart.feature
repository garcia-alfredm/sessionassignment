Feature: Cart Page
  Background: Logged In and Shopping Cart Link Clicked
    Given a user is on the login page
    When a user inputs valid credentials
    Then a user is redirected to the inventory page
    Given a user is on the inventory page
    When a user clicks on the shopping cart icon
    Then the user is redirected to the cart page
  Scenario: Clicking checkout out redirects to checkout step 1 page
    Given a user is on the shopping cart page
    When the checkout button is clicked
    Then user is redirected to step one page