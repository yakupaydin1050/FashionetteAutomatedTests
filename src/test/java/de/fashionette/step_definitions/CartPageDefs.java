package de.fashionette.step_definitions;

import de.fashionette.pages.CartPage;
import de.fashionette.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CartPageDefs {

    CartPage cartPage = new CartPage();

    @Given("the user adds a product to the cart")
    public void theUserAddsAProductToTheCart() {
        cartPage.productAdder();
        cartPage.cartIcon.click();
    }


    @Then("the user visits the cart after login")
    public void theUserVisitsTheCartAfterLogin() {
        cartPage.cartIcon.click();

    }
}
