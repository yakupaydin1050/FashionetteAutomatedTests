package de.fashionette.step_definitions;

import de.fashionette.pages.CustomerPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class CustomerPageDefs {

    Logger log = LoggerFactory.getLogger(CustomerPageDefs.class);
    CustomerPage customerPage = new CustomerPage();

    @Given("the user fills first name field {string}")
    public void theUserFillsFirstNameField(String firstName) {
        customerPage.fillFirstNameField(firstName);
        log.info("If a first name of more than 20 characters is entered, an error message will appear.");

    }

    @Then("verify that the first name may not be greater than twenty characters")
    public void verifyThatTheFirstNameMayNotBeGreaterThanTwentyCharacters() {

        String expectedFirstNameMessage = "The \"first name\" may not be greater than 20 characters.";
        Assert.assertEquals(expectedFirstNameMessage, customerPage.getFirstNameErrorMessage());
        log.info("I verified with an error message. Verify is done with an error message");

    }


    @Then("verify that the name should consist of letters only")
    public void verifyThatTheNameShouldConsistOfLettersOnly() {
        Assert.assertTrue(customerPage.firstNameError.isDisplayed());
        log.info("On some websites, the first name and last name only have to be letters. No special characters or numbers are used. Since I don't know the regex, I consider it a defect. So I need to read requirement doc.");
    }

    @Then("verify that the first name is required.")
    public void verifyThatTheFirstNameIsRequired() {
        String expectedFirstNameMessage = "The \"first name\" field is required.";
        Assert.assertEquals(expectedFirstNameMessage, customerPage.getFirstNameErrorMessage());
        log.info("If the first name is not written, it gives an error message. I verified with an error message");
    }

    @Given("the user fills last name field {string}")
    public void theUserFillsLastNameField(String lastName) {
        customerPage.fillLastNameField(lastName);
        log.info("If the last name of more than 27 characters is entered, an error message will appear.");

    }

    @Then("verify that the last name may not be greater than twenty-nine characters.")
    public void verifyThatTheLastNameMayNotBeGreaterThanTwentyNineCharacters() {
        String expectedErrorMessage = "The \"last name\" may not be greater than 29 characters.";
        Assert.assertEquals(expectedErrorMessage, customerPage.getLastNameErrorMessage());
        log.info("It gives an error message. I verified with an error message");

    }

    @Then("verify that the last_name is required")
    public void verifyThatTheLast_nameIsRequired() {
        String expectedErrorMessage = "The \"last name\" field is required.";
        Assert.assertEquals(expectedErrorMessage, customerPage.getLastNameErrorMessage());
        log.info("On some websites, the first name and last name only have to be letters. No special characters or numbers are used. Since I don't know the regex, I consider it a defect. So I need to read requirement doc.");
    }

    @Given("the user fills title field {string}")
    public void theUserFillsTitleField(String title) {
        customerPage.fillTitleField(title);
        log.info("I sent the title information of more than 50 characters to verify");
    }


    @Then("verify that the title may not be greater than fifty characters.")
    public void verifyThatTheTitleMayNotBeGreaterThanFiftyCharacters() {
        String expectedTitleMessage = "That is a lot of text... Please try to use 50 characters at most.";
        Assert.assertEquals(expectedTitleMessage, customerPage.getTitleErrorMessage());
        log.info("The title error message was appeared and I verified with an error message.");
    }

    @Given("the user fills phone number field {string}")
    public void theUserFillsPhoneNumberField(String phoneNumber) {
            customerPage.fillPhoneNumberField(phoneNumber);
            log.info("I sent a phone number of more then 17 characters.");
    }


    @Then("verify that the  phone number may not be greater than seventeen characters")
    public void verifyThatThePhoneNumberMayNotBeGreaterThanSeventeenCharacters() {
        String expectedPhoneNumberMessage = "The \"phone number\" may not be greater than 17 characters.";
        Assert.assertEquals(expectedPhoneNumberMessage, customerPage.getPhoneNumberErrorMessage());
        log.info("The Phone Number error message was appeared and I verified with an error message.");
    }

    @Then("verify that the phone number does not contain letters")
    public void verifyThatThePhoneNumberDoesNotContainLetters() {
        Assert.assertTrue(customerPage.phoneNumberError.isDisplayed());
        log.info("On some websites, the the phone number only has to be numbers and special character. No letter is used. Since I don't know the regex, I consider it a defect. So I need to read requirement doc.");
    }

    @Then("verify that The phone number field is required")
    public void verifyThatThePhoneNumberFieldIsRequired() {
        String expectedPhoneNumberMessage = "The \"phone number\" field is required.";
        Assert.assertEquals(expectedPhoneNumberMessage, customerPage.getPhoneNumberErrorMessage());
        log.info("If the phone number is not written, it gives an error message. I verified with an error message");
    }

    @Then("verify that the last name should consist of letters only")
    public void verifyThatTheLastNameShouldConsistOfLettersOnly() {
        Assert.assertTrue(customerPage.lastNameError.isDisplayed());
        log.info("On some websites, the first name and last name only have to be letters. No special characters or numbers are used. Since I don't know the regex, I consider it a defect. So I need to read requirement doc.");
    }
}
