package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {

    public MyProfilePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "(//button[.='Change Password'])[1]")
    public WebElement changePasswordUpTitle;

    @FindBy(xpath = "(//button[.='Change Password'])[2]")
    public WebElement changePasswordButton;



}
