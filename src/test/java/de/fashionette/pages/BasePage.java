package de.fashionette.pages;

import de.fashionette.utilities.Driver;
import javafx.scene.effect.Shadow;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy (css = "#usercentrics-root")
    public WebElement cookiesIframe;

    @FindBy (xpath = "//button[@role='button']")
    public WebElement acceptAllCookiesButton;





}


