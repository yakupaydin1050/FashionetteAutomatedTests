package de.fashionette.pages;

import com.github.javafaker.Faker;
import de.fashionette.utilities.BrowserUtils;
import de.fashionette.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//span[@class='icon icon--user']")
    public WebElement loginIcon;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='account__welcome text__center font-size--hero']")
    public WebElement welcomeMessage;

    @FindBy(xpath = "//input[@name='first_name']")
    public WebElement nameField;

    @FindBy(xpath = "//input[@name='last_name']")
    public WebElement lastNameField;

    @FindBy(xpath = "//div[contains(text(),'Save')]")
    public WebElement customerInformationSave;

    @FindBy(xpath = "//*[@class='account__content__column account__content__column--customer'][1]")
    public WebElement customerInformation;

    @FindBy(xpath = "//h1[text()='Welcome to fashionette!']")
    public WebElement loginPageWelcomeMessage;

    @FindBy(xpath = "//div[@class='login__errortext login--modal__response-error']")
    public WebElement loginErrorMessage;

    @FindBy(xpath = "//div[contains(text(),'password')]")
    public WebElement passwordErrorMessage;

    @FindBy (name = "password")
    public WebElement passwordVisibleInvisible;

    @FindBy (xpath = "//div[@class='box__headline']")
    public WebElement forgotYourPassword;

    @FindBy (xpath = "//input[@name='forgotPassword']")
    public WebElement forgotEmailField;

    @FindBy (xpath = "//button[normalize-space()='Reset password']")
    public WebElement resetPasswordButton;

    @FindBy (xpath = "//div[@class='box__content--forgot-password']")
    public WebElement forgotEmailMessage;



    public void login(String username, String password) {

        BrowserUtils.waitFor(3);
        emailField.sendKeys(username);
        BrowserUtils.waitForVisibility(passwordField, 15);
        BrowserUtils.waitFor(3);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    Faker faker = new Faker();
    String expectedNewName = faker.name().firstName();
    String expectedNewLastName = faker.name().lastName();

    public void modifyCustomerInformation() {
        BrowserUtils.waitFor(5);
        nameField.clear();
        nameField.sendKeys(expectedNewName);

        BrowserUtils.waitFor(5);
        lastNameField.clear();
        lastNameField.sendKeys(expectedNewLastName);

    }


    public void verifyCustomerInformation() {

        //BrowserUtils.waitForVisibility(customerInformation,15);
        BrowserUtils.waitFor(5);
        String expectedInformation = customerInformation.getText();
        //System.out.println("expectedInformation = " + expectedInformation);

        ArrayList<String> firstNameAndLastName = new ArrayList<>(Arrays.asList(expectedInformation.split("28")));
        //System.out.println("firstNameAndLastName = " + firstNameAndLastName);
        String ActualFirstNameAndLastName = firstNameAndLastName.get(0).toString().trim();
        String ExpectedFirstNameAndLastName = expectedNewName + " " + expectedNewLastName;

        System.out.println("ActualFirstNameAndLastName = " + ActualFirstNameAndLastName);
        System.out.println("ExpectedFirstNameAndLastName = " + ExpectedFirstNameAndLastName);

        Assert.assertEquals(ExpectedFirstNameAndLastName, ActualFirstNameAndLastName);

    }

    public String actualErrorMessage(String str) {
        return Driver.get().findElement(By.id(""+str+"-error")).getText();
    }

    public void clickHideAndShowPassword(String str){
        Driver.get().findElement(By.xpath("//*[text()='"+str+"']")).click();
    }

    public boolean passwordVisible(){
        BrowserUtils.waitFor(3);
        return passwordVisibleInvisible.getAttribute("type").equals("text");
    }

    public boolean passwordInvisible(){
        BrowserUtils.waitFor(3);
        return passwordVisibleInvisible.getAttribute("type").equals("password");
    }

    public String forgotYourPasswordText(){
        return forgotYourPassword.getText();
    }

    public void setForgotEmailField(String email){
        forgotEmailField.sendKeys(email);
        resetPasswordButton.click();

    }

    public String getForgotEmailMessage(){
        return forgotEmailMessage.getText();
    }




}
