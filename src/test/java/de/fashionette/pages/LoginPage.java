package de.fashionette.pages;

import com.github.javafaker.Faker;
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
        BrowserUtils.waitForVisibility(loginIcon, 15);
        loginIcon.click();
        BrowserUtils.waitForVisibility(emailField, 15);
        emailField.sendKeys(username);
        BrowserUtils.waitForVisibility(passwordField, 15);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    @FindBy (xpath = "(//*[@data-component-name='accordion'])[2]")
    public WebElement personalData;

    @FindBy (xpath = "(//*[text()='Edit'])[1]")
    public WebElement customerInformationEdit;

    @FindBy (xpath = "//input[@name='first_name']")
            public WebElement nameField;

    @FindBy (xpath = "//input[@name='last_name']")
            public WebElement lastNameField;

    @FindBy (xpath = "//div[contains(text(),'Save')]")
            public WebElement customerInformationSave;

    Faker faker = new Faker();


    public void modifyCustomerInformation(){

        personalData.click();
        customerInformationEdit.click();

        BrowserUtils.waitFor(2);
        nameField.clear();

        BrowserUtils.waitFor(2);
        lastNameField.clear();

        String expectedNewName = faker.name().firstName();
        System.out.println("newName = " + expectedNewName);
        nameField.sendKeys(expectedNewName);

        String expectedNewLastName = faker.name().lastName();
        System.out.println("newLastName = " + expectedNewLastName);
        lastNameField.sendKeys(expectedNewLastName);

        customerInformationSave.click();
    }

    @FindBy (xpath = "//*[@class='account__content__column account__content__column--customer'][1]//br[1]")
    public WebElement customerInformation;

    public void verifyCustomerInformation(){


    }

}
