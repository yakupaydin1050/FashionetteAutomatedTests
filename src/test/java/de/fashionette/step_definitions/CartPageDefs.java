package de.fashionette.step_definitions;

import de.fashionette.pages.CartPage;
import de.fashionette.pages.ProductsPage;
import de.fashionette.utilities.BrowserUtils;
import de.fashionette.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CartPageDefs {

    CartPage cartPage = new CartPage();

    @Given("the user adds a product to the cart")
    public void theUserAddsAProductToTheCart() {
        cartPage.productAdder();
    }

    @And("the user visits the cart")
    public void theUserVisitsTheCart() {
        cartPage.visitCart();
    }

    @Then("verify that current url contains {string}")
    public void verifyThatCurrentUrlContains(String str) {

        BrowserUtils.waitFor(3);
        String actualURL = Driver.get().getCurrentUrl();
        //System.out.println("actualURL = " + actualURL);
        Assert.assertTrue(actualURL.contains(str));
    }

    @Then("verify that selected product appeared in the user cart")
    public void verifyThatSelectedProductAppearedInTheUserCart() {

        Assert.assertTrue(cartPage.selectedProductImage.isDisplayed());
    }
}
