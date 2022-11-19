package com.amazon.tests.day8;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DropDown {

    WebDriver driver;


    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/forms/select");
        WebElement dropDownMenu = driver.findElement(By.xpath("(//select[@class='form-select'])[1]"));
        Select select = new Select(dropDownMenu);

        List<WebElement> options = select.getOptions();

        int actual = options.size();
        int expected = 4;

        Assert.assertEquals(actual,expected);

        Thread.sleep(5000);

    }

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }




}
