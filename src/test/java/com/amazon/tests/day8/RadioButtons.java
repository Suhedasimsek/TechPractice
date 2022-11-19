package com.amazon.tests.day8;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtons {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/forms/radio");
        WebElement clickedButton = driver.findElement(By.cssSelector("#gridRadios1"));
        Assert.assertFalse(clickedButton.isSelected(), "ilgili butonun seçili olduğunu doğrula");
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/forms/radio");
        WebElement clickedButton = driver.findElement(By.cssSelector("#gridRadios"));
        Assert.assertFalse(clickedButton.isEnabled());
        driver.quit();
    }

    @Test
    public void test3() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/index");
        WebElement radioButton = driver.findElement(By.xpath("(//span[.='Alerts'])[1]/../i"));
        Assert.assertFalse(radioButton.isDisplayed());
        driver.quit();
    }
    @Test
    public void test4() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/index");
        WebElement element = driver.findElement(By.xpath("(//i[@class='bi bi-chevron-down ms-auto'])[2]"));
        element.click();
        WebElement radioButton = driver.findElement(By.xpath("(//span[.='Radio'])[1]/../i"));
        Thread.sleep(3000);
        Assert.assertTrue(radioButton.isDisplayed());
        driver.quit();
    }






}
