@smoke
Feature: Modify Personal Data Functionality

  Background:
    Given the user is on the home page
    Then verify that homepage is accessible and full loaded
    When the user should be able to navigate to login page
    Then verify that current url contains "login"
    Then the user should be able to see "WELCOME TO FASHIONETTE!" message
    When the user should be able to login with valid credentials
    Then verify that "welcome to your account." message is visible
    Then the user clicks "Personal data" menu
    When the user clicks "Edit"

  Scenario Outline: First Name may not be greater than 20 characters.
    Then verify that the name may not be greater than 20 characters. "<firstName>"
    Then verify that the name should consist of letters only "<firstNameWithoutletter>"
    Then verify that the "first_name" is required.
    And the user clicks "Save"
    Examples:
      | firstName | firstNameWithoutletter|
      |           |                       |
      |           |                       |

  Scenario Outline: Last Name may not be greater than 29 characters.
    Then verify that the "<last name>" may not be greater than 29 characters.
    Then verify that the "last_name" is required
    And the user clicks "Save"

    Examples:
      | lastName |
      |          |
      |          |

  Scenario Outline: Title may not be greater than 50 characters.
    Then verify that the "<title>" may not be greater than 50 characters.

    Examples:
      | title |
      |       |
      |       |

  Scenario Outline: Phone Number Modify.
    Then verify that the  phone numbber may not be greater than 50 characters "<phoneNumber>"
    Then verify that the phone number does not contain letters "<phoneNumberwithLetter>"
    Then verify that The "phone_number" field is required
    And the user clicks "Save"

    Examples:
      | phoneNumber |phoneNumberwithLetter|
      |             |                     |
      |             |                     |

