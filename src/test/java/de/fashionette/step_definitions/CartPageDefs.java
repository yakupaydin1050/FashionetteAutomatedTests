package de.fashionette.step_definitions;

import de.fashionette.pages.CartPage;
import de.fashionette.pages.ProductsPage;
import de.fashionette.utilities.BrowserUtils;
import de.fashionette.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

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

    @And("the user clicks {string} link")
    public void theUserClicksLink(String str) {

        cartPage.clickVoucher(str);
    }


    @And("the user applies {string} voucher to the coupon field")
    public void theUserAppliesVoucherToTheCouponField(String validVoucher) {

        cartPage.applyValidVoucher(validVoucher);
    }

    @And("the user clicks {string} button")
    public void theUserClicksButton(String str) {
        cartPage.clickRedeemButton(str);
    }

    @Then("verify that the valid voucher is applied properly")
    public void verifyThatTheValidVoucherIsAppliedProperly() {

        Assert.assertTrue(cartPage.cancelIcon.isEnabled());
        Assert.assertTrue(cartPage.reducePrice.isEnabled());
    }


    @Then("verify that {string} is greater than TOTAL amount")
    public void verifyThatIsGreaterThanTOTALAmount(String subtotal) {

        Assert.assertTrue(cartPage.verifyDiscount(subtotal));
    }



    @Then("verify that the user should be able to see invalid voucher message")
    public void verifyThatTheUserShouldBeAbleToSeeInvalidVoucherMessage(String voucherErrorMessage) {

            Assert.assertEquals(voucherErrorMessage, cartPage.getVoucherErrorMessage());
    }


}
