package de.fashionette.step_definitions;

import de.fashionette.pages.LoginPage;
import de.fashionette.utilities.BrowserUtils;
import de.fashionette.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
}
