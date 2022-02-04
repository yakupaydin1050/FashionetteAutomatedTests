package de.fashionette.step_definitions;

import de.fashionette.pages.CartPage;
import de.fashionette.pages.ProductsPage;
import de.fashionette.utilities.ConfigurationReader;
import de.fashionette.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class HomePageStepDefs {

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {

       String url = ConfigurationReader.get("url");
       Driver.get().get(url);

    }

    @Given("the user select a product")
    public void theUserSelectAProduct() {
        ProductsPage productsPage = new ProductsPage();
        productsPage.selectProduct();
    }



}
