package com.amazon.tests.day13_POM;

import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.MyProfilePage;
import com.amazon.tests.TestBase;
import com.amazon.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyProfileTest extends TestBase {

    @Test
    public void test1() throws InterruptedException {
        //successfully login
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("validEmail1"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("password1"));
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage();
        homePage.myProfileButton.click();

        MyProfilePage myProfilePage = new MyProfilePage();
        myProfilePage.changePasswordUpTitle.click();
        String actual = "Change Password";
        String expected = myProfilePage.changePasswordUpTitle.getText();
        Assert.assertEquals(actual,expected);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(myProfilePage.changePasswordButton));
        Assert.assertTrue(myProfilePage.changePasswordButton.isDisplayed());
        Thread.sleep(3000);
    }

}
