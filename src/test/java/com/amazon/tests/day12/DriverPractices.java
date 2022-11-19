package com.amazon.tests.day12;

import com.amazon.utilities.Driver;
import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DriverPractices {

    //@Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com");
        Thread.sleep(5000);
    }

    //@Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");
        Thread.sleep(5000);
    }

    @Test
    public void test3() throws InterruptedException {
        WebDriver driver = Driver.get();
        driver.get("https://www.google.com");
        //adasdlk
        Thread.sleep(5000);
        //Driver.closeDriver();
    }

    @Test
    public void test4() throws InterruptedException {
        WebDriver driver = Driver.get();
        driver.get("https://www.amazon.com");
        Thread.sleep(5000);
        //Driver.closeDriver();

        driver.findElement(By.cssSelector("alkdjaskf"));
        driver.findElement(By.xpath("alkdjaskf"));

    }
}
