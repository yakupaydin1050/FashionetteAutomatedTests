package de.fashionette.pages;

import de.fashionette.utilities.BrowserUtils;
import de.fashionette.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    public CartPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "(//*[@class='btn__content'])[3]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//div[@value='A0167156_36']//span[1]")
    public WebElement selectSize;

    public void selectProductSize(){
        selectSize.click();
    }

    public void productAdder() {
        addToCartButton.click();
    }

    @FindBy (xpath = "//div[@class='cart-item--img']//img")
    public WebElement selectedProductImage;

    @FindBy(xpath = "(//*[contains(text(),'Voucher')])[1]")
    public WebElement voucherButton;

    @FindBy(xpath = "//input[@placeholder='Coupon']")
    public WebElement couponField;

    @FindBy(xpath = "//button[normalize-space()='redeem']")
    public WebElement redeemButton;

    public void applyCoupon() {
        BrowserUtils.waitForVisibility(voucherButton, 10);
        voucherButton.click();
        couponField.sendKeys("qachallenge");
        redeemButton.click();
    }

    @FindBy(xpath = "//td[@class='text__right typography__type-2 cart__subtotal']")
    public WebElement subTotal;

    @FindBy(xpath = "//td[@class='text__right typography__type-2--bold']")
    public WebElement cartTotalPrice;

    @FindBy (xpath = "//span[contains(@data-code,'qachallenge')]")
    public WebElement voucherPrice;

    @FindBy (xpath = "//a[normalize-space()='redeem']")
    public WebElement redeemLink;

    public void getExpectedPrice() {

        String redeemLinkText = redeemLink.getText();
        System.out.println("redeemLinkText = " + redeemLinkText);

        String voucherPriceText = voucherPrice.getText();
        System.out.println("voucherPriceText = " + voucherPriceText);

        String expectedPrice = subTotal.getText();
        System.out.println("expectedPrice = " + expectedPrice);

        String actualPrice = cartTotalPrice.getText();
        System.out.println("actualPrice = " + actualPrice);

        Assert.assertNotEquals(expectedPrice, actualPrice);
    }


}
