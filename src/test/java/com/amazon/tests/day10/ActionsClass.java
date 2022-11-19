package com.amazon.tests.day10;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionsClass {

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
        Actions actions = new Actions(driver);
        //WebElement electronicButton = driver.findElement(By.xpath("(//a[.='Electronics'])[2]"));
        //actions.moveToElement(electronicButton).perform();
        //Thread.sleep(5000);
        List<WebElement> elements = driver.findElements(By.xpath("//li[contains(@data-hover-track,'p2481888')]"));
        for (WebElement element : elements) {
            actions.moveToElement(element).perform();
            Thread.sleep(2000);
        }
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/javascript/droppable");
        WebElement element1 = driver.findElement(By.xpath("//p[.='Drag me to my target']"));
        WebElement element2 = driver.findElement(By.xpath("//p[text()='Drop here']"));


        Actions actions = new Actions(driver);
        actions.dragAndDrop(element1,element2).perform();

        WebElement element3 = driver.findElement(By.xpath("//p[text()='Dropped!']"));

        actions.clickAndHold(element1).moveToElement(element2).pause(3000).release().perform();


        Assert.assertTrue(element3.isDisplayed());

        Thread.sleep(5000);
    }


}


