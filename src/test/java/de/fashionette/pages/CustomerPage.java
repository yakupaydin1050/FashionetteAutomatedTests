package de.fashionette.pages;

import de.fashionette.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CustomerPage extends BasePage{

    public CustomerPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (name = "first_name")
    public WebElement firstNameField;

    @FindBy (name = "last_name")
    public WebElement lastNameField;

    @FindBy (name = "title")
    public WebElement titleField;

    @FindBy (name = "phone_number")
    public WebElement phoneNumberField;

    @FindBy (id = "first_name-error")
    public WebElement firstNameError;

    @FindBy (id = "last_name-error")
    public WebElement lastNameError;

    @FindBy (id = "title-error")
    public WebElement titleError;

    @FindBy (id = "phone_number-error")
    public WebElement phoneNumberError;


    public void fillFirstNameField(String firstName){
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void fillLastNameField(String lastName){
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public String getFirstNameErrorMessage(){
        return firstNameError.getText();
    }

    public String getLastNameErrorMessage(){
        return lastNameError.getText();
    }

    public void fillTitleField(String str){
        titleField.clear();
        titleField.sendKeys(str);
    }

    public String getTitleErrorMessage(){
        return titleError.getText();
    }

    public void fillPhoneNumberField (String str){
        phoneNumberField.clear();
        phoneNumberField.sendKeys(str);
    }

    public String getPhoneNumberErrorMessage(){
        return phoneNumberError.getText();
    }


}
