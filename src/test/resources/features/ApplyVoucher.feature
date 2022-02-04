@scenario03
Feature: The user should be able to apply the voucher properly

  Background:
    Given the user is on the home page

  Scenario: Apply a voucher
    Given the user select a product
    Given the user adds a product to the cart without login
    Then the user should be able to visit the cart
    Then the user applies the valid voucher to the cart
    And verify that the valid voucher is applied properly
