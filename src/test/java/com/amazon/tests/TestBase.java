package com.amazon.tests;

import com.amazon.framework.Container;
import com.amazon.pages.LoginPages;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait webDriverWait;

    @BeforeMethod
    public void setUp(){
        driver = Driver.get();
        driver.get(ConfigurationReader.get("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        actions = new Actions(driver);
        webDriverWait = new WebDriverWait(driver,7);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        //Driver.closeDriver();
    }

    protected Container container = new Container();

    private void populateContainers(){
        LoginPages loginPages = new LoginPages();
        PageFactory.initElements(Driver.get(),loginPages);
        container.setLoginPages(loginPages);
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpPages(){
        populateContainers();
    }

}
