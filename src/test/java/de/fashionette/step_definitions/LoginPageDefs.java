package de.fashionette.step_definitions;

import de.fashionette.pages.LoginPage;
import de.fashionette.utilities.BrowserUtils;
import de.fashionette.utilities.ConfigurationReader;
import de.fashionette.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPageDefs {

    LoginPage loginPage = new LoginPage();


    @When("the user should be able to login with valid credentials")
    public void theUserShouldBeAbleToLoginWithValidCredentials() {

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        BrowserUtils.waitFor(5);
        loginPage.login(username, password);
    }

    @Then("verify that {string} message is visible")
    public void verifyThatMessageIsVisible(String expectedWelcomeMessage) {

        String actualWelcomeMessage = loginPage.welcomeMessage.getText();
        //System.out.println("actualWelcomeMessage = " + actualWelcomeMessage);
        //System.out.println("expectedWelcomeMessage = " + expectedWelcomeMessage);
        Assert.assertTrue(actualWelcomeMessage.contains(expectedWelcomeMessage));
    }


    @Then("the user clicks {string} menu")
    public void theUserClicksMenu(String str) {

        loginPage.navigateUserInformationMenus(str);

    }

    @Then("the user clicks {string}")
    public void theUserClicks(String str) {
        loginPage.editAndSaveMenus(str);
    }

    @Then("the user should be able to modify the name and the surname of the user")
    public void theUserShouldBeAbleToModifyTheNameAndTheSurnameOfTheUser() {

        loginPage.modifyCustomerInformation();
    }

    @Then("verify that name and surname have been correctly saved")
    public void verifyThatNameAndSurnameHaveBeenCorrectlySaved() {
        loginPage.verifyCustomerInformation();
    }

    @When("the user should be able to navigate to login page")
    public void theUserShouldBeAbleToNavigateToLoginPage() {
        loginPage.loginIcon.click();
    }

    @Then("the user should be able to see {string} message")
    public void theUserShouldBeAbleToSeeMessage(String expectedWelcomeMessage) {

        String actualWelcomeMessage = loginPage.loginPageWelcomeMessage.getText();
        System.out.println("actualWelcomeMessage = " + actualWelcomeMessage);
        System.out.println("expectedWelcomeMessage = " + expectedWelcomeMessage);
        Assert.assertEquals(expectedWelcomeMessage, actualWelcomeMessage);
    }

    @When("the user logs in using following credentials {string} {string}")
    public void theUserLogsInUsingFollowingCredentials(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedLoginErrorMessage) {

        String actualLoginErrorMessage = loginPage.loginErrorMessage.getText();
        System.out.println("actualLoginErrorMessage = " + actualLoginErrorMessage);
        System.out.println("expectedLoginErrorMessage = " + expectedLoginErrorMessage);
        Assert.assertEquals(expectedLoginErrorMessage, actualLoginErrorMessage);

    }


    @Then("password error message {string} should be displayed")
    public void passwordErrorMessageShouldBeDisplayed(String expectedPasswordErrorMessage) {

        System.out.println("expectedPasswordErrorMessage = " + expectedPasswordErrorMessage);
        String actualPasswordErrorMessage = loginPage.passwordErrorMessage.getText();
        System.out.println("actualPasswordErrorMessage = " + actualPasswordErrorMessage);
        Assert.assertEquals(expectedPasswordErrorMessage, actualPasswordErrorMessage);
    }


    @Then("error {string} message should be displayed {string}")
    public void errorMessageShouldBeDisplayed(String str, String expectedErrorMessage) {

        System.out.println("expectedErrorMessage = " + expectedErrorMessage);
        System.out.println("actualErrorMessage = " + loginPage.actualErrorMessage(str));
        Assert.assertEquals(expectedErrorMessage, loginPage.actualErrorMessage(str));

    }


    @When("the user clicks {string} on the login page")
    public void theUserClicksOnTheLoginPage(String str) {
        loginPage.clickHideAndShowPassword(str);
    }


    @Then("verify that password is visible")
    public void verifyThatPasswordIsVisible() {
        Assert.assertTrue(loginPage.passwordVisible());
    }


    @Then("verify that password is invisible")
    public void verifyThatPasswordIsInvisible() {
        Assert.assertTrue(loginPage.passwordInvisible());
    }

    @Then("verify that the user should be able to see {string} page")
    public void verifyThatTheUserShouldBeAbleToSeePage(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.forgotYourPasswordText());
    }


    @When("the user enters email address {string}")
    public void theUserEntersEmailAddress(String email) {
        loginPage.setForgotEmailField(email);
    }

    @Then("the message {string} should be displayed")
    public void theMessageShouldBeDisplayed(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.getForgotEmailMessage());
    }


}
