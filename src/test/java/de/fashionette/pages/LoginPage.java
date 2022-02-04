package de.fashionette.pages;

import de.fashionette.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy (xpath = "//span[@class='icon icon--user']")
    public WebElement loginIcon;

    @FindBy (xpath = "//input[@name='email']")
    public WebElement emailField;

    @FindBy (xpath = "//input[@name='password']")
    public WebElement passwordField;

    @FindBy (xpath = "//button[contains(text(),'Login')]")
    public WebElement loginButton;

    public void login (String username, String password){
        BrowserUtils.waitForVisibility(fashionetteLogo, 5);
        fashionetteLogo.click();
        BrowserUtils.waitForVisibility(fashionetteLogo, 5);
        loginIcon.click();
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

}
