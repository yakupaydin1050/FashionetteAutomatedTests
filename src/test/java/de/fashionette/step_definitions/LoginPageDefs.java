package de.fashionette.step_definitions;

import de.fashionette.pages.LoginPage;
import de.fashionette.utilities.BrowserUtils;
import de.fashionette.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginPageDefs {

    LoginPage loginPage = new LoginPage();

    @Then("the user logins with valid credentials")
    public void theUserLoginsWithValidCredentials() {

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        BrowserUtils.waitFor(3);
        BrowserUtils.waitForVisibility(loginPage.loginIcon,15);
        loginPage.login(username, password);
    }

    @Given("the user should be able to modify the name and the surname of the user")
    public void theUserShouldBeAbleToModifyTheNameAndTheSurnameOfTheUser() {

            loginPage.modifyCustomerInformation();

    }

    @Then("verify that after modifying the user should be able to check the changes")
    public void verifyThatAfterModifyingTheUserShouldBeAbleToCheckTheChanges() {

            loginPage.verifyCustomerInformation();

    }
}
