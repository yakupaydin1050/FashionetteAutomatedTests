package de.fashionette.pages;

import de.fashionette.utilities.BrowserUtils;
import de.fashionette.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }



    @FindBy(css = "#usercentrics-root")
    public WebElement shadowDomElement;

    public void AcceptAllCookies() {

        SearchContext last = (SearchContext) ((JavascriptExecutor) Driver.get()).executeScript("return arguments[0].shadowRoot", shadowDomElement);
        BrowserUtils.waitFor(2);
        last.findElement(By.cssSelector(".sc-gsDKAQ")).click();

    }


}
