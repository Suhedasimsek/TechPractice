package com.amazon.tests.day14ExtentReports;

import com.amazon.pages.LoginPage;
import com.amazon.tests.TestBase;
import com.amazon.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest(){
        //name of the test
        extentLogger = report.createTest("wrong password test");

        driver.get("https://www.krafttechexlab.com/login");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("enter username");
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("validEmail1"));
        extentLogger.info("enter password");
        loginPage.passwordInput.sendKeys("user");
        extentLogger.info("click login button");
        loginPage.clickLoginButton();

        extentLogger.info("verify page url");
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.krafttechexlab.com/loginWWW"));

        extentLogger.pass("wrong password test is passed");
    }

    @Test
    public void wrongUsernameTest() {
        //name of the test
        extentLogger = report.createTest("wrong username test");

        driver.get("https://www.krafttechexlab.com/login");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("enter username");
        loginPage.usernameInput.sendKeys("user");
        extentLogger.info("enter password");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("password1"));
        extentLogger.info("click login button");
        loginPage.clickLoginButton();

        extentLogger.info("verify page url");
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.krafttechexlab.com/loginWWW"));

        extentLogger.pass("wrong username test is passed");
    }

}
