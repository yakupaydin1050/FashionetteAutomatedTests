package de.fashionette.step_definitions;

import de.fashionette.pages.CartPage;
import de.fashionette.pages.HomePage;
import de.fashionette.pages.LoginPage;
import de.fashionette.pages.ProductsPage;
import de.fashionette.utilities.BrowserUtils;
import de.fashionette.utilities.ConfigurationReader;
import de.fashionette.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePageStepDefs {

    Logger log = LoggerFactory.getLogger(HomePageStepDefs.class);
    HomePage homePage = new HomePage();
    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();
    LoginPage loginPage = new LoginPage();


    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        BrowserUtils.waitFor(2);
        homePage.AcceptAllCookies();
        log.info("The user goes to home page");
    }

    @Then("verify that homepage is accessible and full loaded")
    public void verifyThatHomepageIsAccessibleAndFullLoaded() {

        String expectedTitle = "fashionette | Buy designer handbags, shoes & accessories online";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        Assert.assertTrue(loginPage.mainLogo.isEnabled());
        log.info("If the title of the page is correct and the logo is visible, the user is on the correct page.");
    }


    @And("the user should be able to select a product")
    public void theUserShouldBeAbleToSelectAProduct() {
        productsPage.selectProduct();
        log.info("The user selects a product to add to the cart");
    }


    @And("the user selects product details")
    public void theUserSelectsProductDetails() {
        cartPage.selectProductSize();
        log.info("In order to the selected product to be added to the cart, the user has to select the size of some of the selected product.");
    }


}
