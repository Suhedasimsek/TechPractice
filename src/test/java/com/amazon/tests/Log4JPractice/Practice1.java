package com.amazon.tests.Log4JPractice;

import com.amazon.utilities.AssertUtils;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Practice1 {

    static SoftAssert softAssert = new SoftAssert();

    public static void main(String[] args) {
        /*WebDriver driver = Driver.get();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.tr");
        WebElement searchButton = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        BrowserUtils.sendKeys(searchButton, "Selenium");
        WebElement clickButton = driver.findElement(By.cssSelector("#nav-search-submit-button"));
        BrowserUtils.clickElement(clickButton);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        WebElement targetedText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[3]"));
        String actual = BrowserUtils.getText(targetedText);
        String expected = "\"Selenium\"";
        AssertUtils.assertContains(actual,expected);
        AssertUtils.assertEquals(actual,expected);
        Driver.closeDriver();*/


        WebDriver driver = Driver.get();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.tr");
        WebElement searchButton = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        BrowserUtils.sendKeys(searchButton, "Selenium");
        WebElement clickButton = driver.findElement(By.cssSelector("#nav-search-submit-button"));
        BrowserUtils.clickElement(clickButton);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        WebElement targetedText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[3]"));
        String actual = BrowserUtils.getText(targetedText);
        String expected = "\"Seleniumm\"";
        //softAssert.assertEquals(actual,expected);
        softAssert.assertTrue(actual.contains(expected));
        //AssertUtils.assertContains(actual,expected);
        //AssertUtils.assertEquals(actual,expected);
        Driver.closeDriver();
        softAssert.assertAll();
    }

    @Test
    public void test1(){
        WebDriver driver = Driver.get();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.tr");
        WebElement searchButton = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        BrowserUtils.sendKeys(searchButton, "Selenium");
        WebElement clickButton = driver.findElement(By.cssSelector("#nav-search-submit-button"));
        BrowserUtils.clickElement(clickButton);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        WebElement targetedText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[3]"));
        String actual = BrowserUtils.getText(targetedText);
        String expected = "\"Selenium\"";
        softAssert.assertEquals(actual,expected, actual + " is equal to " + expected);
        softAssert.assertTrue(actual.contains(expected), actual + " contains " + expected);
        //AssertUtils.assertContains(actual,expected);
        //AssertUtils.assertEquals(actual,expected);
        Driver.closeDriver();
        softAssert.assertAll();
    }

}
