@scenario01
  Feature: The user should be able to add a product and login with valid credentials

    Background:
      Given the user is on the home page

      Scenario: Add a product to the cart and login
       Given the user select a product
      Given the user adds a product to the cart
        Then the user logins with valid credentials
        Then the user should be able to visit the cart

