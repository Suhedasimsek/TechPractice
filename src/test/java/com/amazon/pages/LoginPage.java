package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "email")
    public WebElement usernameInput;

    @FindBy(id = "yourPassword")
    public WebElement passwordInput;

    @FindBy(css = ".btn.btn-primary.w-100")
    public WebElement loginButton;

    public void clickLoginButton(){
        loginButton.click();
    }

    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        clickLoginButton();
    }
}
