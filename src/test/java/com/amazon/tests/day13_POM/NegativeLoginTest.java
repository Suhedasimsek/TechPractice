package com.amazon.tests.day13_POM;

import com.amazon.pages.LoginPages;
import com.amazon.tests.TestBase;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class NegativeLoginTest extends TestBase {

        //LoginPages loginPages = new LoginPages();

        @Test
        public void wrongPassword() throws InterruptedException {

            WebDriver driver = Driver.get();
            driver.get(ConfigurationReader.get("url"));
            container.loginPages.usernameInput_loc.sendKeys(ConfigurationReader.get("username"));
            container.loginPages.passwordInput_loc.sendKeys("somepassword");
            container.loginPages.clickButton_loc.click();
            Thread.sleep(3000);
        }

        @Test
        public void wrongUserName() throws InterruptedException {

            Driver.get().get(ConfigurationReader.get("url"));

            container.loginPages.usernameInput_loc.sendKeys("some name");
            container.loginPages.passwordInput_loc.sendKeys(ConfigurationReader.get("password"));
            container.loginPages.clickButton_loc.click();
            Assert.assertEquals(container.loginPages.warningMessage_loc.getText(),
                    "Email address or password is incorrect. Please check",
                    "verify that user is not login");

            Thread.sleep(3000);
        }

    }
