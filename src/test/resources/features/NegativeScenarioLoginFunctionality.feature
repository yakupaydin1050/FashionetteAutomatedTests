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
  Scenario Outline: The password must be at least 8 characters and contain at least one digit.
    When the user logs in using following credentials "<correctEmail>" "<incorrectFormatPassword>"
    Then password error message "The password must be at least 8 characters and contain at least one digit." should be displayed

    Examples:
      | correctEmail      | incorrectFormatPassword |
      | QA@fashionette.de | ab                      |
      | QA@fashionette.de | abcdefg                 |
      | QA@fashionette.de | AdewDSFGAaAESZs         |

  @login
  Scenario Outline: Entered the e-mail must be correct format and include an '@' symbol and a full stop '.'
    When the user logs in using following credentials "<incorrectEmail>" "<validPassword>"
    Then email error message "Please enter your e-mail in the correct format. This address must include an '@' symbol and a full stop'.'." should be displayed

    Examples:
      | incorrectEmail            | validPassword   |
      | yakupaydin1050gmail.com   | !8Ntr*BM@!#G3VH |
      | yakupaydin@1050@gmail.com | !8Ntr*BM@!#G3VH |

  @login
  Scenario Outline: The Email address must be fill.
    When the user logs in using following credentials "<emptyEmail>" "<validPassword>"
    Then email or password error message "Please enter your e-mail." should be displayed

    Examples:
      | emptyEmail | validPassword   |
      |            | !8Ntr*BM@!#G3VH |
      |            | !8Ntr*BM@!#G3VH |

  @login
  Scenario Outline: The password field must be fill.
    When the user logs in using following credentials "<validEmail>" "<emptyPassword>"
    Then email or password error message "Please enter your password." should be displayed

    Examples:
      | validEmail        | emptyPassword |
      | QA@fashionette.de |               |
      | QA@fashionette.de |               |

  @login
  Scenario Outline: The email and password fields must be fill.
    When the user logs in using following credentials "<emptyEmail>" "<emptyPassword>"
    Then error messages "Please enter your e-mail." and "Please enter your password." should be displayed

    Examples:
      | emptyEmail | emptyPassword |
      |            |               |

  @login
  Scenario: Show password and Hide password functionality
    When the user clicks "Show password" on the login page
    Then verify that password is visible
    When the user clicks "Hide password" on the login page
    Then verify that password is invisible

  @login
  Scenario: Forgot your password functionality
    When the user clicks "Forgot your password"
    Then the user should be able to see "Forgot your password?" page
    When the user enters email adress
    Then the message "We will send a link for your new password to ada@gmail.com, if a customer account exists for this email address. This may take a few minutes. If you do not receive an email, check the email address you entered and try again." should be displayed


