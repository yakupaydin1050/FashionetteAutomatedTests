package de.fashionette.step_definitions;

import de.fashionette.pages.BasePage;
import de.fashionette.utilities.ConfigurationReader;
import de.fashionette.utilities.Driver;
import io.cucumber.java.en.Given;

public class HomePageStepDefs {


    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

    }


}
