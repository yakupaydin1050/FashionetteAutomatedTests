@smoke
Feature: The user should be able to add a product and login with valid credentials and apply a voucher

  Background:
    Given the user is on the home page
    Then verify that homepage is accessible and full loaded
    And the user should be able to select a product
    And the user selects product details
    And the user adds a product to the cart


  @scenario01
  Scenario: Add a product to the cart and login
    When the user should be able to navigate to login page
    Then verify that current url contains "login"
    Then the user should be able to see "WELCOME TO FASHIONETTE!" message
    When the user should be able to login with valid credentials
    Then verify that "welcome to your account." message is visible
    And the user visits the cart
    Then verify that current url contains "cart"
    Then verify that selected product appeared in the user cart

  @scenario03
  Scenario: Apply a voucher
    And the user visits the cart
    Then verify that current url contains "cart"
    Then verify that selected product appeared in the user cart
    And the user clicks "Voucher" link
    And the user applies "qachallenge" voucher to the coupon field
    And the user clicks "redeem" button
    Then verify that the valid voucher is applied properly
    Then verify that "subtotal" is greater than TOTAL amount





