package de.fashionette.step_definitions;

import de.fashionette.pages.CartPage;
import de.fashionette.pages.ProductsPage;
import de.fashionette.utilities.BrowserUtils;
import de.fashionette.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CartPageDefs {

    Logger log = LoggerFactory.getLogger(CartPageDefs.class);
    CartPage cartPage = new CartPage();

    @Given("the user adds a product to the cart")
    public void theUserAddsAProductToTheCart() {
        cartPage.productAdder();
        log.info("The user selects shoes ");
    }

    @And("the user visits the cart")
    public void theUserVisitsTheCart() {
        cartPage.visitCart();
        log.info("The user goes to the cart to see selected product");
    }

    @Then("verify that current url contains {string}")
    public void verifyThatCurrentUrlContains(String str) {

        BrowserUtils.waitFor(3);
        String actualURL = Driver.get().getCurrentUrl();
        //System.out.println("actualURL = " + actualURL);
        Assert.assertTrue(actualURL.contains(str));
        log.info("The user verifies that he/she is on the correct page ");
    }

    @Then("verify that selected product appeared in the user cart")
    public void verifyThatSelectedProductAppearedInTheUserCart() {

        Assert.assertTrue(cartPage.selectedProductImage.isDisplayed());
        log.info("The user verifies that the object of the product is in the cart");
    }

    @And("the user clicks {string} link")
    public void theUserClicksLink(String str) {

        cartPage.clickVoucher(str);
        log.info("In order to apply a voucher, the voucher link must be clicked");
    }


    @And("the user applies {string} voucher to the coupon field")
    public void theUserAppliesVoucherToTheCouponField(String validVoucher) {

        cartPage.applyValidVoucher(validVoucher);
        log.info("The user has to apply the voucher he/she has");
    }

    @And("the user clicks {string} button")
    public void theUserClicksButton(String str) {
        cartPage.clickRedeemButton(str);
        log.info("The user has to click on the Redeem Button to check whether the coupon is valid or not");

    }

    @Then("verify that the valid voucher is applied properly")
    public void verifyThatTheValidVoucherIsAppliedProperly() {

        Assert.assertTrue(cartPage.cancelIcon.isEnabled());
        Assert.assertTrue(cartPage.reducePrice.isEnabled());
        log.info("if there is a cancel icon or the discount price is displayed, the voucher is  valid and applied correctly");
    }


    @Then("verify that {string} is greater than TOTAL amount")
    public void verifyThatIsGreaterThanTOTALAmount(String subtotal) {

        Assert.assertTrue(cartPage.verifyDiscount(subtotal));
        log.info("I cast the string value as a double.");
        log.info("if the price of product is greater than the total price, a discount is made.");

    }



    @Then("verify that the user should be able to see invalid voucher message")
    public void verifyThatTheUserShouldBeAbleToSeeInvalidVoucherMessage(String voucherErrorMessage) {

            Assert.assertEquals(voucherErrorMessage, cartPage.getVoucherErrorMessage());
            log.info("If an invalid voucher is applied, an error message will appear and verify can be.");
    }


    @Then("verify that {string} equals TOTAL amount")
    public void verifyThatEqualsTOTALAmount(String subtotal) {
        Assert.assertFalse(cartPage.verifyDiscount(subtotal));
        log.info("I cast the string value as a double.");
        log.info("if the price of product equals the total price, a discount is not made.");
    }
}
