Feature: Login Page
Scenario: Entering valid credentials will redirected user to the inventory page
    Given a user is on the login page
    When a user inputs valid credentials
    Then a user is redirected to the inventory page
Scenario: entering invalid credentials will display an error message
    Given a user is on the login page
    When a user inputs invalid credentials
    Then an error message will be displayed