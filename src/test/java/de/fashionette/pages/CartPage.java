package de.fashionette.pages;

import de.fashionette.utilities.BrowserUtils;
import de.fashionette.utilities.Driver;
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

    public void productAdder() {
        selectSize.click();
        addToCartButton.click();
    }

    @FindBy(xpath = "//*[@class='header__cart-icon']")
    public WebElement cartIcon;

    public void homePage() {
        BrowserUtils.waitForVisibility(fashionetteLogo,5);
        fashionetteLogo.click();
        }

}
