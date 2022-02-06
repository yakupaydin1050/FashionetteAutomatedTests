@smoke
Feature: Apply a invalid Voucher

  @Voucher
  Scenario: Apply a invalid Voucher
    Given the user is on the home page
    Then verify that homepage is accessible and full loaded
    And the user should be able to select a product
    And the user selects product details
    And the user adds a product to the cart
    And the user visits the cart
    Then verify that current url contains "cart"
    Then verify that selected product appeared in the user cart
    And the user clicks "Voucher" link
    And the user applies "yakupaydin" voucher to the coupon field
    And the user clicks "redeem" button
    Then verify that the user should be able to see invalid voucher message
      | Your voucher "yakupaydin" is not valid |
    Then verify that "subtotal" is greater than TOTAL amount


