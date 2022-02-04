package de.fashionette.pages;

import de.fashionette.utilities.BrowserUtils;
import de.fashionette.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage {

    public ProductsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//div[@class='signpost--wrap'][2]")
    public WebElement selectMainProduct;

    @FindBy(xpath = "(//*[@class='product--list__item__image'])[1]")
    public WebElement selectProduct;


    public void selectProduct() {
        selectMainProduct.click();
        BrowserUtils.waitFor(3);
        selectProduct.click();
    }



}
