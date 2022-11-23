package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//span[.='Dashboard']")
    public WebElement dashBoardButton;

    @FindBy(xpath = "//span[.='Components']")
    public WebElement componentsButton;

    @FindBy(xpath = "//span[.='Forms']")
    public WebElement formsButton;

    @FindBy(xpath = "//span[.='JavaScript']")
    public WebElement javaScriptButton;

    @FindBy(xpath = "(//span[.='My Profile'])[2]")
    public WebElement myProfileButton;

}
