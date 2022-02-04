
Feature: User should be able to modify user information

  Background:
    Given the user is on the home page

    Scenario: Modify user information
      Given the user logins with valid credentials
      Given the user should be able to modify the name and the surname of the user
      Then verify that after modifying the user should be able to check the changes
