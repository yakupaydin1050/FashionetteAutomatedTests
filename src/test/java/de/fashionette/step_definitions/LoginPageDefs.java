package de.fashionette.step_definitions;

import de.fashionette.pages.LoginPage;
import de.fashionette.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;

public class LoginPageDefs {

    LoginPage loginPage = new LoginPage();

    @Then("the user logins with valid credentials")
    public void theUserLoginsWithValidCredentials() {

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        loginPage.login(username, password);
    }

}
