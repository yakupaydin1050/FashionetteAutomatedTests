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

  @Customer
  Scenario Outline: First Name may not be greater than 20 characters.
    Given the user fills first name field "<firstName>"
    Then verify that the first name may not be greater than twenty characters
    Examples:
      | firstName                                          |
      | Yakdwertghyjkuplopkjhytfrrewqasdcvfgtyhnjmkopuytre |

  @Customer
  Scenario Outline: The name should consist of letters
    Given the user fills first name field "<firstNameWithoutLetter>"
    Then verify that the name should consist of letters only
    Examples:
      | firstNameWithoutLetter |
      | 123456789Yakup         |

  @Customer
  Scenario Outline: The name must be
    Given the user fills first name field "<firstName>"
    And the user clicks "Save"
    Then verify that the first name is required.
    Examples:
      | firstName |
      |           |

  @Customer
  Scenario Outline: Last Name may not be greater than 29 characters.
    Given the user fills last name field "<lastName>"
    Then verify that the last name may not be greater than twenty-nine characters.
    Examples:
      | lastName                       |
      | qwertyukjhgfdsazxcvbnmkjhgfdsa |

  @Customer
  Scenario Outline: The last name must be
    Given the user fills last name field "<lastName>"
    And the user clicks "Save"
    Then verify that the last_name is required
    Examples:
      | lastName |
      |          |

  @Customer
  Scenario Outline: Title may not be greater than 50 characters.
    Given the user fills title field "<title>"
    Then verify that the title may not be greater than fifty characters.
    Examples:
      | title                                               |
      | 123456789012345678901234567890123456789012345678901 |

  @Customer
  Scenario Outline: Phone Number may not be greater than 17 characters
    Given the user fills phone number field "<phoneNumber>"
    Then verify that the  phone number may not be greater than seventeen characters
    Examples:
      | phoneNumber        |
      | 123456789012345678 |

  @Customer
  Scenario Outline: The phone number does not contain letters
    Given the user fills phone number field "<phoneNumber>"
    Then verify that the phone number does not contain letters
    Examples:
      | phoneNumber    |
      | asdf13213asdfa |

  @Customer
  Scenario Outline: The phone number must be
    Given the user fills phone number field "<phoneNumber>"
    And the user clicks "Save"
    Then verify that The phone number field is required
    Examples:
      | phoneNumber |
      |             |


