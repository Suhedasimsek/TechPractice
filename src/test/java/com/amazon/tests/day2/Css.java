package com.amazon.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Css {

    /*
    (tagName)#id
    (tagName).class
    (tagName)[attribute='value']
    (tagName)[attribute^='tes']
    (tagName)[attribute$='est']
    (tagName)[attribute*='test-contains']
    <css>:nth-of-type(index)
    > --> parent to child
    ' ' --> parent to the any son of child
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));

        //String name = "Aslıhan";

        searchBox.sendKeys("Selenium");

        //WebElement clickButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        WebElement clickButton = driver.findElement(By.id("nav-search-submit-butto"));

        clickButton.click();

        WebElement text = driver.findElement(By.cssSelector(".a-color-state.a-text-bold"));

        System.out.println("text.getText() = " + text.getText());


    }

}
