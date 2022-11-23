package com.amazon.tests.day13_POM;

import com.amazon.pages.LoginPage;
import com.amazon.tests.TestBase;
import com.amazon.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void successfulLogin(){
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("validEmail1"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("password1"));
        loginPage.clickLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.krafttechexlab.com/index"));
    }

    @Test
    public void wrongPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("validEmail1"));
        loginPage.passwordInput.sendKeys("aa");
        loginPage.clickLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.krafttechexlab.com/login"));
    }

    @Test
    public void wrongUserName() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys("aa");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("password1"));
        loginPage.clickLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.krafttechexlab.com/login"));
    }
}
