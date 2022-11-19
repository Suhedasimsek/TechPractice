package com.amazon.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementSendKeys {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        WebElement element = driver.findElement(By.id("twotabsearchtextbox"));

        element.click();
        element.sendKeys("apple");

        WebElement element2 = driver.findElement(By.id("nav-search-submit-button"));

        element2.click();



    }

}
