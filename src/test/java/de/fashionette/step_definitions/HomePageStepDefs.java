package de.fashionette.step_definitions;

import de.fashionette.pages.CartPage;
import de.fashionette.pages.HomePage;
import de.fashionette.pages.ProductsPage;
import de.fashionette.utilities.BrowserUtils;
import de.fashionette.utilities.ConfigurationReader;
import de.fashionette.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class HomePageStepDefs {

    HomePage homePage = new HomePage();
    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        BrowserUtils.waitFor(2);
        homePage.AcceptAllCookies();
    }

    @Then("verify that homepage is accessible and full loaded")
    public void verifyThatHomepageIsAccessibleAndFullLoaded() {

        String expectedTitle = "fashionette | Buy designer handbags, shoes & accessories online";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }


    @And("the user should be able to select a product")
    public void theUserShouldBeAbleToSelectAProduct() {
        productsPage.selectProduct();
    }


    @And("the user selects product details")
    public void theUserSelectsProductDetails() {
        cartPage.selectProductSize();
    }


}
