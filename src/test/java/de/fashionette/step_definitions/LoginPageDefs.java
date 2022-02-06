package de.fashionette.step_definitions;

import de.fashionette.pages.LoginPage;
import de.fashionette.utilities.BrowserUtils;
import de.fashionette.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPageDefs {

    Logger log = LoggerFactory.getLogger(LoginPageDefs.class);
    LoginPage loginPage = new LoginPage();


    @When("the user should be able to login with valid credentials")
    public void theUserShouldBeAbleToLoginWithValidCredentials() {

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        BrowserUtils.waitFor(5);
        loginPage.login(username, password);
        log.info("In the product environment, login to the application with valid credentials.");
    }

    @Then("verify that {string} message is visible")
    public void verifyThatMessageIsVisible(String expectedWelcomeMessage) {

        String actualWelcomeMessage = loginPage.welcomeMessage.getText();
        //System.out.println("actualWelcomeMessage = " + actualWelcomeMessage);
        //System.out.println("expectedWelcomeMessage = " + expectedWelcomeMessage);
        Assert.assertTrue("Welcome Message can NOT appear", actualWelcomeMessage.contains(expectedWelcomeMessage));
        log.info("If the user sees the welcome message on the page, the login is successful");
    }


    @Then("the user clicks {string} menu")
    public void theUserClicksMenu(String str) {

        loginPage.navigateUserInformationMenus(str);
        log.info("To change customer information, it is necessary to go to the personal data.");

    }

    @Then("the user clicks {string}")
    public void theUserClicks(String str) {
        loginPage.editAndSaveMenus(str);
    }

    @Then("the user should be able to modify the name and the surname of the user")
    public void theUserShouldBeAbleToModifyTheNameAndTheSurnameOfTheUser() {

        loginPage.modifyCustomerInformation();
        log.info("first and last name, new information was added randomly after the previous one was cleared.");
    }

    @Then("verify that name and surname have been correctly saved")
    public void verifyThatNameAndSurnameHaveBeenCorrectlySaved() {
        loginPage.verifyCustomerInformation();
        log.info("After save, verification was made with the information in the personal data menu");
    }

    @When("the user should be able to navigate to login page")
    public void theUserShouldBeAbleToNavigateToLoginPage() {
        loginPage.loginIcon.click();
        log.info("In order to log in to the application, it is necessary to click on the login icon");
    }

    @Then("the user should be able to see {string} message")
    public void theUserShouldBeAbleToSeeMessage(String expectedWelcomeMessage) {

        String actualWelcomeMessage = loginPage.loginPageWelcomeMessage.getText();
        System.out.println("actualWelcomeMessage = " + actualWelcomeMessage);
        System.out.println("expectedWelcomeMessage = " + expectedWelcomeMessage);
        Assert.assertEquals(expectedWelcomeMessage, actualWelcomeMessage);
        log.info("If the user sees welcome message, he/she has successful logged in");

    }

    @When("the user logs in using following credentials {string} {string}")
    public void theUserLogsInUsingFollowingCredentials(String email, String password) {
        loginPage.login(email, password);
        log.info("Attempts to login with different valid/invalid credentials.");

    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedLoginErrorMessage) {

        String actualLoginErrorMessage = loginPage.loginErrorMessage.getText();
        System.out.println("actualLoginErrorMessage = " + actualLoginErrorMessage);
        System.out.println("expectedLoginErrorMessage = " + expectedLoginErrorMessage);
        Assert.assertEquals(expectedLoginErrorMessage, actualLoginErrorMessage);
        log.info("If invalid credentials is used, error message appear and verification can be done.");
    }


    @Then("password error message {string} should be displayed")
    public void passwordErrorMessageShouldBeDisplayed(String expectedPasswordErrorMessage) {

        System.out.println("expectedPasswordErrorMessage = " + expectedPasswordErrorMessage);
        String actualPasswordErrorMessage = loginPage.passwordErrorMessage.getText();
        System.out.println("actualPasswordErrorMessage = " + actualPasswordErrorMessage);
        Assert.assertEquals(expectedPasswordErrorMessage, actualPasswordErrorMessage);
        log.info("The password must be at least 8 characters and contain at least one digit.");
    }


    @Then("error {string} message should be displayed {string}")
    public void errorMessageShouldBeDisplayed(String str, String expectedErrorMessage) {

        System.out.println("expectedErrorMessage = " + expectedErrorMessage);
        System.out.println("actualErrorMessage = " + loginPage.actualErrorMessage(str));
        Assert.assertEquals(expectedErrorMessage, loginPage.actualErrorMessage(str));
        log.info("Username must be email and email must contain the @ symbol.");

    }

    @When("the user clicks {string} on the login page")
    public void theUserClicksOnTheLoginPage(String str) {
        loginPage.clickHideAndShowPassword(str);
    }


    @Then("verify that password is visible")
    public void verifyThatPasswordIsVisible() {
        Assert.assertTrue(loginPage.passwordVisible());
        log.info("If the type is password in the HTML block, the password is invisible, if type is text, the password is visible.");
    }


    @Then("verify that password is invisible")
    public void verifyThatPasswordIsInvisible() {
        Assert.assertTrue(loginPage.passwordInvisible());
        log.info("If the type is password in the HTML block, the password is invisible, if type is text, the password is visible.");
    }

    @Then("verify that the user should be able to see {string} page")
    public void verifyThatTheUserShouldBeAbleToSeePage(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.forgotYourPasswordText());
        log.info("When the user clicks the  forgot your password link, he/she sess the forgot your password title.");
    }


    @When("the user enters email address {string}")
    public void theUserEntersEmailAddress(String email) {
        loginPage.setForgotEmailField(email);
        log.info("In order to get a new password again, fill the registered email in the email field.");
    }

    @Then("the message {string} should be displayed")
    public void theMessageShouldBeDisplayed(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.getForgotEmailMessage());
        log.info("The message appears whether the email is registered or not");
    }


}
