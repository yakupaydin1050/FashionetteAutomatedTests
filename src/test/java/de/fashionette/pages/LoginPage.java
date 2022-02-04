package de.fashionette.pages;

import com.github.javafaker.Faker;
import de.fashionette.utilities.BrowserUtils;
import org.junit.Assert;
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
        //BrowserUtils.waitForVisibility(loginIcon, 15);
        BrowserUtils.waitFor(3);
        loginIcon.click();
        //BrowserUtils.waitForVisibility(emailField, 15);
        BrowserUtils.waitFor(3);
        emailField.sendKeys(username);
        BrowserUtils.waitForVisibility(passwordField, 15);
        BrowserUtils.waitFor(3);
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
    String expectedNewName = faker.name().firstName();
    String expectedNewLastName = faker.name().lastName();

    public void modifyCustomerInformation(){

        personalData.click();
        customerInformationEdit.click();

        BrowserUtils.waitFor(2);
        nameField.clear();

        BrowserUtils.waitFor(2);
        lastNameField.clear();
        nameField.sendKeys(expectedNewName);
        lastNameField.sendKeys(expectedNewLastName);
        customerInformationSave.click();
    }

    @FindBy (xpath = "//*[@class='account__content__column account__content__column--customer'][1]")
    public WebElement customerInformation;

    public void verifyCustomerInformation(){

        //BrowserUtils.waitForVisibility(customerInformation,15);
        BrowserUtils.waitFor(5);
        String expectedInformation = customerInformation.getText();
        System.out.println("expectedInformation = " + expectedInformation);


    }

    @FindBy (xpath = "//div[@class='account__welcome text__center font-size--hero']")
    public WebElement welcomeMessage;



}
