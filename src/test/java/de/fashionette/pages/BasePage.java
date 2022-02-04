package de.fashionette.pages;

import de.fashionette.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy (xpath = "//img[@alt='fashionette']")
    public WebElement fashionetteLogo;

    @FindBy(xpath = "//*[@class='header__cart-icon']")
    public WebElement cartIcon;

    public void visitCart(){
        cartIcon.click();
    }

}


