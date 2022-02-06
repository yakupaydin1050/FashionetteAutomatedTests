# Fashionette Automated Tests

![Fashionette](https://github.com/yakupaydin1050/FashionetteAutomatedTests/blob/master/src/test/resources/images/logo_Fashionette.png) <br/>
[fashionette | Buy designer handbags, shoes & accessories online ](https://www.fashionette.co.uk/)

## Summary of the task

As stated in the task, after going to the homepage, the user selects a product and logs in to the page. After logging in, it checks the product in the shopping cart and performs other functionalities. In addition, the customer can make a discount on the product she/he applied with a valid voucher. However, the customers can change also their information (Title, First Name, Last Name, Phone Number, etc.). 

The purpose of this task is to automate tests over existing scenarios.

On the other hand, negative tests for the given scenario are developed and automated.

## Selenium-Cucumber-Java

This task contains a collection of sample `selenium-cucumber-java` projects and libraries that demonstrate how to use the tool and develop automation script using the Cucumber (v.5.7.0) BDD framework with Java as programming language. It generate JSON reports as well. It also generate `screen shots` for tests. 

## Installation

1. JDK 1.8+ (make sure Java class path is set) 
2. IntelliJ
3. IntelliJ Plugins for
    - Maven
    - Cucumber v.5.7.0
    - Selenium v.4.0.0 
    - Web Driver Manager v.4.4.3 (Bonigarcia)
    - Cucumber JUnit v.5.7.0
    - Logger slf4j-simple v.1.7.21
    - Java Faker v.1.0.2
4. Browser driver (make sure you have your desired browser driver and Configuration files' path is set)

## Framework set up
Fork / Clone repository from [here](https://github.com/yakupaydin1050/FashionetteAutomatedTests) or download zip and set
it up in your local workspace.

## Executing Task
Open terminal (MAC OSX) or command prompt / power shell (for windows OS) and navigate to the project directory
type `mvn clean test` command to run features. With this command it will invoke the default Google Chrome browser and will
execute the tests.

- To run specific feature if you have multiple feature files use, <br/>
  `mvn test @Scenario02` <br/>
  `mvn test -Dcucumber="src/test/resources/features/Scenario02.feature"` <br/>
 

## Reporters
Once you ran your tests you can generate the various types of reports. This framework `selenium-cucumber-java` uses
several different types of test reporters to communicate pass/failure.

##### HTML Report:

To generate HTML report use  `mvn test -Dcucumber="–plugin html:target/default-html.html"`

##### JSON Report:

To generate a JSON report Use `mvn test -Dcucumber="–plugin json:target/cucumber.json"`

## Jira-XRAY Integration
A connection is provided by importing the cucumber.json file created by cucumber to the Test Execution, which is linked to the Test Case and Bug Ticket created in Jira-XRAY.

## Running from Jenkins


### Automation scripts using BDD approach - Cucumber-Java

There are already many predefined StepDefinitions which is packaged under `de/fashionette/step_definitions`.
Tests are written in the Cucumber framework using the Gherkin Syntax.

##### A typical test will look similar to this:
```
Feature: The user should be able to add a product and login with valid credentials and apply a voucher
Background:
    Given the user is on the home page
    Then verify that homepage is accessible and full loaded
    And the user should be able to select a product
    And the user selects product details
    And the user adds a product to the cart

  Scenario: Add a product to the cart and login
    When the user should be able to navigate to login page
    Then verify that current url contains "login"
    Then the user should be able to see "WELCOME TO FASHIONETTE!" message
    When the user should be able to login with valid credentials
    Then verify that "welcome to your account." message is visible
    And the user visits the cart
    Then verify that current url contains "cart"
    Then verify that selected product appeared in the user cart
```


