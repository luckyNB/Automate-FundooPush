package com.fundoopush.pages;

import com.fundoopush.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    @FindBy(id = "mat-input-0")
    WebElement email;
    @FindBy(id = "mat-input-1")
    WebElement password;
    @FindBy(xpath = "//span[@class='mat-button-wrapper']")
    WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void setEmailValue(String emailValue) {
        email.sendKeys(emailValue);
    }

    public void setPasswordValue(String passwordValue) {
        password.sendKeys(passwordValue);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

}
