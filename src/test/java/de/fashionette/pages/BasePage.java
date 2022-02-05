package de.fashionette.pages;

import de.fashionette.utilities.BrowserUtils;
import de.fashionette.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//img[@alt='fashionette']")
    public WebElement fashionetteLogo;

    @FindBy(xpath = "//*[@class='header__cart-icon']")
    public WebElement cartIcon;

    @FindBy(xpath = "//input[@placeholder='Coupon']")
    public WebElement couponField;

    @FindBy(xpath = "//td[@class='text__right typography__type-2 cart__subtotal']")
    public WebElement subTotal;

    @FindBy(xpath = "//td[@class='text__right typography__type-2--bold']")
    public WebElement cartTotalPrice;

    public void visitCart() {
        cartIcon.click();
    }

    public void clickVoucher(String str) {

        WebElement voucherButton = Driver.get().findElement(By.xpath("(//*[contains(text(),'" + str + "')])[1]"));
        BrowserUtils.waitForVisibility(voucherButton, 10);
        voucherButton.click();
    }

    public void applyValidVoucher(String str) {
        couponField.sendKeys(str);
    }

    public void clickRedeemButton(String str){

        WebElement redeemButton = Driver.get().findElement(By.xpath("//button[normalize-space()='"+str+"']"));
        //BrowserUtils.waitForVisibility(redeemButton, 10);
        BrowserUtils.waitFor(3);
        redeemButton.click();
    }

    public boolean verifyDiscount(String str){

        WebElement subTotal = Driver.get().findElement(By.xpath("//td[@class='text__right typography__type-2 cart__"+str+"']"));
        String str1 = subTotal.getText();
        System.out.println("str1 = " + str1);
        BrowserUtils.waitFor(3);
        String str2 = cartTotalPrice.getText();
        System.out.println("str2 = " + str2);

        double subTotalPrice = Double.parseDouble(str1.substring(1));
        System.out.println("subTotalPrice = " + subTotalPrice);
        double totalPrice = Double.parseDouble(str2.substring(1));
        System.out.println("totalPrice = " + totalPrice);

        if (subTotalPrice>totalPrice){
            return true;
        }else {
            return false;
        }
    }


    public void navigateUserInformationMenus(String str) {
        WebElement personalData = Driver.get().findElement(By.xpath("//a[normalize-space()='"+str+"']"));
        personalData.click();
    }

    public void editAndSaveMenus(String str){
        WebElement customerInformationEditandSave = Driver.get().findElement(By.xpath("(//*[text()='"+str+"'])[1]"));
        customerInformationEditandSave.click();
    }

}


