package de.fashionette.step_definitions;

import de.fashionette.pages.CustomerPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CustomerPageDefs {

    CustomerPage customerPage = new CustomerPage();

    @Given("the user fills first name field {string}")
    public void theUserFillsFirstNameField(String firstName) {
        customerPage.fillFirstNameField(firstName);
    }

    @Then("verify that the first name may not be greater than twenty characters")
    public void verifyThatTheFirstNameMayNotBeGreaterThanTwentyCharacters() {

        String expectedFirstNameMessage = "The \"first name\" may not be greater than 20 characters.";
        Assert.assertEquals(expectedFirstNameMessage, customerPage.getFirstNameErrorMessage());
    }


    @Then("verify that the name should consist of letters only")
    public void verifyThatTheNameShouldConsistOfLettersOnly() {
        Assert.assertTrue(customerPage.firstNameError.isDisplayed(), "The name must consist of only letter");
    }

    @Then("verify that the first name is required.")
    public void verifyThatTheFirstNameIsRequired() {
        String expectedFirstNameMessage = "The \"first name\" field is required.";
        Assert.assertEquals(expectedFirstNameMessage, customerPage.getFirstNameErrorMessage());
    }

    @Given("the user fills last name field {string}")
    public void theUserFillsLastNameField(String lastName) {
        customerPage.fillLastNameField(lastName);

    }

    @Then("verify that the last name may not be greater than twenty-nine characters.")
    public void verifyThatTheLastNameMayNotBeGreaterThanTwentyNineCharacters() {
        String expectedErrorMessage = "The \"last name\" may not be greater than 29 characters.";
        Assert.assertEquals(expectedErrorMessage, customerPage.getLastNameErrorMessage());

    }

    @Then("verify that the last_name is required")
    public void verifyThatTheLast_nameIsRequired() {
        String expectedErrorMessage = "The \"last name\" field is required.";
        Assert.assertEquals(expectedErrorMessage, customerPage.getLastNameErrorMessage());
    }

    @Given("the user fills title field {string}")
    public void theUserFillsTitleField(String title) {
        customerPage.fillTitleField(title);
    }


    @Then("verify that the title may not be greater than fifty characters.")
    public void verifyThatTheTitleMayNotBeGreaterThanFiftyCharacters() {
        String expectedTitleMessage = "That is a lot of text... Please try to use 50 characters at most.";
        Assert.assertEquals(expectedTitleMessage, customerPage.getTitleErrorMessage());
    }

    @Given("the user fills phone number field {string}")
    public void theUserFillsPhoneNumberField(String phoneNumber) {
            customerPage.fillPhoneNumberField(phoneNumber);
    }


    @Then("verify that the  phone number may not be greater than seventeen characters")
    public void verifyThatThePhoneNumberMayNotBeGreaterThanSeventeenCharacters() {
        String expectedPhoneNumberMessage = "The \"phone number\" may not be greater than 17 characters.";
        Assert.assertEquals(expectedPhoneNumberMessage, customerPage.getPhoneNumberErrorMessage());
    }

    @Then("verify that the phone number does not contain letters")
    public void verifyThatThePhoneNumberDoesNotContainLetters() {
        Assert.assertTrue(customerPage.phoneNumberError.isDisplayed(), "The phone number must consist of only digit and special char");
    }

    @Then("verify that The phone number field is required")
    public void verifyThatThePhoneNumberFieldIsRequired() {
        String expectedPhoneNumberMessage = "The \"phone number\" field is required.";
        Assert.assertEquals(expectedPhoneNumberMessage, customerPage.getPhoneNumberErrorMessage());
    }
}
