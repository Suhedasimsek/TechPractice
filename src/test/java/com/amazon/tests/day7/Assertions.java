package com.amazon.tests.day7;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        WebElement sellElement = driver.findElement(By.xpath("//a[.='Sell']"));

        String beklenen = "Eren";
        String gerçek = sellElement.getText();

        Assert.assertEquals(gerçek,beklenen);
    }

    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        WebElement sellElement = driver.findElement(By.xpath("//a[.='Sell']"));

        String actualValue = sellElement.getText(); //Sell
        String expectedValue = "Se";

        Assert.assertTrue(expectedValue.contains(actualValue));


    }

}
