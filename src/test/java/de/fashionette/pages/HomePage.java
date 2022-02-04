package de.fashionette.pages;

import de.fashionette.utilities.Driver;

public class HomePage extends BasePage{

    public void acceptAllCookies(){
        Driver.get().switchTo().frame(cookiesIframe);
        acceptAllCookiesButton.click();
    }

}
