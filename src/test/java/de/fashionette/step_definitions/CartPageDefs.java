package de.fashionette.step_definitions;

import de.fashionette.pages.CartPage;
import de.fashionette.pages.ProductsPage;
import de.fashionette.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CartPageDefs {

    CartPage cartPage = new CartPage();

    @Given("the user adds a product to the cart")
    public void theUserAddsAProductToTheCart() {
        cartPage.productAdder();
        cartPage.cartIcon.click();
        cartPage.homePage();
    }


    @Then("the user should be able to visit the cart")
    public void theUserShouldBeAbleToVisitTheCart() {
        cartPage.cartIcon.click();

    }

    @Given("the user adds a product to the cart without login")
    public void theUserAddsAProductToTheCartWithoutLogin() {
        cartPage.productAdder();
    }

    @Then("the user applies the valid voucher to the cart")
    public void theUserAppliesTheValidVoucherToTheCart() {
        cartPage.applyCoupon();
    }

    @And("verify that the valid voucher is applied properly")
    public void verifyThatTheValidVoucherIsAppliedProperly() {

        cartPage.getExpectedPrice();
    }
}
