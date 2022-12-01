package com.amazon.tests.day15_DDF;

import com.amazon.pages.LoginPage;
import com.amazon.tests.TestBase;
import com.amazon.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    @Test
    public void loginAsUser1(){
        driver.get("https://www.krafttechexlab.com/login");
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("validEmail1"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("password1"));
        loginPage.clickLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.krafttechexlab.com/index"));
    }

    @Test
    public void loginAsUser2(){
        driver.get("https://www.krafttechexlab.com/login");
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("validEmail2"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("password2"));
        loginPage.clickLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.krafttechexlab.com/index"));
    }

    @Test
    public void loginAsUser3(){
        driver.get("https://www.krafttechexlab.com/login");
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("validEmail3"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("password3"));
        loginPage.clickLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.krafttechexlab.com/index"));
    }



}
