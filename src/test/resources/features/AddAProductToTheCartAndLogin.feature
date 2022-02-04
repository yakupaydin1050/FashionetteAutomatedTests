@scenario01
  Feature: User should be able to add a product and login with valid credentials.

    Background:


      Scenario: Add a product to the cart and login
        Given the user is on the home page
       Given the user select a product
      Given the user adds a product to the cart
        Then the user logins with valid credentials
        Then the user visits the cart after login

