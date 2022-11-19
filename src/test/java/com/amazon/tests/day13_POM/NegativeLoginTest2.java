package com.amazon.tests.day13_POM;

import com.amazon.pages.LoginPages;
import com.amazon.tests.TestBase;
import com.amazon.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest2 extends TestBase {

    LoginPages loginPages = new LoginPages();

    @Test
    public void wrongPassword() throws InterruptedException {

        loginPages.usernameInput_loc.sendKeys(ConfigurationReader.get("username"));
        loginPages.passwordInput_loc.sendKeys("somepassword");
        loginPages.clickButton_loc.click();
        Thread.sleep(3000);
    }

    @Test
    public void wrongUserName() throws InterruptedException {

        loginPages.usernameInput_loc.sendKeys("some name");
        loginPages.passwordInput_loc.sendKeys(ConfigurationReader.get("password"));
        loginPages.clickButton_loc.click();
        Assert.assertEquals(loginPages.warningMessage_loc.getText(),
                "Email address or password is incorrect. Please check",
                "verify that user is not login");

        Thread.sleep(3000);
    }

}
