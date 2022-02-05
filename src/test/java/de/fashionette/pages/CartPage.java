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

    @FindBy (xpath = "//div[@class='cart-item--img']//img")
    public WebElement selectedProductImage;

    @FindBy (xpath = "//a[normalize-space()='redeem']")
    public WebElement reducePrice;

    @FindBy (xpath = "//i[@class='icon icon--inline icon--cross']")
    public WebElement cancelIcon;









    public void selectProductSize(){
        selectSize.click();
    }

    public void productAdder() {
        addToCartButton.click();
    }




}
