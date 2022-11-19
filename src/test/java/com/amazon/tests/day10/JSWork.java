package com.amazon.tests.day10;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSWork {

    //click
    //sendkeys
    //scrollup scrolldown

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.ebay.com/");
        WebElement element = driver.findElement(By.cssSelector("#gh-ug>a"));
        //element.click();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", element);
        String expected = "Security Measure";
        String actual = driver.getTitle();
        Assert.assertEquals(actual,expected);

        Thread.sleep(5000);
        WebElement checkBox = driver.findElement(By.cssSelector("#checkbox"));
        javascriptExecutor.executeScript("arguments[0].click();", checkBox);
        //checkBox.click();
    }

    @Test
    public void scrollDown() throws InterruptedException {
        driver.get("https://www.ebay.com/");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        for (int i = 0; i<10; i++){
            javascriptExecutor.executeScript("window.scrollBy(200,0)");
            Thread.sleep(1000);
        }

        for (int i = 0; i<10; i++){
            javascriptExecutor.executeScript("window.scrollBy(-200,0)");
            Thread.sleep(1000);
        }



        Thread.sleep(5000);
    }


}
