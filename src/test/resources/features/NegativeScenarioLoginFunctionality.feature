@smoke
Feature: Login Page Functionality.

  Background:
    Given the user is on the home page
    Then verify that homepage is accessible and full loaded
    When the user should be able to navigate to login page
    Then verify that current url contains "login"
    Then the user should be able to see "WELCOME TO FASHIONETTE!" message

  @login
  Scenario Outline: The application should not allow the user to login invalid e-mail address.
    When the user logs in using following credentials "<invalidEmail>" "<validPassword>"
    Then error message "Sorry, that didn’t work. Please check your email address and password. If you have forgotten your password, you can request a new one by clicking “Forgot password?”." should be displayed

    Examples:
      | invalidEmail                  | validPassword   |
      | jadiel.humphrey@airadding.com | !8Ntr*BM@!#G3VH |
      | nazir.denali@airadding.com    | !8Ntr*BM@!#G3VH |

  @login
  Scenario Outline: The application should not allow the user to login invalid password.
    When the user logs in using following credentials "<validEmail>" "<invalidPassword>"
    Then error message "Sorry, that didn’t work. Please check your email address and password. If you have forgotten your password, you can request a new one by clicking “Forgot password?”." should be displayed

    Examples:
      | validEmail        | invalidPassword  |
      | QA@fashionette.de | 123456789SEa!1   |
      | QA@fashionette.de | *0*QAWasd!!aevfa |

  @login
  Scenario Outline: The application should not allow the user to login invalid e-mail address and invalid password.
    When the user logs in using following credentials "<invalidEmail>" "<invalidPassword>"
    Then error message "Sorry, that didn’t work. Please check your email address and password. If you have forgotten your password, you can request a new one by clicking “Forgot password?”." should be displayed

    Examples:
      | invalidEmail                | invalidPassword |
      | miron.geovani@airadding.com | 9874QWErtyy!?*5 |
      | rourke.shayne@airadding.com | 1*9*+5!qaQWE2ay |


  @login
  Scenario Outline: The password must be correct format.
    When the user logs in using following credentials "<correctEmail>" "<incorrectFormatPassword>"
    Then password error message "The password must be at least 8 characters and contain at least one digit." should be displayed

    Examples:
      | correctEmail      | incorrectFormatPassword |
      | QA@fashionette.de | ab                      |
      | QA@fashionette.de | abcdefg                 |
      | QA@fashionette.de | AdewDSFGAaAESZs         |

  @login
  Scenario Outline: The email field must be fill.
    When the user logs in using following credentials "<email>" "<password>"
    Then error "email" message should be displayed "Please enter your e-mail."

    Examples:
      | email | password        |
      |       | !8Ntr*BM@!#G3VH |

  @login
  Scenario Outline: The password field must be fill.
    When the user logs in using following credentials "<email>" "<password>"
    Then error "password" message should be displayed "Please enter your password."

    Examples:
      | email             | password |
      | QA@fashionette.de |          |

  @login
  Scenario Outline: The email must be correct format
    When the user logs in using following credentials "<email>" "<password>"
    Then error "email" message should be displayed "Please enter your e-mail in the correct format. This address must include an '@' symbol and a full stop'.'."

    Examples:
      | email                     | password      |
      | yakupaydin1050gmail.com   | asdf4a6546789 |
      | yakup@aydin1050@gmail.com | ewrwea9875646 |

  @login
  Scenario: Show password and Hide password functionality
    When the user clicks "Show password" on the login page
    Then verify that password is visible
    When the user clicks "Hide password" on the login page
    Then verify that password is invisible

  @login
  Scenario: Forgot your password functionality
    When the user clicks "Forgot your password?"
    Then verify that the user should be able to see "Forgot your password?" page
    When the user enters email address "yakupaydin1050@gmail.com"
    Then the message "We will send a link for your new password to yakupaydin1050@gmail.com, if a customer account exists for this email address. This may take a few minutes. If you do not receive an email, check the email address you entered and try again." should be displayed


