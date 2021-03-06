@smoke
Feature: The user should be able to modify user information

  Background:
    Given the user is on the home page
    Then verify that homepage is accessible and full loaded
    When the user should be able to navigate to login page
    Then verify that current url contains "login"
    Then the user should be able to see "WELCOME TO FASHIONETTE!" message

    @scenario02
    Scenario: Modify user information
      When the user should be able to login with valid credentials
      Then verify that "welcome to your account." message is visible
      Then the user clicks "Personal data" menu
      Then the user clicks "Edit"
      Then the user should be able to modify the name and the surname of the user
      And the user clicks "Save"
      Then verify that name and surname have been correctly saved
