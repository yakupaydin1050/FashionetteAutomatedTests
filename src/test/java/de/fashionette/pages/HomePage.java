package de.fashionette.pages;

import de.fashionette.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    public HomePage(){
        PageFactory.initElements(Driver.get(),this);
    }




}
